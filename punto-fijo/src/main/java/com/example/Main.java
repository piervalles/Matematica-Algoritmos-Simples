package com.example;

public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.datosEntrada();

        Intervalos intervalos = new Intervalos(datos);
        
        if(intervalos.reglaIntervalos()){
            Bolzano bolzano = new Bolzano(datos);
            if (bolzano.bolzanoAplicaDecicion()) {

                Convergencia derivada = new Convergencia(datos);
                PuntoFijo puntoFijo = new PuntoFijo(datos);

                String datoDerivada = derivada.getDerivadaSimbolica();
                puntoFijo.recibirDerivada(datoDerivada);
            }
        }
        
    }
}