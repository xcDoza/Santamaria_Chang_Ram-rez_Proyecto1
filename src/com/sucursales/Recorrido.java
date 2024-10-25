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
        Pilas pila = new Pilas(100); // Ajusta la capacidad según sea necesario
        pila.push(nodoActual);
        visitados.agregar(nodoActual.getNombre());

        String resultado = "";

        int nivel = 0; // Nivel de profundidad actual
        while (!pila.isEmpty() && nivel <= t) {
            int tamañoNivel = 0; // Cantidad de nodos en el nivel actual
            NodoGrafo[] nodosNivel = new NodoGrafo[100]; // Ajusta la capacidad según sea necesario

            // Sacar todos los nodos del nivel actual de la pila
            while (!pila.isEmpty() && tamañoNivel < nodosNivel.length) {
                nodosNivel[tamañoNivel] = pila.pop();
                tamañoNivel++;
            }

            // Procesar cada nodo del nivel actual
            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = nodosNivel[i];
                resultado += actual.getNombre() + "\n";

                // Estilizar nodo cubierto en el grafo visual
                Node graphNode = graph.getNode(actual.getNombre());
                if (graphNode != null) {
                    graphNode.setAttribute("ui.class", "cubierto");
                }

                // Recorrer las conexiones del nodo actual
                for (Nodo<NodoGrafo> conexion = actual.getConexiones().getHead(); conexion != null; conexion = conexion.getNext()) {
                    NodoGrafo vecino = conexion.getElement();
                    if (!visitados.contiene(vecino.getNombre())) {
                        pila.push(vecino); // Agregar el vecino a la pila
                        visitados.agregar(vecino.getNombre()); // Marcar como visitado
                    }
                }
            }
            nivel++; // Incrementar el nivel de profundidad
        }

        JOptionPane.showMessageDialog(null, resultado);

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

    public void determinarCoberturaComercial(Graph graph, Grafo grafo) {
        int t = AlmacenRed.getT(); // Obtener el rango de cobertura desde AlmacenRed

        // Realizar BFS desde cada sucursal para determinar la cobertura
        for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
            NodoGrafo nodoGrafo = nodo.getElement();
            if (nodoGrafo.esSucursal()) {
                realizarBFS(graph, nodoGrafo, t);
            }
        }
    }

}
