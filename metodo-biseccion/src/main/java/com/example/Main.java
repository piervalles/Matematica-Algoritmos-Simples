package com.example;

import java.util.Scanner;

public class Main {

    private String fxStr;
    private double a;
    private double b;

    public void setFxStr(String fxStr){
        this.fxStr = fxStr;
    }

    public String getFxStr(){
        return fxStr;
    }

    public void setA(double a){
        this.a = a;
    }

    public double getA(){
        return a;
    }

    public void setB(double b){
        this.b = b;
    }

    public double getB(){
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main datos = new Main();

        System.out.println("Ingrese la función f(x): ");
        datos.setFxStr(scanner.nextLine());

        System.out.println("Ingrese el valor de a: ");
        datos.setA(scanner.nextDouble());

        System.out.println("Ingrese el valor de b: ");
        datos.setB(scanner.nextDouble());
    }
}
