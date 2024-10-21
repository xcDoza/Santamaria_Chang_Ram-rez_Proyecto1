/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

/**
 *
 * @author xc2do
 */
public class AlmacenRed {

    private static RedDeTransporte redDeTransporte;
    private static int t = 3; //rango por defecto que cubren las sucursales (red de caracas)

    public static void setRedDeTransporte(RedDeTransporte red) {
        redDeTransporte = red;
    }

    public static RedDeTransporte getRedDeTransporte() {
        return redDeTransporte;
    }

    public static void setT(int nuevoT) {
        t = nuevoT;
    }

    public static int getT() {
        return t;
    }
}
