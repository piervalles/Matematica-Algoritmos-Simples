package com.example;

public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.DatosRecibir();

        Raiz raiz = new Raiz(datos);
        raiz.raizDesarrollo();
    }
}