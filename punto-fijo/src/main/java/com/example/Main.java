package com.example;

public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.datosEntrada();

        Convergencia convergencia = new Convergencia(datos);
        convergencia.derivadaSimbolica();
    }
}

