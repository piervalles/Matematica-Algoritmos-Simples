package com.example;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;

public class PruebaFalsa {
    private Variables datos;

    public PruebaFalsa(Variables datos){
        this.datos = datos;
    }

    public void pruebaFalsaCalculo(){
        String fxString = datos.getFxString();
        double a = datos.getA();
        double b = datos.getB();

        try {
            Expression expression = new Expression(fxString);
            EvaluationValue eFa = expression
            .with("x", a)
            .evaluate();
            double fa = eFa.getNumberValue().doubleValue();

            EvaluationValue eFB = expression
            .with("x", b)
            .evaluate();  
            double fb = eFB.getNumberValue().doubleValue();

            if (fa*fb>0) {
                System.out.println("No hay cambio de signo en el intervalo [a,b] evaluado\n"
                                    +"Pero cabe la posibilidad de que exista un cambio de signo dentro del intervalo\n"
                                    +"Escoja un intervalo donde f(a)*f(b)<0 para aplicar el metodo"

                );
            } else {
                double C = (a*fb-b*fa)/(fb-fa);
                EvaluationValue eFc = expression.with("x", C).evaluate();  
                double fc = eFc.getNumberValue().doubleValue();

                int i=0;
                final int imax=100000;

                while (Math.abs(fc)>1e-20 && i<imax) {
                    i++;

                    if (fa*fc>0) {
                        a=C;
                    } else {
                        b=C;
                    }

                    C = (a*fb-b*fa)/(fb-fa);
                    eFc = expression.with("x", C).evaluate();
                    fc = eFc.getNumberValue().doubleValue();
                }

                if (i>imax) {
                    System.out.println("Se alcanzo el limite de iteracciones,\n"
                                        +"no se logro calcular una solucion");
                } else {
                    System.out.println("Se encontro una solucion en:");
                    if (C == Math.floor(C)) {
                        // Es un número entero (sin decimales significativos)
                        System.out.println((int) C);
                    } else {
                        // Tiene decimales significativos
                        System.out.println(C);
                    }
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
