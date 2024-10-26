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
 * La clase {@code Cola} implementa una estructura de datos de cola circular
 * para almacenar elementos de tipo {@link NodoGrafo}. Permite operaciones de
 * encolar y desencolar, y controla automáticamente el tamaño y el frente y fin
 * de la cola.
 */
public class Cola {

    /** Arreglo que almacena los elementos de la cola. */
    private NodoGrafo[] elementos;

    /** Índice del frente de la cola. */
    private int frente;

    /** Índice del fin de la cola. */
    private int fin;

    /** Cantidad de elementos actualmente en la cola. */
    private int tamaño;

    /**
     * Construye una cola vacía con una capacidad específica.
     *
     * @param capacidad La capacidad máxima de la cola.
     */
    public Cola(int capacidad) {
        elementos = new NodoGrafo[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    /**
     * Agrega un nodo al final de la cola si hay espacio disponible.
     *
     * @param nodo El nodo de tipo {@code NodoGrafo} que se desea encolar.
     */
    public void encolar(NodoGrafo nodo) {
        if (tamaño < elementos.length) {
            fin = (fin + 1) % elementos.length;
            elementos[fin] = nodo;
            tamaño++;
        } else {
            System.out.println("La cola está llena");
        }
    }

    /**
     * Elimina y retorna el nodo en el frente de la cola.
     *
     * @return El nodo de tipo {@code NodoGrafo} en el frente de la cola,
     *         o {@code null} si la cola está vacía.
     */
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

    /**
     * Verifica si la cola está vacía.
     *
     * @return {@code true} si la cola está vacía, {@code false} en caso contrario.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }

    /**
     * Obtiene el número de elementos actualmente en la cola.
     *
     * @return El tamaño actual de la cola.
     */
    public int getTamaño() {
        return tamaño;
    }
}
