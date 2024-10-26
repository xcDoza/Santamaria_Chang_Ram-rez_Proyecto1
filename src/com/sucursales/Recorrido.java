/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 * La clase {@code Recorrido} realiza diferentes tipos de recorridos (DFS y BFS) en un grafo,
 * determina la cobertura comercial de las sucursales y sugiere nuevas ubicaciones
 * para cubrir áreas no atendidas.
 */
public class Recorrido {

    /**
     * Realiza un recorrido en profundidad (DFS) en el grafo a partir de un nodo específico.
     * Marca los nodos en el rango de cobertura especificado como cubiertos.
     *
     * @param nodoActual El nodo inicial para comenzar el DFS.
     * @param t El rango de cobertura, en niveles, a considerar.
     */
    public void realizarDFS(NodoGrafo nodoActual, int t) {
        if (nodoActual == null) {
            System.out.println("El nodo actual es nulo.");
            return;
        }

        System.out.println("recorrido dfs hecho");
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
                actual.establecerCubierto(true);

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

    /**
     * Realiza un recorrido en anchura (BFS) en el grafo a partir de un nodo específico.
     * Marca los nodos en el rango de cobertura especificado como cubiertos.
     *
     * @param nodoInicial El nodo inicial para comenzar el BFS.
     * @param t El rango de cobertura, en niveles, a considerar.
     */
    public void realizarBFS(NodoGrafo nodoInicial, int t) {
        if (nodoInicial == null) {
            System.out.println("Nodo inicial o grafo es nulo.");
            return;
        }

        System.out.println("recorrido bfs hecho");
        Cola cola = new Cola(100);
        Conjunto<String> visitados = new Conjunto<>();
        cola.encolar(nodoInicial);
        visitados.agregar(nodoInicial.getNombre());

        int nivel = 0;

        while (!cola.estaVacia() && nivel <= t) {
            int tamañoNivel = cola.getTamaño();

            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = cola.desencolar();
                actual.establecerCubierto(true);

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

    /**
     * Determina la cobertura comercial de las sucursales en un grafo.
     * Realiza un recorrido BFS o DFS desde cada nodo marcado como sucursal
     * según el tipo de recorrido especificado en {@code AlmacenRed}.
     *
     * @param grafo El grafo de la red de transporte.
     */
    public void determinarCoberturaComercial(Grafo grafo) {
        int t = AlmacenRed.getT();
        String tipoRecorrido = AlmacenRed.getTipoRecorrido();

        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (nodoGrafo.esSucursal()) {
                if ("BFS".equals(tipoRecorrido)) {
                    realizarBFS(nodoGrafo, t);
                } else if ("DFS".equals(tipoRecorrido)) {
                    realizarDFS(nodoGrafo, t);
                }
            }
        }
    }

    /**
     * Verifica si todas las estaciones están dentro del rango de cobertura de al menos una sucursal.
     *
     * @param grafo El grafo de la red de transporte.
     * @return {@code true} si todas las estaciones están cubiertas; {@code false} en caso contrario.
     */
    public boolean revisarCoberturaTotal(Grafo grafo) {
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (!nodoGrafo.estaCubierto() && !nodoGrafo.esSucursal()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sugiere nuevas ubicaciones para establecer sucursales en estaciones no cubiertas.
     *
     * @param grafo El grafo de la red de transporte.
     * @return Una lista de nombres de estaciones sugeridas para nuevas sucursales.
     */
    public Lista<String> sugerirNuevasSucursales(Grafo grafo) {
        Lista<String> sugerencias = new Lista<>();
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (!nodoGrafo.estaCubierto() && !nodoGrafo.esSucursal()) {
                sugerencias.agregar(nodoGrafo.getNombre());
            }
        }
        return sugerencias;
    }
}