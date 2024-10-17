/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Estacion {

    private String nombre, conexion;

    public Estacion(String nombre) {
        this.nombre = nombre;
        this.conexion = null;
    }

    public Estacion(String nombre, String conexion) {
        this.nombre = nombre;
        this.conexion = conexion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    @Override
    public String toString() {
        if (conexion != null) {
            return nombre + " con conexion a " + conexion;
        }
        return nombre;
    }
}
