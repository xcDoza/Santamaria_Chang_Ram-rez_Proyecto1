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
 * La clase {@code Lista} representa una lista doblemente enlazada genérica,
 * donde cada nodo puede contener un elemento de cualquier tipo especificado.
 * Proporciona métodos para agregar elementos al final de la lista y para
 * mostrar o representar la lista como cadena.
 *
 * @param <T> El tipo de elementos que contendrá la lista.
 */
public class Lista<T> {

    /** Primer y ultimo nodo de la lista. */
    private Nodo<T> head, tail;

    /** Tamaño de la lista (número de elementos). */
    private int size;

    /**
     * Crea una nueva lista vacía.
     */
    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Obtiene el nodo de inicio de la lista.
     *
     * @return El nodo inicial de la lista.
     */
    public Nodo<T> getHead() {
        return head;
    }

    /**
     * Establece el nodo de inicio de la lista.
     *
     * @param head El nodo a establecer como inicio de la lista.
     */
    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    /**
     * Obtiene el nodo final de la lista.
     *
     * @return El nodo final de la lista.
     */
    public Nodo<T> getTail() {
        return tail;
    }

    /**
     * Establece el nodo final de la lista.
     *
     * @param tail El nodo a establecer como final de la lista.
     */
    public void setTail(Nodo<T> tail) {
        this.tail = tail;
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista.
     *
     * @param size El tamaño a establecer para la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Muestra los elementos de la lista en consola.
     */
    public void mostrar() {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.println(actual.getElement());
            actual = actual.getNext();
        }
    }

    /**
     * Agrega un nuevo elemento al final de la lista.
     *
     * @param dato El elemento a agregar.
     */
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            tail.setNext(nuevoNodo);
            nuevoNodo.setPrevious(tail);
            tail = nuevoNodo;
        }
        size++;
    }

    /**
     * Devuelve una representación en cadena de la lista, mostrando
     * todos los elementos separados por comas y entre corchetes.
     *
     * @return Una cadena que representa los elementos de la lista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Nodo<T> actual = head;
        while (actual != null) {
            sb.append(actual.getElement()); // Llama al toString() del elemento
            actual = actual.getNext();
            if (actual != null) {
                sb.append(", "); // Añadir coma si no es el último elemento
            }
        }
        sb.append("]");
        return sb.toString();
    }
}