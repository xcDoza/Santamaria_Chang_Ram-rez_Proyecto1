/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Cola {

    private NodoGrafo[] elementos;
    private int frente;
    private int fin;
    private int tamaño;

    public Cola(int capacidad) {
        elementos = new NodoGrafo[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    public void encolar(NodoGrafo nodo) {
        if (tamaño < elementos.length) {
            fin = (fin + 1) % elementos.length;
            elementos[fin] = nodo;
            tamaño++;
        } else {
            System.out.println("La cola está llena");
        }
    }

    public NodoGrafo desencolar() {
        if (tamaño > 0) {
            NodoGrafo nodo = elementos[frente];
            frente = (frente + 1) % elementos.length;
            tamaño--;
            return nodo;
        } else {
            System.out.println("La cola está vacía");
            return null; // O lanza una excepción
        }
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int getTamaño() {
        return tamaño;
    }
}
