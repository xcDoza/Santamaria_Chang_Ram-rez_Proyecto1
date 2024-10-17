/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class Main {
    public static void main(String[] args) {
        FileChooser loader = new FileChooser();
        RedDeTransporte red = loader.loadRedTransporte();

        // Aquí puedes trabajar con la red de transporte cargada
        if (red != null) {
            System.out.println("Red de transporte cargada con exito.");
            System.out.println(red); // Esto mostrará la red y sus líneas
        } else {
            System.out.println("Error al cargar la red de transporte.");
        }
    }
}
