package com.example;

public class Main {
    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        Datos datos = new Datos();
        datos.datosEntrada();

        Intervalos intervalos = new Intervalos(datos);
        Bolzano bolzano = new Bolzano(datos);
        Convergencia convergencia = new Convergencia(datos);
        PuntoFijo puntoFijo = new PuntoFijo(datos);
        
        if(intervalos.reglaIntervalos()==true){
            if (bolzano.bolzanoAplicaDecicion()==true) {
                double pnicial = convergencia.puntoInicial();
                puntoFijo.recibirPuntoConvergencia(pnicial);
                System.out.println("Este es el punto inicial "+convergencia.puntoInicial());
                puntoFijo.puntoFijoDesarrollo();
            }
        }
    }
}


/*
 * probar que todo funciona
 * x^2-5*x+6
 * (5*x-6)/x
 * 6/x^2
 */