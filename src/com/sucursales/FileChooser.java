/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sucursales;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author xc2do
 */
/**
 * La clase {@code FileChooser} permite al usuario seleccionar un archivo JSON que
 * representa una red de transporte y cargar su contenido en una instancia de
 * {@link RedDeTransporte}. Utiliza la librería Gson para el análisis del JSON.
 */
public class FileChooser {

    /**
     * Abre un cuadro de diálogo para que el usuario seleccione un archivo JSON, lo lee
     * y convierte su contenido en una instancia de {@link RedDeTransporte}.
     *
     * @return La instancia de {@code RedDeTransporte} construida a partir del archivo JSON,
     *         o {@code null} si ocurre un error o si no se selecciona un archivo.
     */
    public RedDeTransporte loadRedTransporte() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            StringBuilder jsonString = new StringBuilder();

            // Leer el archivo JSON
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    jsonString.append(line);
                }
            } catch (IOException e) {
                return null;
            }

            
            return parseTransportNetwork(jsonString.toString());
        }
        return null;
    }

    /**
     * Convierte una cadena JSON en una instancia de {@link RedDeTransporte}.
     *
     * @param jsonString La cadena JSON que representa la red de transporte.
     * @return La instancia de {@code RedDeTransporte} creada a partir del JSON.
     */
    private RedDeTransporte parseTransportNetwork(String jsonString) {
        Gson gson = new GsonBuilder().create();
        RedDeTransporte transportNetwork = null;

        
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        for (String redName : jsonObject.keySet()) {
            transportNetwork = new RedDeTransporte(redName);
            JsonElement linesElement = jsonObject.get(redName);

            for (JsonElement lineElement : linesElement.getAsJsonArray()) {
                JsonObject lineObject = lineElement.getAsJsonObject();
                for (String lineName : lineObject.keySet()) {
                    Linea linea = new Linea(lineName);
                    JsonElement stationsElement = lineObject.get(lineName);

                    for (JsonElement stationElement : stationsElement.getAsJsonArray()) {
                        if (stationElement.isJsonPrimitive()) {
                            
                            String stationName = stationElement.getAsString();
                            linea.agregarEstacion(new Estacion(stationName));
                        } else if (stationElement.isJsonObject()) {
                            
                            JsonObject connection = stationElement.getAsJsonObject();
                            for (String station : connection.keySet()) {
                                String connectedStation = connection.get(station).getAsString();
                                linea.agregarEstacion(new Estacion(station, connectedStation));
                            }
                        }
                    }

                    transportNetwork.agregarLinea(linea);
                }
            }
        }
        return transportNetwork;
    }
}
