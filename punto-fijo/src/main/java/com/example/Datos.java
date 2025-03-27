package com.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Datos {
    private String fx;
    private String gx;
    private BigDecimal a;
    private BigDecimal b;

    public void datosEntrada() {
        Scanner escaner = new Scanner(System.in);

        System.out.println("Método del Punto Fijo");
        System.out.println("Ingrese la función f(x):");
        this.fx = escaner.nextLine();

        System.out.println("Transforme f(x) en una forma equivalente a x = g(x):");
        this.gx = escaner.nextLine();

        System.out.println("Ingrese el intervalo [a, b] para encontrar una solución:");

        try {
            System.out.println("Ingrese 'a':");
            String inputA = escaner.nextLine();
            this.a = new BigDecimal(inputA);

            System.out.println("Ingrese 'b':");
            String inputB = escaner.nextLine();
            this.b = new BigDecimal(inputB);

            System.out.println("Intervalo almacenado correctamente: [a = " + this.a + ", b = " + this.b + "]");

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato no válido. Use punto para decimales (ej: 15.99)");
        }
        escaner.close();
    }

    public String getFx() {return fx;}
    public String getGx() {return gx;}
    public BigDecimal getA() {return a;}
    public BigDecimal getB() {return b;}
}
