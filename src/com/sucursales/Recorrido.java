/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author yilup
 */
public class Recorrido {

    public void realizarDFS(NodoGrafo nodoActual, int t) {
        if (nodoActual == null) {
            System.out.println("El nodo actual es nulo.");
            return;
        }

        Conjunto<String> visitados = new Conjunto<>();
        Pilas pila = new Pilas(100);
        pila.push(nodoActual);
        visitados.agregar(nodoActual.getNombre());

        int nivel = 0;

        while (!pila.isEmpty() && nivel <= t) {
            int tamañoNivel = 0;
            NodoGrafo[] nodosNivel = new NodoGrafo[100];

            while (!pila.isEmpty() && tamañoNivel < nodosNivel.length) {
                nodosNivel[tamañoNivel] = pila.pop();
                tamañoNivel++;
            }

            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = nodosNivel[i];
                actual.establecerCubierto(true); //marcamos el nodo como cubierto

                for (Nodo<NodoGrafo> conexion = actual.getConexiones().getHead(); conexion != null; conexion = conexion.getNext()) {
                    NodoGrafo vecino = conexion.getElement();
                    if (!visitados.contiene(vecino.getNombre())) {
                        pila.push(vecino);
                        visitados.agregar(vecino.getNombre());
                    }
                }
            }
            nivel++;
        }
    }

    //YA FUNCIONA
    public void realizarBFS(NodoGrafo nodoInicial, int t) {
        if (nodoInicial == null) {
            System.out.println("Nodo inicial o grafo es nulo.");
            return;
        }

        Cola cola = new Cola(100); //ajusta la capacidad según sea necesario
        Conjunto<String> visitados = new Conjunto<>();
        cola.encolar(nodoInicial);
        visitados.agregar(nodoInicial.getNombre());

        int nivel = 0;

        while (!cola.estaVacia() && nivel <= t) {
            int tamañoNivel = cola.getTamaño(); //tamaño de la cola al inicio de cada nivel

            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = cola.desencolar();
                actual.establecerCubierto(true); //marcar el nodo como cubierto

                for (Nodo<NodoGrafo> conexion = actual.getConexiones().getHead(); conexion != null; conexion = conexion.getNext()) {
                    NodoGrafo vecino = conexion.getElement();
                    if (!visitados.contiene(vecino.getNombre())) {
                        cola.encolar(vecino);
                        visitados.agregar(vecino.getNombre());
                    }
                }
            }
            nivel++;
        }
    }

    public void determinarCoberturaComercial(Grafo grafo) {
        int t = AlmacenRed.getT(); //obtener el rango de cobertura desde AlmacenRed

        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (nodoGrafo.esSucursal()) {
                realizarDFS(nodoGrafo, t);
            }
        }
    }
}
