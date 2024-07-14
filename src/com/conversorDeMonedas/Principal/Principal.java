package com.conversorDeMonedas.Principal;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int entradaDeMenu = 1;
        double dinero;
        String textoDelMenu = """
                        ****************************************************************
                        Convertidor de divisas, seleccione la moneda que desea convertir:
                        1)Dolar Americano --> Peso Mexicano
                        2)Dolar Americano --> Dolar Canadiense
                        3)Dolar Canadiense --> Peso Mexicano
                        4)Dolar Canadiense --> Dolar Americano
                        5)Peso Mexicano --> Dolar Americano
                        6)Peso Mexicano --> Dolar Canadiense
                        Para salir del programa escriba 7
                        ****************************************************************
                        """;

        Scanner entrada = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (entradaDeMenu != 7) {
            System.out.println(textoDelMenu);
            entradaDeMenu = entrada.nextInt();
            if (entradaDeMenu != 7 && entradaDeMenu <= 7 && entradaDeMenu >= 1) {
                System.out.println("Digite la cantidad a convertir: ");
                dinero = entrada.nextDouble();
                while (dinero <= 0){
                    System.out.println("Digite una cantidad positiva y superior a 0");
                    dinero = entrada.nextDouble();
                }
                conversor.seleccion(entradaDeMenu, dinero);
            } else if (entradaDeMenu != 7) {
                System.out.println("Digite un número entre 1 y 7\n");
            }
        }
    }
}
