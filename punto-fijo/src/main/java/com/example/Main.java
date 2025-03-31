package com.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.datosEntrada();

        Intervalos intervalos = new Intervalos(datos);
        
        if(intervalos.reglaIntervalos()){
            Bolzano bolzano = new Bolzano(datos);
            if (bolzano.bolzanoAplicaDecicion()) {

                Convergencia convergencia = new Convergencia(datos);
                PuntoFijo puntoFijo = new PuntoFijo(datos);

                BigDecimal puntoConvergencia = convergencia.getPuntoInicial();
                puntoFijo.recibirPuntoConvergencia(puntoConvergencia);
            }
        }
        
    }
}