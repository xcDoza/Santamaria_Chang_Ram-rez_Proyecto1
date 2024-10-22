/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author yilup
 */
public class Pilas {
    private NodoGrafo[] elementos;
    private int tope;

    public Pilas(int capacidad) {
        elementos = new NodoGrafo[capacidad];
        tope = -1; // Inicialmente la pila está vacía
    }

    public void push(NodoGrafo nodo) {
        if (tope < elementos.length - 1) {
            tope++;
            elementos[tope] = nodo;
        } else {
            System.out.println("La pila está llena");
        }
    }

    public NodoGrafo pop() {
        if (tope >= 0) {
            NodoGrafo nodo = elementos[tope];
            tope--;
            return nodo;
        } else {
            System.out.println("La pila está vacía");
            return null; // O lanza una excepción
        }
    }

    public boolean isEmpty() {
        return tope == -1;
    }
    
}
