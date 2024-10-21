/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Conjunto<T> {

    private Lista<T> elementos;

    public Conjunto() {
        this.elementos = new Lista<>();
    }

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

    public void agregar(T elemento) {
        if (!contiene(elemento)) {
            elementos.agregar(elemento);
        }
    }
}
