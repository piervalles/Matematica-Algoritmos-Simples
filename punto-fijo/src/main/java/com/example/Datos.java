package com.example;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Datos {
    private String fx;
    private String gx;
    private String d1gx;
    private BigDecimal a;
    private BigDecimal b;

    public void datosEntrada() {
        Scanner escaner = new Scanner(System.in);
        
        System.out.println("Método del Punto Fijo");
        
        // Validación de la función f(x)
        this.fx = leerFuncion(escaner, "Ingrese la función f(x): ");
        // Validación de la función g(x)
        this.gx = leerFuncion(escaner, "Transforme f(x) en una forma equivalente a x = g(x): ");
        //derivada de la función
        this.d1gx = leerFuncion(escaner,"Ingrese la derivada");
        
        System.out.println("Ingrese el intervalo [a, b] para encontrar una solución:");
        
        try {
            System.out.println("Ingrese 'a':");
            String inputA = escaner.nextLine();
            this.a = new BigDecimal(inputA);

            System.out.println("Ingrese 'b':");
            String inputB = escaner.nextLine();
            this.b = new BigDecimal(inputB);

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato no válido. Use punto para decimales (ej: 15.99)");
        }
        
        escaner.close();
    }

    // Método privado que valida las funciones
    private String leerFuncion(Scanner escaner, String mensaje) {
        String funcion;
        String regex = "^[0-9x+\\-*/()^\\s.]*$"; // Expresión regular que solo permite números, 'x', operadores y paréntesis
        
        while (true) {
            System.out.println(mensaje);
            funcion = escaner.nextLine();

            // Validar que solo contenga caracteres permitidos
            if (Pattern.matches(regex, funcion) && funcion.contains("x")) {
                return funcion;  // Solo se acepta si contiene 'x' y es válida
            } else {
                System.out.println("Error: Ingrese una función válida que contenga solo la variable 'x' y caracteres matemáticos.");
            }
        }
    }

    public String getFx() {return fx;}
    public String getGx() {return gx;}
    public BigDecimal getA() {return a;}
    public BigDecimal getB() {return b;}
    public String getD1String() {return d1gx;}
}
