/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author xc2do
 */
public class VisualizadorGrafo {

    public static void visualizar(Grafo grafo) {
        Graph graph = new SingleGraph("Grafo de Transporte");

        // Añadir nodos de Grafo a GraphStream
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            Node graphNode = graph.addNode(nodoGrafo.getNombre());
            graphNode.setAttribute("ui.label", nodoGrafo.getNombre());
            if (nodoGrafo.esSucursal()) {
                graphNode.setAttribute("ui.class", "sucursal"); // Estilizar nodos sucursales
            }
        }

        // Añadir aristas de Grafo a GraphStream
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            Lista<NodoGrafo> conexiones = nodoGrafo.getConexiones();
            for (Nodo<NodoGrafo> conexion = conexiones.getHead(); conexion != null; conexion = conexion.getNext()) {
                NodoGrafo nodoConexion = conexion.getElement();
                String edgeId = nodoGrafo.getNombre() + "-" + nodoConexion.getNombre();
                if (graph.getEdge(edgeId) == null && graph.getEdge(nodoConexion.getNombre() + "-" + nodoGrafo.getNombre()) == null) {
                    graph.addEdge(edgeId, nodoGrafo.getNombre(), nodoConexion.getNombre());
                }
            }
        }

        // Añadir estilos CSS directamente en el código Java
        String css = "graph { fill-color: white; }"
                + "node { fill-color: gray; text-mode: normal; }"
                + "node.sucursal { fill-color: red; }"
                + "node.cubierto { fill-color: green; }"
                + "edge { fill-color: black; }";
        graph.setAttribute("ui.stylesheet", css);

        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer = graph.display();

        //con esta linea evitamos que todas las ventanas se cierren al cerrar el grafo
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

        //determinar y mostrar la cobertura comercial
        determinarCoberturaComercial(graph, grafo,);
    }

    private static void determinarCoberturaComercial(Graph graph, Grafo grafo, String nombreSucursal, boolean usarDFS) {
       NodoGrafo sucursal = grafo.obtenerNodoPorNombre(nombreSucursal);
    if (sucursal == null) {
        System.out.println("Sucursal no encontrada.");
        return;
    }
    
    int t = AlmacenRed.getT();
    
    if (usarDFS) {
        realizarDFS(graph, sucursal, t);
    } else {
        realizarBFS(graph, sucursal, t);
    } 
    }

    private static void realizarBFS(Graph graph, NodoGrafo nodoInicial, int t) {
        Cola<NodoGrafo> cola = new Cola<>();
        Conjunto<String> visitados = new Conjunto<>();
        cola.encolar(nodoInicial);
        visitados.agregar(nodoInicial.getNombre());

        int nivel = 0;
        while (!cola.estaVacia() && nivel <= t) {
            int tamañoNivel = cola.lista.getSize(); // Usamos la lista interna de la cola
            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = cola.desencolar();
                Node graphNode = graph.getNode(actual.getNombre());
                graphNode.setAttribute("ui.class", "cubierto"); // Estilizar nodos cubiertos

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
    
    private static void realizarDFS(Graph graph, NodoGrafo nodoActual, int t){
        
    }




}



