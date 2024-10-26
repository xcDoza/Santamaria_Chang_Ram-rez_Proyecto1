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

    private static Graph graph;

    public static void visualizar(Grafo grafo) {
        graph = new SingleGraph("Grafo de Transporte");

        //añadir nodos de Grafo a GraphStream
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            Node graphNode = graph.addNode(nodoGrafo.getNombre());
            graphNode.setAttribute("ui.label", nodoGrafo.getNombre());

            //tinta os nodos de rojo si son sucursales
            if (nodoGrafo.esSucursal()) {
                graphNode.setAttribute("ui.class", "sucursal");

            } //tinta los nodos de verde si estan en el rango de cobertura
            else if (nodoGrafo.estaCubierto()) {
                graphNode.setAttribute("ui.class", "cubierto");
            }
        }

        //añadir aristas de Grafo a GraphStream
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
    }
}
