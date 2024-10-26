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
 * La clase {@code AlmacenRed} actúa como un almacén estático para la configuración
 * y el almacenamiento de una instancia de {@link RedDeTransporte}, así como de
 * configuraciones relacionadas con el tipo de recorrido y el rango de cobertura.
 */
public class AlmacenRed {

    /** La red de transporte almacenada. */
    private static RedDeTransporte redDeTransporte;

    /** Rango por defecto que cubren las sucursales (valor inicial: 3). */
    private static int t = 3;

    /** Tipo de recorrido utilizado en la red de transporte (valor inicial: "BFS"). */
    private static String tipoRecorrido = "BFS";

    /**
     * Establece la instancia de {@link RedDeTransporte} para ser almacenada en esta clase.
     *
     * @param red La instancia de {@code RedDeTransporte} a almacenar.
     */
    public static void setRedDeTransporte(RedDeTransporte red) {
        redDeTransporte = red;
    }

    /**
     * Obtiene la instancia de {@link RedDeTransporte} almacenada.
     *
     * @return La instancia actual de {@code RedDeTransporte}.
     */
    public static RedDeTransporte getRedDeTransporte() {
        return redDeTransporte;
    }

    /**
     * Establece un nuevo valor para el rango de cobertura de las sucursales.
     *
     * @param nuevoT El nuevo rango de cobertura para las sucursales.
     */
    public static void setT(int nuevoT) {
        t = nuevoT;
    }

    /**
     * Obtiene el rango de cobertura de las sucursales.
     *
     * @return El rango actual de cobertura.
     */
    public static int getT() {
        return t;
    }

    /**
     * Obtiene el tipo de recorrido configurado para la red de transporte.
     *
     * @return El tipo de recorrido, por ejemplo, "BFS" o "DFS".
     */
    public static String getTipoRecorrido() {
        return tipoRecorrido;
    }

    /**
     * Establece un nuevo tipo de recorrido para la red de transporte.
     *
     * @param nuevoTipoRecorrido El tipo de recorrido a configurar, como "BFS" o "DFS".
     */
    public static void setTipoRecorrido(String nuevoTipoRecorrido) {
        tipoRecorrido = nuevoTipoRecorrido;
    }
}