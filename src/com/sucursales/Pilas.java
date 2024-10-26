/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author yilup
 */
/**
 * La clase {@code Pilas} representa una pila de objetos {@code NodoGrafo}.
 * Esta pila tiene un límite de capacidad definido y permite operaciones de apilar (push)
 * y desapilar (pop), además de verificar si está vacía.
 */
public class Pilas {

    /** Arreglo que almacena los elementos de la pila. */
    private NodoGrafo[] elementos;

    /** Índice del elemento en la cima de la pila. */
    private int tope;

    /**
     * Crea una pila con la capacidad especificada.
     *
     * @param capacidad La cantidad máxima de elementos que puede contener la pila.
     */
    public Pilas(int capacidad) {
        elementos = new NodoGrafo[capacidad];
        tope = -1; // Inicialmente la pila está vacía
    }

    /**
     * Inserta un nodo en la cima de la pila.
     *
     * @param nodo El nodo a insertar en la pila.
     */
    public void push(NodoGrafo nodo) {
        if (tope < elementos.length - 1) {
            tope++;
            elementos[tope] = nodo;
        } else {
            System.out.println("La pila está llena");
        }
    }

    /**
     * Retira y devuelve el nodo de la cima de la pila.
     *
     * @return El nodo en la cima de la pila, o {@code null} si la pila está vacía.
     */
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

    /**
     * Verifica si la pila está vacía.
     *
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return tope == -1;
    }
}