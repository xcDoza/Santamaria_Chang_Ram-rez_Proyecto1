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
 * La clase {@code Estacion} representa una estación en una red de transporte,
 * que puede tener una conexión directa a otra estación.
 */
public class Estacion {

    /** Nombre y conexion de la estación. */
    private String nombre, conexion;

    /**
     * Construye una estación con un nombre y sin conexiones.
     *
     * @param nombre El nombre de la estación.
     */
    public Estacion(String nombre) {
        this.nombre = nombre;
        this.conexion = null;
    }

    /**
     * Construye una estación con un nombre y una conexión a otra estación.
     *
     * @param nombre El nombre de la estación.
     * @param conexion El nombre de la estación conectada.
     */
    public Estacion(String nombre, String conexion) {
        this.nombre = nombre;
        this.conexion = conexion;
    }

    /**
     * Obtiene el nombre de la estación.
     *
     * @return El nombre de la estación.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la estación.
     *
     * @param nombre El nuevo nombre de la estación.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la estación conectada.
     *
     * @return El nombre de la estación conectada, o {@code null} si no existe conexión.
     */
    public String getConexion() {
        return conexion;
    }

    /**
     * Establece la conexión a otra estación.
     *
     * @param conexion El nombre de la estación a la que se conecta esta estación.
     */
    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    /**
     * Devuelve una representación en cadena de la estación, indicando su nombre
     * y la conexión a otra estación, si existe.
     *
     * @return Una cadena con la información de la estación y su conexión.
     */
    @Override
    public String toString() {
        if (conexion != null) {
            return nombre + " con conexion a " + conexion;
        }
        return nombre;
    }
}
