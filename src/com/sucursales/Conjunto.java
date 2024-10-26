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
 * La clase {@code Conjunto} representa una colección de elementos únicos.
 * Implementa operaciones para verificar la existencia de un elemento y agregar
 * nuevos elementos, evitando duplicados. Utiliza una lista enlazada
 * {@link Lista} para almacenar los elementos.
 *
 * @param <T> El tipo de elementos almacenados en el conjunto.
 */
public class Conjunto<T> {

    /** Lista de elementos del conjunto. */
    private Lista<T> elementos;

    /**
     * Construye un conjunto vacío.
     */
    public Conjunto() {
        this.elementos = new Lista<>();
    }

    /**
     * Verifica si un elemento está presente en el conjunto.
     *
     * @param elemento El elemento a verificar.
     * @return {@code true} si el elemento está en el conjunto, {@code false} en caso contrario.
     */
    public boolean contiene(T elemento) {
        Nodo<T> actual = elementos.getHead();
        while (actual != null) {
            if (actual.getElement().equals(elemento)) {
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    /**
     * Agrega un elemento al conjunto si aún no está presente.
     *
     * @param elemento El elemento a agregar al conjunto.
     */
    public void agregar(T elemento) {
        if (!contiene(elemento)) {
            elementos.agregar(elemento);
        }
    }
}
