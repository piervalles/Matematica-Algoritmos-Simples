package com.example;

import java.math.BigDecimal;

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

                BigDecimal puntoInicial = convergencia.puntoInicial();
                //puntoFijo.recibirPuntoConvergencia(puntoInicial);
                //puntoFijo.puntoFijoDesarrollo();

                System.out.println("Este es el punto inicial "+convergencia.puntoInicial());
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