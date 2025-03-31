package com.example;

import java.math.BigDecimal;

import org.matheclipse.core.eval.ExprEvaluator;
//import org.matheclipse.core.interfaces.IExpr;

import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;


public class Convergencia {

    private Datos datos;
    private BigDecimal puntoInicial;


    

    public Convergencia(Datos datos){
        this.datos = datos;
    }

    private String derivadaSimbolica(){
        String funcion = datos.getGx();

        // Usamos Symja para realizar la derivada
        ExprEvaluator util = new ExprEvaluator();
        String derivada = util.eval("D(" + funcion + ", x)").toString();
        return derivada;
    }

    public void puntoConvergencia(){
        String dgx = derivadaSimbolica();
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

            if (dgA.compareTo(BigDecimal.ONE) >= 0 && dgB.compareTo(BigDecimal.ONE) >= 0) {
                System.out.println("El x=g(x) no cumple con el criterio de convergencia");
                System.out.println(datos.getGx());
                System.out.println("Ingrese x=g(x) expresado de otra manera");
                System.exit(0); // Termina completamente el programa
            }
    
            //Seleccionamos el punto inicial (A o B) basado en la condición de convergencia
            //BigDecimal punto=null;
            if (dgA.abs().compareTo(BigDecimal.ONE) < 0) {
                puntoInicial = a;
            } else if (dgB.abs().compareTo(BigDecimal.ONE) < 0) {
                puntoInicial = b;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        //verificamos la convergencia, debe cumplir |g′(x)|<1 para x en [A,B]
        //Al menos uno de los dos puntos ó ambos deben cumplir con la
        //condición para salir del bucle


    }
    
    public BigDecimal getPuntoConvergencia(){
        return puntoInicial;
    }

}
