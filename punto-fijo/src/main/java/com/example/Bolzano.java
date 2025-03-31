package com.example;

import java.math.BigDecimal;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

public class Bolzano {
    private Datos datos;
    
    public Bolzano(Datos datos){
        this.datos = datos;
    }

    public boolean bolzanoAplicaDecicion(){
        BigDecimal a = datos.getA();
        BigDecimal b = datos.getB();
        String fx = datos.getFx();
        BigDecimal fa = null;
        BigDecimal fb = null;

        try {
            Expression expression = new Expression(fx);

            EvaluationValue faEval = expression.with("x", a).evaluate();
            fa = faEval.getNumberValue();
            
            EvaluationValue fbEval = expression.with("x", b).evaluate();
            fb = fbEval.getNumberValue();

        } catch (EvaluationException e) {
            // Manejo de la excepción EvaluationException
            e.printStackTrace();
        } catch (ParseException e) {
            // Manejo de la excepción ParseException
            e.printStackTrace();
        }

        if (fa.multiply(fb).compareTo(BigDecimal.ZERO) >= 0) {
            // código si el resultado es >= 0
            System.out.println("No se pudo comprobar a traves de Bolzano que exista una raiz en el intervalo");
            System.out.println("Nota: Puede que exista un cambio de signo en ese intervalo");
            System.out.println("Dando una solucion que no se encontro");
            System.out.println("Bolzano solo da una solucion por intervalo, sin considerar si existen otras soluciones");

            return false;
        } else {
            return true;
        }
        
    }
}
