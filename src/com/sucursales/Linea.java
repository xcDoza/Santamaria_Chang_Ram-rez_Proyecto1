/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Linea {

    private String nombre;
    private Lista<Estacion> estaciones;

    public Linea(String nombre) {
        this.nombre = nombre;
        this.estaciones = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista<Estacion> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Lista<Estacion> estaciones) {
        this.estaciones = estaciones;
    }

    public void agregarEstacion(Estacion estacion) {
        estaciones.agregar(estacion);
    }

    @Override
    public String toString() {
        return "Línea: ," + nombre + " Estaciones: " + estaciones;
    }
}
