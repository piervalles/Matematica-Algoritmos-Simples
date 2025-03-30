package com.example;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

public class Intervalos {
    private Datos datos;

    public Intervalos (Datos datos){
        this.datos = datos;
    }

    public boolean  reglaIntervalos (){
        Double fa=null;
        Double fb=null;

        String fxString = datos.getFx();
        double a = datos.getA().doubleValue();
        double b = datos.getB().doubleValue();

        try {
            Expression expression = new Expression(fxString);

            EvaluationValue eFa = expression.with("x", a).evaluate();
            fa = eFa.getNumberValue().doubleValue();

            EvaluationValue eFb = expression.with("x", b).evaluate();
            fb = eFb.getNumberValue().doubleValue();   
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        if (a>=b || fa*fb==0) {
            if (a>=b) {
                System.out.println("Error: \'a\' debe ser menor que \'b\'");
            } else {
                if (fa*fb==0) {
                    if (fa==0 && fb==0) {
                        System.out.println("Las raices de la función son:");
                        if ((a == Math.floor(a)) && (b == Math.floor(b))) {
                            // Es un número entero (sin decimales significativos)
                            System.out.println("x1 = "+(int)a);
                            System.out.println("x2 = "+(int)b);
                        } else {
                            // Tiene decimales significativos
                            System.out.println("x1 = "+a);
                            System.out.println("x2 = "+b);
                        }
                    } else {
                        if (fa==0) {
                            System.out.println("Se encontro una raiz en: ");
                            if (a==Math.floor(a)) {
                                System.out.println("x = "+(int)a);
                            } else {
                                // Tiene decimales significativos
                                 System.out.println("x = "+a);
                            }
                        } else {
                            System.out.println("Se encontro una raiz en: ");
                            if (b==Math.floor(b)) {
                                System.out.println("x = "+(int)b);
                            } else {
                                // Tiene decimales significativos
                                 System.out.println("x = "+b);
                            }
                        }
                    }
                }     
            }
            return false;
        } else {
            return true;
        }
    }
}
