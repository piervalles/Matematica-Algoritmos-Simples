package com.example;

import java.math.BigDecimal;

//import org.matheclipse.core.eval.ExprEvaluator;
//import org.matheclipse.core.interfaces.IExpr;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

public class Convergencia {

    private Datos datos;
    private BigDecimal puntoInicial;

    public Convergencia(Datos datos){
        this.datos = datos;
    }

    private BigDecimal puntoConvergencia(){
        String dgx = datos.getD1String();
        BigDecimal a = datos.getA();
        BigDecimal b = datos.getB();
        BigDecimal dgA = null;
        BigDecimal dgB = null;

        try {
            Expression expression = new Expression(dgx);

            EvaluationValue eDGA = expression.with("x", a).evaluate();
            dgA = eDGA.getNumberValue();

            EvaluationValue eDGB = expression.with("x", b).evaluate();
            dgB = eDGB.getNumberValue();

        } catch (Exception e) {
            System.out.println("Error al evaluar las expresiones: " + e.getMessage());
            System.exit(0);
            return null;
        }

        if (dgA.compareTo(BigDecimal.ONE) >= 0 && dgB.compareTo(BigDecimal.ONE) >= 0) {
            System.out.println("El x=g(x) no cumple con el criterio de convergencia");
            System.out.println(datos.getGx());
            System.out.println("Ingrese x=g(x) expresado de otra manera");
            System.exit(0); 
        }
        
        //Seleccionamos el punto inicial (A o B) basado en la condición de convergencia
        //BigDecimal punto=null;
        if (dgA != null && dgA.abs().compareTo(BigDecimal.ONE) < 0) {
            puntoInicial = a;
            return a;
        } else{
            puntoInicial = b;
            return b;
        }
    }

    public BigDecimal puntoInicial(){
        this.puntoInicial = puntoConvergencia();
        return puntoInicial;
    }
}
