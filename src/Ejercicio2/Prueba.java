package Ejercicio2;

import java.util.Scanner;

public class Prueba {

    Scanner leer = new Scanner(System.in);
    String numero, decimal, r;
    int base;

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.meta();
        do {
            p.datos();
            p.calculos();
            p.resultados();
        } while (p.navegabilidad().equalsIgnoreCase("s"));

    }

    public void meta() {
        System.out.println("Versatilizar el ejercicio 1, para que el\n"
                + "ususario pueda introducir un numero en una de las cuatro\n"
                + "bases posibles: binario, decimal, octal y hexadecimal\n");
    }

    public void datos() {
        do {
            do {
                System.out.print("Introduzca base del numero: ");
                numero = leer.next();
            } while (!esBase(numero));
            base = Integer.parseInt(numero);
            System.out.print("Introduzca el numero: ");
            numero = leer.next();
        } while (!validacion(numero, base));
    }

    public String calculos() {
        int y = Integer.parseInt(numero, base);
        return decimal = Integer.toString(y);
    }

    public void resultados() {
        System.out.print("\nBinario: ");
        imprimir(2);
        System.out.print("Octal: ");
        imprimir(8);
        System.out.print("Decimal: ");
        imprimir(10);
        System.out.print("Hexadimal: ");
        imprimir(16);
    }

    public String navegabilidad() {
        do {
            System.out.print("\n¿Deseas convertir otro numero?[s/n]: ");
            r = leer.next();
            if (r.equalsIgnoreCase("s") || r.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Respuesta incorrecta");
            }
        } while (true);
        String op = r;
        return op;
    }

    public void imprimir(int base) {
        Conversion c = new Conversion();
        String[] aux = c.conversion(decimal, base);
        for (int i = aux.length - 1; i >= 0; i--) {
            System.out.print(aux[i]);
        }
        System.out.println();
    }

    public boolean validacion(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Entrada no valida");
            return false;
        }
    }

    public boolean validacion(String numero, int base) {
        try {
            Integer.parseInt(numero, base);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("El numero y la base no coinciden");
            return false;
        }
    }

    public boolean esBase(String s) {
        if (validacion(s)) {
            int x = Integer.parseInt(s);
            if (x == 2 || x == 8 || x == 10 || x == 16) {
                return true;
            } else {
                System.err.println("Base erronea.");
                return false;
            }
        } else {
            return false;
        }
    }

}
