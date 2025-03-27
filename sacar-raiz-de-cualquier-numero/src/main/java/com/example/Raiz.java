package com.example;

public class Raiz {
    private Datos datos;

    public Raiz(Datos datos) {
        this.datos = datos;
    }

    // Función de ayuda para verificar si un double es entero (dentro de un margen de error).
    private boolean esEntero(double valor) {
        // Redondeamos y comparamos para evitar problemas de precisión en coma flotante
        double redondeado = Math.rint(valor); 
        return Math.abs(valor - redondeado) < 1e-15;
    }
    
    public void raizDesarrollo() {
        double numero = datos.getNumero();
        double exponente = datos.getExponente();

        // 1) Verificar si el exponente es 0
        if (exponente == 0) {
            System.out.println("Error: El exponente (índice de la raíz) no puede ser cero.");
            return;
        }

        // 2) Manejar el caso en que el número es 0
        if (numero == 0) {
            if (exponente > 0) {
                // 0 ^ (1/exponente) = 0
                System.out.printf("La solución es: %.9f%n", 0.0);
            } else {
                // exponente < 0 => 1 / 0 => no definido
                System.out.println("Error: No se puede calcular la raíz de 0 con exponente negativo (división entre cero).");
            }
            return;
        }

        // 3) Si el número es negativo, revisar si la raíz puede ser real
        if (numero < 0) {
            // ¿El exponente es entero?
            if (esEntero(exponente)) {
                // Convertimos exponente a entero para revisar par/impar
                int expEntero = (int) Math.rint(exponente);

                // Si expEntero es par, la raíz de un número negativo es imaginaria
                if (Math.abs(expEntero) % 2 == 0) {
                    System.out.println("No se puede dar una solución real, parte de la solución es imaginaria.");
                    return;
                }

                // Si expEntero es impar, se puede calcular la raíz real (negativa)
                // Calculamos la magnitud de la raíz
                double basePositiva = Math.abs(numero);
                double raiz = Math.pow(basePositiva, 1.0 / Math.abs(exponente));

                // El signo de la raíz será negativo porque el número original es negativo
                raiz = -raiz;

                // Si el exponente es negativo, invertimos la raíz
                if (exponente < 0) {
                    raiz = 1.0 / raiz;
                }

                System.out.printf("La solución es: %.9f%n", raiz);
                return;

            } else {
                // Si el exponente no es entero, la raíz sería compleja (parte real e imaginaria)
                System.out.println("No se puede dar una solución completa en los números reales; " +
                                   "parte de la solución pertenece a los números imaginarios.");
                return;
            }
        }

        // 4) Si el número es positivo, se puede calcular la raíz directamente
        //    (el resultado es real para cualquier exponente real ≠ 0).
        double raiz = Math.pow(numero, 1.0 / exponente);
        System.out.printf("La solución es: %.9f%n", raiz);
    }
}
