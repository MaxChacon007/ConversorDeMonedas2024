package com.alura.conversor;

import java.util.Scanner;

public class Principal {
              public static void main(String[] args) {
                 // comentario referencia
                String monedas = """
               *********************************************
                                BIENVENIDO
                Divisas disponibles:
                
                    ARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileño
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar estadounidense
                    
               *********************************************
                """;
                System.out.println(monedas);
                // Scanner para preguntar
                Scanner lectura = new Scanner(System.in);
                String respuesta = "";
                do {
                    System.out.println("Ingrese la primera Divisa: ");
                    String inDivOne = lectura.nextLine().toUpperCase();
                    // para hacer una busqueda en la API
                    System.out.println("Ingrese la segunda Divisa: ");
                    String inDivTwo = lectura.nextLine().toUpperCase();
                    System.out.println(" Ingrese El monto a convertir la Divisa de " + inDivOne + " a " + inDivTwo);
                    double valorMoneda;

                    // Dentro del bucle do-while en la clase Principal

                    try {
                        valorMoneda = Double.parseDouble(lectura.nextLine());
                    }catch (Exception e)  {
                        // valida que la divisa ingresa sea la correcta.
                        System.out.println("Error: Ingrese un monto válido.");
                        continue;}
                    // extension de la Api
                        ConexionApi conexionApi = new ConexionApi();
                        var converter = ConexionApi.convertidor(inDivOne, inDivTwo,valorMoneda);
                        double resultado = converter.getConversion_rate() * valorMoneda;
                        System.out.println("El cambio de " + valorMoneda + inDivOne + " se convierte a: "  +  resultado + " " +inDivTwo);
                        System.out.println("¿Quieres intentar nuevamente? (s/n)");
                        respuesta = lectura.nextLine();
                }       while (respuesta.equalsIgnoreCase("s"));

                  System.out.println("Gracias por usar nuestro conversor de divisas.");
                  lectura.close();

    }}