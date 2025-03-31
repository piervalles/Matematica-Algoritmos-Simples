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
                BigDecimal puntoConvergencia = convergencia.getPuntoConvergencia();
                puntoFijo.recibirPuntoConvergencia(puntoConvergencia);
                puntoFijo.puntoFijoDesarrollo();
            }
        }
    }
}
