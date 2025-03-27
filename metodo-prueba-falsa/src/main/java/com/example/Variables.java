package com.example;

import java.util.Scanner;

public class Variables {
    //definimos las variables que se ingresan por consola por parte del usuario
    //función f(x) y el intervalo [a,b]

    private String fxString;
    private double a;
    private double b;

    public void leerDatosConsola(){
        Scanner escaner = new Scanner(System.in);

        System.out.println("Metodo de Regula Falsi");
        System.out.println("Ingrese la funcion f(x)");
        this.fxString = escaner.nextLine();
        System.out.println("Ingrese el intervalo [a,b] donde se evaluara la función");
        System.out.println("Ingrese \'a\'"); 
        this.a = escaner.nextDouble();
        System.out.println("Ingrese \'b\'");
        this.b = escaner.nextDouble();

        escaner.close();
    }

    public String getFxString() {return fxString;}
    public double getA() {return a;}
    public double getB() {return b;}
}
