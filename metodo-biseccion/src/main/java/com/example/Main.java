package com.example;

//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Variables variables = new Variables();
        variables.leerDatosConsola();

        Intervalos intervalos = new Intervalos(variables);
        if (intervalos.reglaIntervalos()) {
            // Solo si el intervalo es válido, ejecutamos Biseccion
            Biseccion biseccion = new Biseccion(variables);
            biseccion.biseccionCalculo();
        }
    }
}
