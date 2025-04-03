package com.example;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

public class PuntoFijo {
    private Datos datos;
    private double puntoConvergencia;
    private double gPunto;

    public PuntoFijo(Datos datos) {
        this.datos = datos;
    }

    public void recibirPuntoConvergencia(double puntoConvergencia) {
        this.puntoConvergencia = puntoConvergencia;
    }

    public void puntoFijoDesarrollo() {
        double pc = puntoConvergencia;
        String gx = datos.getGx();
        String fx = datos.getFx();
        int i = 0;
        int imax = 10000;

        try {
            Expression expression = new Expression(gx);

            EvaluationValue evalGX = expression.with("x", pc).evaluate();
            gPunto = evalGX.getNumberValue().doubleValue();

            while (Math.abs(pc - gPunto) > 1e-20) {
                i++;
                if (i > imax) {
                    System.out.println("Se alcanzó el número máximo de iteraciones");
                    return;
                }
                pc = gPunto;
                evalGX = expression.with("x", pc).evaluate();
                gPunto = evalGX.getNumberValue().doubleValue();
            }

            Expression exp = new Expression(fx);
            EvaluationValue result = exp.with("x", pc).evaluate();
            double resultaComprobado = result.getNumberValue().doubleValue();

            System.out.println("Iteraciones: " + i);

            // Utilizamos System.out.printf de manera correcta
            System.out.printf("La solución es: %.6f\n", pc);
            System.out.printf("Comprobando en la función f(x) es: %.6f\n", resultaComprobado);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
