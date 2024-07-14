package com.conversorDeMonedas.Principal;

import com.conversorDeMonedas.modelos.Moneda;

import java.io.IOException;

public class Conversor {
    public void seleccion(int entradaDeMenu, double dinero) throws IOException, InterruptedException {
        Moneda conversion = new Moneda();
        conversion.setCantidad(dinero);

        String primerPais = "";
        String segundoPais = "";

        switch (entradaDeMenu) {
            case 1:
                primerPais = "USD";
                segundoPais = "MXN";
                break;
            case 2:
                primerPais = "USD";
                segundoPais = "CAD";
                break;
            case 3:
                primerPais = "CAD";
                segundoPais = "MXN";
                break;
            case 4:
                primerPais = "CAD";
                segundoPais = "USD";
                break;
            case 5:
                primerPais = "MXN";
                segundoPais = "USD";
                break;
            case 6:
                primerPais = "MXN";
                segundoPais = "CAD";
                break;
            default:
                break;
        }

        conversion.setPrimerPais(primerPais);

        // Crear una instancia de Buscador y usarla para buscar la tasa de conversión
        Buscador buscador = new Buscador();
        buscador.buscar(conversion, segundoPais);
    }
}

