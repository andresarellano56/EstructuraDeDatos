package Ejercicio1;

import java.util.Scanner;

public class Prueba {

    Scanner leer = new Scanner(System.in);
    String num, r;

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.meta();
        do{
            p.datos();
            p.resultados();
        }while(p.navegabilidad().equalsIgnoreCase("s"));
        
    }

    public void meta() {
        System.out.println("Programa que convierta un numero de "
                + "cualquier base a: binario, octal, decimal y hexademal");
    }

    public String datos() {
        while(true){
            System.out.print("Ingresa un numero base 10: ");
            num = leer.next();
            if(validacion(num)) break;
        }return num;
    }

    public void resultados() {
        System.out.print("Binario: ");
        imprimir(num, 2);
        System.out.print("Octal: ");
        imprimir(num, 8);
        System.out.print("Hexadimal: ");
        imprimir(num, 16);
    }

    public String navegabilidad() {
        do {
            System.out.print("¿Deseas convertir otro numero?[s/n]: ");
            r = leer.next();
            if (r.equalsIgnoreCase("s") || r.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Respuesta incorrecta");
            }
        }while(true);
        String op = r;
        return op;
    }

    public void imprimir(String s, int base) {
        Calculo c = new Calculo();
        String[] aux = c.conversion(s, base);
        for (int i = aux.length-1; i >= 0; i--) {
            System.out.print(aux[i]);
        }
        System.out.println();
    }
    
    public boolean validacion(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Entrada no valida");
            return false;
        }
    }
}
