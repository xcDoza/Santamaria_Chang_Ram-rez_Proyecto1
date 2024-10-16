/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class RedDeTransporte {

    private String nombreRed;
    private Lista<Linea> lineas;

    public RedDeTransporte(String nombreRed) {
        this.nombreRed = nombreRed;
        this.lineas = new Lista<>();
    }

    public String getNombreRed() {
        return nombreRed;
    }

    public void setNombreRed(String nombreRed) {
        this.nombreRed = nombreRed;
    }

    public Lista<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(Lista<Linea> lineas) {
        this.lineas = lineas;
    }

    public void agregarLinea(Linea linea) {
        lineas.agregar(linea);
    }

    @Override
    public String toString() {
        return "Red: " + nombreRed + ", Líneas: " + lineas;
    }
}
