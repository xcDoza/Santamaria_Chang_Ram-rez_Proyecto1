/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

import static com.sucursales.Grafo.construirGrafo;

/**
 *
 * @author xc2do
 */
public class Main {

    public static void main(String[] args) {
        FileChooser fileChooser = new FileChooser();
        RedDeTransporte red = fileChooser.loadRedTransporte();

        if (red != null) {
            System.out.println("Red de transporte cargada correctamente:");
            System.out.println(red);
            Grafo grafo = construirGrafo(red);
            System.out.println("Grafo de la red de transporte:");
            for (Nodo<NodoGrafo> nodo = grafo.getNodos().getHead(); nodo != null; nodo = nodo.getNext()) {
                System.out.println("Estacion: " + nodo.getElement().getNombre());
                Lista<NodoGrafo> conexiones = nodo.getElement().getConexiones();
                System.out.print("Conexiones: ");
                for (Nodo<NodoGrafo> conexion = conexiones.getHead(); conexion != null; conexion = conexion.getNext()) {
                    System.out.print(conexion.getElement().getNombre() + " ");
                }
                System.out.println();
            }
            
            String nombreSucursal = "Sucursal";
            boolean usarDFS = true;

            // Visualizar el grafo usando GraphStream
            VisualizadorGrafo.visualizar(grafo, nombreSucursal, usarDFS);
        } else {
            System.out.println("Error al cargar la red de transporte.");
        }
    }
}
