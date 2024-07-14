package com.conversorDeMonedas.Principal;

import com.conversorDeMonedas.modelos.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Buscador {
    public void buscar(Moneda conversion, String segundoPais) throws IOException, InterruptedException {
        double dinero = conversion.getCantidad();
        String primerPais = conversion.getPrimerPais();

        // Enviar cantidad como 1 para obtener la tasa de conversión
        String direccion = "https://api.frankfurter.app/latest?amount=1&from=" + primerPais + "&to=" + segundoPais;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Moneda conversor = gson.fromJson(json, Moneda.class);

        // Obtener la tasa de conversión y calcular el resultado
        Double tasaConversion = conversor.getTasas().get(segundoPais);
        if (tasaConversion != null) {
            double resultado = dinero * tasaConversion;
            System.out.println("El resultado de la conversión es: " + resultado);
        } else {
            System.out.println("Error: No se encontró la tasa de conversión para " + segundoPais);
        }
    }
}

