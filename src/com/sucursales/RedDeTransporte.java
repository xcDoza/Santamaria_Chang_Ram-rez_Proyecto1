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
    private Grafo grafo; //campo para el grafo

    public RedDeTransporte(String nombreRed) {
        this.nombreRed = nombreRed;
        this.lineas = new Lista<>();
        this.grafo = Grafo.construirGrafo(this); // Construir el grafo al inicializar la red
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
        this.grafo = Grafo.construirGrafo(this); // Reconstruir el grafo si se cambian las líneas
    }

    public void agregarLinea(Linea linea) {
        lineas.agregar(linea);
        this.grafo = Grafo.construirGrafo(this); // Reconstruir el grafo al agregar una línea
    }
    
    public Grafo getGrafo() {
        return grafo;
    }
    
    @Override
    public String toString() {
        return "Red: " + nombreRed + ", Lineas:" + lineas;
    }
}
