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
    
   public void realizarDFS(NodoGrafo nodoActual, int t) {
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
   
   
   
   
   public void realizarBFS(Graph graph, NodoGrafo nodoInicial, int t) {
        Cola<NodoGrafo> cola = new Cola<>();
        Conjunto<String> visitados = new Conjunto<>();
        cola.encolar(nodoInicial);
        visitados.agregar(nodoInicial.getNombre());

        
        String resultado= "";
        
        
        int nivel = 0;
        while (!cola.estaVacia() && nivel <= t) {
            int tamañoNivel = cola.lista.getSize(); // Usamos la lista interna de la cola
            for (int i = 0; i < tamañoNivel; i++) {
                NodoGrafo actual = cola.desencolar();
                Node graphNode = graph.getNode(actual.getNombre());
                graphNode.setAttribute("ui.class", "cubierto"); // Estilizar nodos cubiertos
                
                resultado += actual.getNombre() + " ";

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
        JOptionPane.showMessageDialog(null, resultado);
   }
   
    
}
