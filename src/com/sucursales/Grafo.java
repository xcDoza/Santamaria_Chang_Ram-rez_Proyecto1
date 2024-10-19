/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author xc2do
 */
public class Grafo {

    private Lista<NodoGrafo> nodos; // Lista de estaciones (nodos)
    private Graph graph;

    public Grafo() {
        this.nodos = new Lista<>();
        this.graph = new SingleGraph("Grafo de Transporte");
    }

    // Añadir un nodo al grafo
    public void agregarNodo(NodoGrafo nodo) {
        nodos.agregar(nodo);
        // Añadir el nodo a GraphStream
        graph.addNode(nodo.getNombre()).setAttribute("ui.label", nodo.getNombre());
    }

    // Método para obtener la lista de nodos del grafo
    public Lista<NodoGrafo> getNodos() {
        return nodos;
    }

    // Añadir una conexión (arista) entre dos nodos
    public void agregarArista(NodoGrafo origen, NodoGrafo destino) {
        origen.agregarConexion(destino);
        destino.agregarConexion(origen); // Si es un grafo no dirigido

        // Añadir la arista a GraphStream
        String edgeId = origen.getNombre() + "-" + destino.getNombre();
        if (graph.getEdge(edgeId) == null && graph.getEdge(destino.getNombre() + "-" + origen.getNombre()) == null) {
            graph.addEdge(edgeId, origen.getNombre(), destino.getNombre());
        }
    }

    public NodoGrafo obtenerNodoPorNombre(String nombre) {
        for (Nodo<NodoGrafo> nodo = nodos.getHead(); nodo != null; nodo = nodo.getNext()) {
            if (nodo.getElement().getNombre().equals(nombre)) {
                return nodo.getElement();
            }
        }
        return null; // Retorna null si no encuentra el nodo
    }

    // Método para construir el grafo a partir de la RedDeTransporte
    public static Grafo construirGrafo(RedDeTransporte red) {
        Grafo grafo = new Grafo();
        // Recorrer todas las líneas de la red de transporte
        for (Nodo<Linea> nodoLinea = red.getLineas().getHead(); nodoLinea != null; nodoLinea = nodoLinea.getNext()) {
            Linea linea = nodoLinea.getElement();
            NodoGrafo nodoAnterior = null;  // Para conectar las estaciones adyacentes en la misma línea

            // Recorrer todas las estaciones de la línea
            for (Nodo<Estacion> nodoEstacion = linea.getEstaciones().getHead(); nodoEstacion != null; nodoEstacion = nodoEstacion.getNext()) {
                Estacion estacion = nodoEstacion.getElement();
                // Crear un nodo en el grafo para esta estación si no existe
                NodoGrafo nodoActual = grafo.obtenerNodoPorNombre(estacion.getNombre());
                if (nodoActual == null) {
                    nodoActual = new NodoGrafo(estacion.getNombre());
                    grafo.agregarNodo(nodoActual);
                }

                // Imprimir diagnóstico
                System.out.println("Procesando estacion: " + estacion.getNombre());

                // Si la estación anterior en la línea no es nula, conectar las estaciones
                if (nodoAnterior != null) {
                    grafo.agregarArista(nodoAnterior, nodoActual);
                }

                // Si la estación tiene una conexión (como Capitolio <-> El Silencio), crear también esa conexión
                if (estacion.getConexion() != null) {
                    NodoGrafo nodoConectado = grafo.obtenerNodoPorNombre(estacion.getConexion());
                    if (nodoConectado == null) {
                        nodoConectado = new NodoGrafo(estacion.getConexion());
                        grafo.agregarNodo(nodoConectado);
                    }
                    grafo.agregarArista(nodoActual, nodoConectado);
                }

                // Mover al siguiente nodo
                nodoAnterior = nodoActual;
            }
        }
        return grafo;
    }

    public void visualizar() {
        System.setProperty("org.graphstream.ui", "swing");
        graph.display();
    }
}
