/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
/**
 * La clase {@code RedDeTransporte} representa una red de transporte público compuesta por líneas de estaciones
 * y un grafo que modela las conexiones entre dichas estaciones.
 */
public class RedDeTransporte {

    private String nombreRed;
    private Lista<Linea> lineas;
    private Grafo grafo;

    /**
     * Crea una instancia de {@code RedDeTransporte} con un nombre y una lista vacía de líneas.
     * Inicializa el grafo a partir de las líneas de la red.
     *
     * @param nombreRed El nombre de la red de transporte.
     */
    public RedDeTransporte(String nombreRed) {
        this.nombreRed = nombreRed;
        this.lineas = new Lista<>();
        this.grafo = Grafo.construirGrafo(this);
    }

    /**
     * Obtiene el nombre de la red de transporte.
     *
     * @return El nombre de la red.
     */
    public String getNombreRed() {
        return nombreRed;
    }

    /**
     * Establece el nombre de la red de transporte.
     *
     * @param nombreRed El nuevo nombre de la red.
     */
    public void setNombreRed(String nombreRed) {
        this.nombreRed = nombreRed;
    }

    /**
     * Obtiene la lista de líneas que componen la red de transporte.
     *
     * @return Una lista de líneas.
     */
    public Lista<Linea> getLineas() {
        return lineas;
    }

    /**
     * Establece una nueva lista de líneas para la red de transporte y reconstruye el grafo.
     *
     * @param lineas La nueva lista de líneas.
     */
    public void setLineas(Lista<Linea> lineas) {
        this.lineas = lineas;
        this.grafo = Grafo.construirGrafo(this);
    }

    /**
     * Agrega una línea a la red de transporte y reconstruye el grafo.
     *
     * @param linea La línea que se va a agregar.
     */
    public void agregarLinea(Linea linea) {
        lineas.agregar(linea);
        this.grafo = Grafo.construirGrafo(this);
    }

    /**
     * Obtiene el grafo que representa las conexiones entre estaciones en la red de transporte.
     *
     * @return El grafo de la red de transporte.
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * Agrega una nueva línea a la red de transporte y conecta las estaciones en el grafo.
     * Si una estación ya existe, se utiliza la misma; en caso contrario, se crea una nueva estación y nodo.
     *
     * @param nombreLinea El nombre de la nueva línea.
     * @param estaciones  Lista de nombres de estaciones que componen la línea.
     */
    public void agregarLineaNueva(String nombreLinea, Lista<String> estaciones) {
        Linea nuevaLinea = new Linea(nombreLinea);
        NodoGrafo nodoAnteriorGrafo = null;

        for (Nodo<String> nodoEstacion = estaciones.getHead(); nodoEstacion != null; nodoEstacion = nodoEstacion.getNext()) {
            String nombreEstacion = nodoEstacion.getElement();

            NodoGrafo nodoActual = grafo.obtenerNodoPorNombre(nombreEstacion);
            Estacion estacion;

            if (nodoActual == null) {
                estacion = new Estacion(nombreEstacion);
                nuevaLinea.agregarEstacion(estacion);
                nodoActual = new NodoGrafo(nombreEstacion);
                grafo.agregarNodo(nodoActual);
            } else {
                estacion = new Estacion(nombreEstacion);
                nuevaLinea.agregarEstacion(estacion);
            }

            if (nodoAnteriorGrafo != null) {
                grafo.agregarConexion(nodoAnteriorGrafo.getNombre(), nombreEstacion);
            }
            nodoAnteriorGrafo = nodoActual;
        }

        lineas.agregar(nuevaLinea);
    }

    /**
     * Devuelve una representación en cadena de la red de transporte, incluyendo el nombre de la red y sus líneas.
     *
     * @return Una cadena que representa la red de transporte.
     */
    @Override
    public String toString() {
        return "Red: " + nombreRed + ", Lineas:" + lineas;
    }
}