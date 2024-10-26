/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 * La clase {@code Grafo} representa un grafo no dirigido compuesto por nodos
 * que representan estaciones en una red de transporte. Proporciona métodos
 * para agregar nodos y conexiones entre ellos, y permite construir un grafo
 * a partir de una instancia de {@link RedDeTransporte}.
 */
public class Grafo {

    /** Lista de nodos en el grafo, donde cada nodo representa una estación. */
    private Lista<NodoGrafo> nodos;

    /**
     * Construye un grafo vacío.
     */
    public Grafo() {
        this.nodos = new Lista<>();
    }

    /**
     * Agrega un nodo al grafo.
     *
     * @param nodo El nodo a agregar al grafo.
     */
    public void agregarNodo(NodoGrafo nodo) {
        nodos.agregar(nodo);
    }

    /**
     * Obtiene la lista de nodos en el grafo.
     *
     * @return La lista de nodos en el grafo.
     */
    public Lista<NodoGrafo> getNodos() {
        return nodos;
    }

    /**
     * Agrega una conexión (arista) entre dos nodos en el grafo.
     * En un grafo no dirigido, agrega la conexión en ambos sentidos.
     *
     * @param origen  El nodo de origen de la conexión.
     * @param destino El nodo de destino de la conexión.
     */
    public void agregarArista(NodoGrafo origen, NodoGrafo destino) {
        origen.agregarConexion(destino);
        destino.agregarConexion(origen); // Si es un grafo no dirigido
    }

    /**
     * Busca y obtiene un nodo en el grafo a partir de su nombre.
     *
     * @param nombre El nombre del nodo a buscar.
     * @return El nodo correspondiente al nombre, o {@code null} si no se encuentra.
     */
    public NodoGrafo obtenerNodoPorNombre(String nombre) {
        for (Nodo<NodoGrafo> nodo = nodos.getHead(); nodo != null; nodo = nodo.getNext()) {
            if (nodo.getElement().getNombre().equals(nombre)) {
                return nodo.getElement();
            }
        }
        return null;
    }

    /**
     * Construye un grafo a partir de una instancia de {@link RedDeTransporte}.
     * Cada estación se convierte en un nodo del grafo, y se crean conexiones
     * entre estaciones según se define en la red de transporte.
     *
     * @param red La red de transporte desde la cual construir el grafo.
     * @return El grafo construido.
     */
    public static Grafo construirGrafo(RedDeTransporte red) {
        Grafo grafo = new Grafo();

        // Primero añadir todos los nodos
        for (Nodo<Linea> nodoLinea = red.getLineas().getHead(); nodoLinea != null; nodoLinea = nodoLinea.getNext()) {
            Linea linea = nodoLinea.getElement();
            for (Nodo<Estacion> nodoEstacion = linea.getEstaciones().getHead(); nodoEstacion != null; nodoEstacion = nodoEstacion.getNext()) {
                Estacion estacion = nodoEstacion.getElement();
                NodoGrafo nodoActual = grafo.obtenerNodoPorNombre(estacion.getNombre());
                if (nodoActual == null) {
                    nodoActual = new NodoGrafo(estacion.getNombre());
                    grafo.agregarNodo(nodoActual);
                }

                if (estacion.getConexion() != null) {
                    NodoGrafo nodoConectado = grafo.obtenerNodoPorNombre(estacion.getConexion());
                    if (nodoConectado == null) {
                        nodoConectado = new NodoGrafo(estacion.getConexion());
                        grafo.agregarNodo(nodoConectado);
                    }
                }
            }
        }

        // Luego añadir todas las aristas
        for (Nodo<Linea> nodoLinea = red.getLineas().getHead(); nodoLinea != null; nodoLinea = nodoLinea.getNext()) {
            Linea linea = nodoLinea.getElement();
            NodoGrafo nodoAnterior = null;
            for (Nodo<Estacion> nodoEstacion = linea.getEstaciones().getHead(); nodoEstacion != null; nodoEstacion = nodoEstacion.getNext()) {
                Estacion estacion = nodoEstacion.getElement();
                NodoGrafo nodoActual = grafo.obtenerNodoPorNombre(estacion.getNombre());
                if (nodoAnterior != null) {
                    grafo.agregarArista(nodoAnterior, nodoActual);
                }
                if (estacion.getConexion() != null) {
                    NodoGrafo nodoConectado = grafo.obtenerNodoPorNombre(estacion.getConexion());
                    grafo.agregarArista(nodoActual, nodoConectado);
                }
                nodoAnterior = nodoActual;
            }
        }

        return grafo;
    }

    /**
     * Agrega una conexión entre dos estaciones especificadas por su nombre.
     *
     * @param estacion1 El nombre de la primera estación.
     * @param estacion2 El nombre de la segunda estación.
     */
    public void agregarConexion(String estacion1, String estacion2) {
        NodoGrafo nodo1 = obtenerNodoPorNombre(estacion1);
        NodoGrafo nodo2 = obtenerNodoPorNombre(estacion2);

        if (nodo1 != null && nodo2 != null) {
            agregarArista(nodo1, nodo2);
        } else {
            System.out.println("Una o ambas estaciones no fueron encontradas.");
        }
    }
}