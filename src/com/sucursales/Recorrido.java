/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 *
 * @author yilup
 */
public class Recorrido {

    public void realizarDFS(Graph graph, NodoGrafo nodoActual, int t) {
        if (nodoActual == null) {
            System.out.println("El nodo actual es nulo.");
            return;
        }

        Conjunto<String> visitados = new Conjunto<>();
        Pilas pila = new Pilas(100);
        pila.push(nodoActual);
        visitados.agregar(nodoActual.getNombre());

        String resultado = "";

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
                resultado += actual.getNombre() + "\n";

                // Estilizar nodo cubierto en el grafo visual
                Node graphNode = graph.getNode(actual.getNombre());
                if (graphNode != null) {
                    graphNode.setAttribute("ui.class", "cubierto");
                }

//               
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

        JOptionPane.showMessageDialog(null, resultado);

    }

    //ESTO NO FUNCIONA CORRECTAMENTE
    public void realizarBFS(Graph graph, NodoGrafo nodoInicial, int t) {
        if (nodoInicial == null || graph == null) {
            System.out.println("Nodo inicial o grafo es nulo.");
            return;
        }

        Cola cola = new Cola(100); // Ajusta la capacidad según sea necesario
        Conjunto<String> visitados = new Conjunto<>();
        cola.encolar(nodoInicial);
        visitados.agregar(nodoInicial.getNombre());
        String resultado = "";
        int nivel = 0;

        while (!cola.estaVacia() && nivel <= t) {
            int tamañoNivel = cola.getTamaño(); // Tamaño de la cola al inicio de cada nivel

            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = cola.desencolar();
                Node graphNode = graph.getNode(actual.getNombre());
                if (graphNode != null) {
                    graphNode.setAttribute("ui.class", "cubierto"); // Estilizar nodos cubiertos
                }
                resultado += actual.getNombre() + " ";

                for (Nodo<NodoGrafo> conexion = actual.getConexiones().getHead(); conexion != null; conexion = conexion.getNext()) {
                    NodoGrafo vecino = conexion.getElement();
                    if (!visitados.contiene(vecino.getNombre())) {
                        cola.encolar(vecino);
                        visitados.agregar(vecino.getNombre());
                    }
                }
            }
            nivel++; // Incrementar el nivel después de procesar todos los nodos de este nivel
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    public void determinarCoberturaComercial(Graph graph, Grafo grafo) {
        int t = AlmacenRed.getT(); //obtener el rango de cobertura desde AlmacenRed

        //realizamos BFS desde cada sucursal para determinar la cobertura y esto solo afecta a la parte visual cuando mostramos el grafo
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (nodoGrafo.esSucursal()) {
                realizarBFS(graph, nodoGrafo, t);
            }
        }
    }
}
