/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Lista<T> {

    private Nodo<T> head, tail;
    private int size;

    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Nodo<T> getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Mostrar los elementos de la lista
    public void mostrar() {
        Nodo actual = head;
        while (actual != null) {
            System.out.println(actual.getElement());
            actual = actual.getNext();
        }
    }

    // Agregar un elemento al final de la lista
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
