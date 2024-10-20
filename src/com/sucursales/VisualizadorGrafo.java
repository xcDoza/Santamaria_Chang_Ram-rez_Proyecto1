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

        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer = graph.display();
        
        //con esta linea evitamos que todas las ventanas se cierren al cerrar el grafo
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
}
