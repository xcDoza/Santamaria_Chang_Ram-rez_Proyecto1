/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do    
 */
public class NodoGrafo {

    private String nombre;
    private Lista<NodoGrafo> conexiones;

    public NodoGrafo(String nombre) {
        this.nombre = nombre;
        this.conexiones = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarConexion(NodoGrafo nodo) {
        conexiones.agregar(nodo);
    }

    public Lista<NodoGrafo> getConexiones() {
        return conexiones;
    }

    @Override
    public String toString() {
        return "NodoGrafo{"
                + "nombre='" + nombre + '\''
                + ", conexiones=" + conexiones
                + '}';
    }
}
