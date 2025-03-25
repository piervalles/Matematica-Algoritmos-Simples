package com.example;

public class Intervalos {
    private double a;
    private double b;

    public Intervalos (Variables datos){
        this.a = datos.getA();
        this.b = datos.getB();
        //this.fxString = datos.getFxString();
    }

    public boolean  reglaIntervalos (){
        if (a>=b) {
            System.out.println("Error: \'a\' debe ser menor que \'b\'");
            return false;
        } else {
            return true;
        }
    }
}
