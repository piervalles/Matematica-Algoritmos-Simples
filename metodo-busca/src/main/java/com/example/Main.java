package com.example;

import java.util.Scanner;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;


//Este es un algoritmo que permite encontrar las raices de un polinomio
//a través de un incremento que parte desde un inicio, hasta un límite
//determinado por un intervalo [a,b] para evaluar f(x).

public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Metodo Busca");
        System.out.println("Ingrese la funcion f(x)");
        String inputStr = escaner.nextLine();

        //analizamos la funcion ingresada
        Expression expr = new Expression(inputStr);

        System.out.println("Ingrese el intervalo [a,b]");
        System.out.println("Ingrese \'a\' ");
        double a = escaner.nextDouble();
        System.out.println("Ingrese \'b\' ");
        double b = escaner.nextDouble();


        if (a>=b) {
            System.out.println("\'a\' debe ser menor que \'b\' ");
        } else {
            double fa=0;
            double fb=0;
            try {
                EvaluationValue evalFa = expr.with("x", a).evaluate();
                fa=evalFa.getNumberValue().doubleValue();
                EvaluationValue evalFb = expr.with("x", b).evaluate();
                fb=evalFb.getNumberValue().doubleValue();
            } catch (Exception e) {
                // TODO: handle exception
            }

            if (fa*fb==0) {
                if (fa==0 && fb==0) {
                    System.out.println("Las soluciones son:");
                    System.out.println(a);
                    System.out.println(b);
                } else {
                    if (fa==0) {
                        System.out.println("La solución es:");
                        System.out.println(a);
                    } else {
                        System.out.println("La solución es:");
                        System.out.println(b);
                    }
                }
            } else {
                System.out.println("Ingrese un incremento (H)");
                double incrH = escaner.nextDouble();
                
                double m = a;
                double n = m+incrH;
                int i=1;
                int imax=50000;

                try {
                    EvaluationValue evalFa = expr.with("x", m).evaluate();
                    fa = evalFa.getNumberValue().doubleValue();
                    EvaluationValue evalFb = expr.with("x", n).evaluate();
                    fb = evalFb.getNumberValue().doubleValue();
                    while (fa*fb>0 && n<b || i<imax) {
                        i=i+1;
                        m = n;
                        n = m+incrH; 

                        EvaluationValue evalFa2 = expr.with("x", m).evaluate();
                        fa = evalFa2.getNumberValue().doubleValue();
                        EvaluationValue evalFb2 = expr.with("x", n).evaluate();
                        fb = evalFb2.getNumberValue().doubleValue();
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

                if (i>imax) {
                    System.out.println("Se alcanzo el limite de iteracciones");
                    System.out.println("Debe escoger un incremento (H) que sea prudente \nni muy grande ni muy pequeño para detectar un cambio de signo");
                } else {
                    if (n>b) {
                        System.out.println("No se encontro una solución en el intervalo");
                        String aString = String.valueOf(a);
                        String bString = String.valueOf(b);
                        System.out.println("["+aString+" , "+bString+"]");
                        System.out.println("Pruebe con otro intervalo [a,b] para buscar un cambio de signo");
                    } else {
                        if (fa*fb<0) {
                            System.out.println("Existe una solución en el rango de:");
                            System.out.println(m);
                            System.out.println(n);
                        }
                    }
                }
            }
        }
        escaner.close();
    }
}