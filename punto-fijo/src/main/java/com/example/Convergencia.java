package com.example;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

public class Convergencia {

    private Datos datos;

    public Convergencia(Datos datos){
        this.datos = datos;
    }

    private Double puntoConvergencia(){
        String dgx = datos.getD1String();
        double a = datos.getA();
        double b = datos.getB();
        Double dgA = null;
        Double dgB = null;

        try {
            Expression expression = new Expression(dgx);

            EvaluationValue eDGA = expression.with("x", a).evaluate();
            dgA = eDGA.getNumberValue().doubleValue();

            EvaluationValue eDGB = expression.with("x", b).evaluate();
            dgB = eDGB.getNumberValue().doubleValue();

        } catch (Exception e) {
            System.out.println("Error al evaluar las expresiones: " + e.getMessage());
            System.exit(0);
        }
        if (dgA == null || dgB == null) {
            System.out.println("Error al evaluar la derivada g(x) en [a,b]");
            return null;
        }

        if (dgA >=1 && dgB>=1) {
            System.out.println("El x=g(x) no cumple con el criterio de convergencia");
            return null;
        }
        
        //Seleccionamos el punto inicial (A o B) basado en la condición de convergencia
        if (Math.abs(dgA)<1 || Math.abs(dgB)<1) {
            if (Math.abs(dgA)<1) {
                return a;
            } else {
                return b;
            }
        } 

        return null;
    }

    public Double puntoInicial(){
        Double punto = puntoConvergencia();
        if(punto == null){
            System.out.println("No se pudo determinar el punto inicial.");
            System.exit(1);
        }
        return punto;
    }
}
