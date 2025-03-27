package com.example;

import java.util.Scanner;

public class Datos {
    private double numero;
    private double exponente;

    public void DatosRecibir(){
        Scanner escaner = new Scanner(System.in);

        System.out.println("Sacar Raíz de todo numero real");
        System.out.println("Ingrese el numero");
        this.numero = escaner.nextDouble();
        System.out.println("Ingrese el exponente de la raíz");
        this.exponente = escaner.nextDouble();
        escaner.close();
    }

    public double getNumero(){ return numero;}
    public double getExponente(){return exponente;}
}
