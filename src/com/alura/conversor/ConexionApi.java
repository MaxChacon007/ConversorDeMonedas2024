package com.alura.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    public static DatosApiDivisa convertidor(String inDivOne, String inDivTwo, Double valorMoneda)  {

        //Conexión con la API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/37f301dab5bd013908f5fa7b/pair/"+ inDivOne + "/" + inDivTwo);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response;

        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new  Gson().fromJson(response.body(), DatosApiDivisa.class);


    }}
