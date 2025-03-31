package com.example;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
import java.math.BigDecimal;

public class PuntoFijo {
    private Datos datos;
    String derivada;

    public PuntoFijo(Datos datos){
        this.datos = datos;
    }

    public void recibirDerivada(String derivada){
        this.derivada = derivada;
    }

    public void puntoFijoProceso(){

    }


}
