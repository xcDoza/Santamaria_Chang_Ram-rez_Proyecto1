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
/**
 * La clase {@code VisualizadorGrafo} proporciona un método para visualizar un grafo utilizando la biblioteca GraphStream.
 * Visualiza los nodos y las conexiones del grafo, destacando los nodos que representan sucursales y los que están cubiertos.
 */
public class VisualizadorGrafo {

    private static Graph graph;

    /**
     * Visualiza el grafo proporcionado en una ventana de GraphStream.
     * Cada nodo del grafo será coloreado de acuerdo con sus atributos:
     * <ul>
     *     <li>Rojo para los nodos que representan sucursales.</li>
     *     <li>Verde para los nodos que están dentro del rango de cobertura.</li>
     *     <li>Gris para los nodos restantes.</li>
     * </ul>
     * Las conexiones entre nodos se muestran como aristas en el grafo.
     *
     * @param grafo El grafo de transporte que se desea visualizar.
     */
    public static void visualizar(Grafo grafo) {
        graph = new SingleGraph("Grafo de Transporte");

        // Añadir nodos del grafo a GraphStream
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            Node graphNode = graph.addNode(nodoGrafo.getNombre());
            graphNode.setAttribute("ui.label", nodoGrafo.getNombre());

            // Colorea los nodos según sus atributos
            if (nodoGrafo.esSucursal()) {
                graphNode.setAttribute("ui.class", "sucursal");
            } else if (nodoGrafo.estaCubierto()) {
                graphNode.setAttribute("ui.class", "cubierto");
            }
        }

        // Añadir aristas entre nodos en GraphStream
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            Lista<NodoGrafo> conexiones = nodoGrafo.getConexiones();
            for (Nodo<NodoGrafo> conexion = conexiones.getHead(); conexion != null; conexion = conexion.getNext()) {
                NodoGrafo nodoConexion = conexion.getElement();
                String edgeId = nodoGrafo.getNombre() + "-" + nodoConexion.getNombre();
                
                // Evitar duplicación de aristas
                if (graph.getEdge(edgeId) == null && graph.getEdge(nodoConexion.getNombre() + "-" + nodoGrafo.getNombre()) == null) {
                    graph.addEdge(edgeId, nodoGrafo.getNombre(), nodoConexion.getNombre());
                }
            }
        }

        // Definir el estilo CSS para los elementos del grafo
        String css = "graph { fill-color: white; }"
                + "node { fill-color: gray; text-mode: normal; }"
                + "node.sucursal { fill-color: red; }"
                + "node.cubierto { fill-color: green; }"
                + "edge { fill-color: black; }";
        graph.setAttribute("ui.stylesheet", css);

        // Mostrar el grafo utilizando una ventana de GraphStream
        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
}