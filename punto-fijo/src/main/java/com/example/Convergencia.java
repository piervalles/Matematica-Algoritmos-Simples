package com.example;

import org.matheclipse.core.eval.ExprEvaluator;
//import org.matheclipse.core.interfaces.IExpr;


public class Convergencia {

    private Datos datos;
    

    public Convergencia(Datos datos){
        this.datos = datos;
    }

    public void derivadaSimbolica(){
        // Obtenemos la función desde los datos
        String funcion = datos.getGx();

        // Usamos Symja para realizar la derivada
        ExprEvaluator util = new ExprEvaluator();
        String derivada = util.eval("D(" + funcion + ", x)").toString();

        System.out.println("esta es la derivada  "+derivada);
        //return derivada;
    }
}
