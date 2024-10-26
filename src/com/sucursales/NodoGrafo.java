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
 * La clase {@code NodoGrafo} representa un nodo en un grafo que puede tener
 * conexiones con otros nodos. Cada nodo tiene un nombre, una lista de conexiones,
 * y dos atributos booleanos que indican si es una sucursal y si está cubierto.
 */
public class NodoGrafo {

    /** Nombre del nodo. */
    private String nombre;

    /** Lista de nodos a los que este nodo está conectado. */
    private Lista<NodoGrafo> conexiones;

    /** Indica si este nodo es una sucursal. Falso por defecto. */
    private boolean esSucursal;

    /** Indica si este nodo está dentro del rango de cobertura de una sucursal. */
    private boolean cubierto;

    /**
     * Crea un nuevo nodo con el nombre especificado.
     *
     * @param nombre El nombre del nodo.
     */
    public NodoGrafo(String nombre) {
        this.nombre = nombre;
        this.conexiones = new Lista<>();
        this.esSucursal = false;
        this.cubierto = false;
    }

    /**
     * Obtiene el nombre del nodo.
     *
     * @return El nombre del nodo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega una conexión a otro nodo en el grafo.
     *
     * @param nodo El nodo a conectar.
     */
    public void agregarConexion(NodoGrafo nodo) {
        conexiones.agregar(nodo);
    }

    /**
     * Obtiene la lista de conexiones de este nodo.
     *
     * @return La lista de nodos conectados.
     */
    public Lista<NodoGrafo> getConexiones() {
        return conexiones;
    }

    /**
     * Establece si este nodo es una sucursal.
     *
     * @param esSucursal {@code true} si es una sucursal, {@code false} en caso contrario.
     */
    public void establecerSucursal(boolean esSucursal) {
        this.esSucursal = esSucursal;
    }

    /**
     * Indica si este nodo es una sucursal.
     *
     * @return {@code true} si es una sucursal, {@code false} en caso contrario.
     */
    public boolean esSucursal() {
        return esSucursal;
    }

    /**
     * Indica si este nodo está cubierto por una sucursal.
     *
     * @return {@code true} si está cubierto, {@code false} en caso contrario.
     */
    public boolean estaCubierto() {
        return cubierto;
    }

    /**
     * Establece el estado de cobertura de este nodo.
     *
     * @param cubierto {@code true} si está cubierto, {@code false} en caso contrario.
     */
    public void establecerCubierto(boolean cubierto) {
        this.cubierto = cubierto;
    }

    /**
     * Devuelve una representación en cadena del nodo.
     *
     * @return Una cadena que representa el nodo, incluyendo su nombre, conexiones y estado de sucursal.
     */
    @Override
    public String toString() {
        return "NodoGrafo{"
                + "nombre='" + nombre + '\''
                + ", conexiones=" + conexiones
                + ", esSucursal=" + esSucursal
                + '}';
    }
}