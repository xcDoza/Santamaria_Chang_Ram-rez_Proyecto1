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
 * La clase {@code Linea} representa una línea en una red de transporte,
 * que contiene un nombre y una lista de estaciones.
 */
public class Linea {

    /** Nombre de la línea de transporte. */
    private String nombre;

    /** Lista de estaciones que pertenecen a esta línea. */
    private Lista<Estacion> estaciones;

    /**
     * Crea una nueva instancia de {@code Linea} con el nombre especificado
     * y una lista vacía de estaciones.
     *
     * @param nombre El nombre de la línea.
     */
    public Linea(String nombre) {
        this.nombre = nombre;
        this.estaciones = new Lista<>();
    }

    /**
     * Obtiene el nombre de la línea.
     *
     * @return El nombre de la línea.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la línea.
     *
     * @param nombre El nuevo nombre de la línea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de estaciones de la línea.
     *
     * @return La lista de estaciones de la línea.
     */
    public Lista<Estacion> getEstaciones() {
        return estaciones;
    }

    /**
     * Establece la lista de estaciones de la línea.
     *
     * @param estaciones La nueva lista de estaciones.
     */
    public void setEstaciones(Lista<Estacion> estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * Agrega una estación a la lista de estaciones de la línea.
     *
     * @param estacion La estación a agregar.
     */
    public void agregarEstacion(Estacion estacion) {
        estaciones.agregar(estacion);
    }

    /**
     * Devuelve una representación en cadena de la línea, que incluye
     * su nombre y las estaciones que la componen.
     *
     * @return Una cadena que representa la línea y sus estaciones.
     */
    @Override
    public String toString() {
        return "\nLinea: " + nombre + ", Estaciones: " + estaciones;
    }
}