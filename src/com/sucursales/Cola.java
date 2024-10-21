/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Cola<T> {

    public Lista<T> lista;

    public Cola() {
        this.lista = new Lista<>();
    }

    public void encolar(T elemento) {
        lista.agregar(elemento);
    }

    public T desencolar() {
        if (lista.getHead() == null) {
            return null;
        }
        T elemento = lista.getHead().getElement();
        lista.setHead(lista.getHead().getNext());
        return elemento;
    }

    public boolean estaVacia() {
        return lista.getHead() == null;
    }
}
