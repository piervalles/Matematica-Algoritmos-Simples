package com.example;

public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.datosEntrada();

        Intervalos intervalos = new Intervalos(datos);
        Bolzano bolzano = new Bolzano(datos);
        
        if(intervalos.reglaIntervalos()){
            if (bolzano.bolzanoAplicaDecicion()) {
                PuntoFijo puntoFijo = new PuntoFijo(datos);
            }
        }
        
    }
}