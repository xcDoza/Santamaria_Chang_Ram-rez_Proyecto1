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
 * La clase {@code Nodo} representa un nodo en una lista doblemente enlazada.
 * Cada nodo contiene un elemento y referencias al nodo siguiente y al anterior.
 *
 * @param <T> El tipo de elemento que contendrá el nodo.
 */
public class Nodo<T> {

    /** Referencia al siguiente nodo y al anterior nodo en la lista. */
    private Nodo<T> next, previous;

    /** Elemento que contiene el nodo. */
    private T element;

    /**
     * Crea un nuevo nodo con el elemento especificado.
     *
     * @param element El elemento que contendrá el nodo.
     */
    public Nodo(T element) {
        this.next = null;
        this.previous = null;
        this.element = element;
    }

    /**
     * Obtiene el siguiente nodo en la lista.
     *
     * @return El siguiente nodo.
     */
    public Nodo<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo en la lista.
     *
     * @param next El nodo a establecer como siguiente.
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo anterior en la lista.
     *
     * @return El nodo anterior.
     */
    public Nodo<T> getPrevious() {
        return previous;
    }

    /**
     * Establece el nodo anterior en la lista.
     *
     * @param previous El nodo a establecer como anterior.
     */
    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }

    /**
     * Obtiene el elemento contenido en el nodo.
     *
     * @return El elemento del nodo.
     */
    public T getElement() {
        return element;
    }

    /**
     * Establece el elemento del nodo.
     *
     * @param element El nuevo elemento a establecer.
     */
    public void setElement(T element) {
        this.element = element;
    }
}
