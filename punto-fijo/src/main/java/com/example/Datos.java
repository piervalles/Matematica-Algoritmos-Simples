package com.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Datos {
    private String fx;
    private String gx;
    private String d1gx;
    private double a;
    private double b;

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
        System.out.println("ingrese \'a\'");
        this.a = escaner.nextDouble();
        System.out.println("ingrese \'b\'");
        this.b = escaner.nextDouble();
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
    public double getA() {return a;}
    public double getB() {return b;}
    public String getD1String() {return d1gx;}
}
