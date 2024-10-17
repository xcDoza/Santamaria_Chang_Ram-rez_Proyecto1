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
public class FileChooser {

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
                e.printStackTrace();
                return null; // Manejo de errores
            }

            // Usar Gson para convertir el JSON a RedDeTransporte
            return parseTransportNetwork(jsonString.toString());
        }
        return null; // Si no se seleccionó ningún archivo
    }

    private RedDeTransporte parseTransportNetwork(String jsonString) {
        Gson gson = new GsonBuilder().create();
        RedDeTransporte transportNetwork = null;

        // Convertir el JSON a JsonObject
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
                            // Si es un nombre de estación
                            String stationName = stationElement.getAsString();
                            linea.agregarEstacion(new Estacion(stationName));
                        } else if (stationElement.isJsonObject()) {
                            // Si es una conexión
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
