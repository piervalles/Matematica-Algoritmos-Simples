package com.example;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
import java.math.BigDecimal;

import org.checkerframework.checker.units.qual.A;

public class PuntoFijo {
    private Datos datos;
    private BigDecimal puntoConvergencia;
    private BigDecimal gPunto;

    public PuntoFijo(Datos datos){
        this.datos = datos;
    }

    public void recibirPuntoConvergencia(BigDecimal puntoConvergencia){
        this.puntoConvergencia = puntoConvergencia;
    }

    public void puntoFijoDesarrollo(){
        BigDecimal  pc = puntoConvergencia;
        String gx = datos.getGx();
        String fx = datos.getFx();
        int i = 0;
        int imax = 10000;

        try {
            Expression expression = new Expression(gx);

            EvaluationValue evalGX = expression.with("x", pc).evaluate();
            gPunto = evalGX.getNumberValue();

            while (pc.subtract(gPunto).abs().compareTo(new BigDecimal("1e-20")) > 0) {


                i++;
                if (i>imax) {
                    System.out.println("Se alcanzo el numero maximo de iteracciones");
                    return;
                } else {
                    
                }
                pc = gPunto;
                evalGX = expression.with("x", pc).evaluate();
                gPunto = evalGX.getNumberValue();
            }
            
            pc=gPunto;
            Double doublepc = pc.doubleValue();

            Expression exp = new Expression(fx);

            EvaluationValue result = exp.with("x", pc).evaluate();
            BigDecimal resultaComprobado = result.getNumberValue();

            Double rc = resultaComprobado.doubleValue();

            System.out.println("Iteraciones: "+i);
            System.out.println("La solución es %.6f"+doublepc);
            System.out.println("Comprobando en la función f(x)");
            System.out.println("%.6f"+rc);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
