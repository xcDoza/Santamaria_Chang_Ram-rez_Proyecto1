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
    private boolean esSucursal; //esto es lo que nos dira si es una sucursal, lo cual es falso por defecto
    private boolean cubierto; //esto nos dide si la parada esta en el rango de cobertura de una sucursal

    public NodoGrafo(String nombre) {
        this.nombre = nombre;
        this.conexiones = new Lista<>();
        this.esSucursal = false;
        this.cubierto = false;
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

    public void establecerSucursal(boolean esSucursal) {
        this.esSucursal = esSucursal;
    }

    public boolean esSucursal() {
        return esSucursal;
    }

    public boolean estaCubierto() {
        return cubierto;
    }

    public void establecerCubierto(boolean cubierto) {
        this.cubierto = cubierto;
    }

    @Override
    public String toString() {
        return "NodoGrafo{"
                + "nombre='" + nombre + '\''
                + ", conexiones=" + conexiones
                + ", esSucursal=" + esSucursal
                + '}';
    }
}
