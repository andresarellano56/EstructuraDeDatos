package Ejercicio17;

import java.util.Scanner;

public class Prueba {
    
    Scanner leer = new Scanner(System.in);
    double n;
    
    public static void main(String[] args) {
        Prueba p = new Prueba();     
        
        do{
            p.resultados(p.datos());
        }while(p.navegabilidad().equalsIgnoreCase("s"));
    }
    
    public double datos(){
        String s;
        
        do{
            System.out.print("Dame un numero: ");
            s = leer.next();
        }while(!isNum(s));
        return n = Integer.parseInt(s);      
    }
    
    public double factorialIterativo(double n){
        double fac = 1;
        
        for (int i = 1; i <= n; i++) {
            fac = fac * i;
        }
        return fac;
    }
    
    public double factorialRecursivo(double n){
        if(n > 1)
            return n * factorialRecursivo(n - 1);
        else 
            return 1;
    }
    
    public void resultados(double n){
        double a = factorialIterativo(n);
        double b = factorialRecursivo(n);
        
        System.out.println("Resultado n! iterativo = " + a);
        System.out.println("Resultado n! recursivo = " + b);
    }
    
    public String navegabilidad(){
        String s;
        
        System.out.print("¿Quieres calcular otro factorial[s/n]?: ");
        s = leer.next();
        System.out.println();
        return s;
    }
    
    public boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception ex){
            System.err.println("Ingrese un numero");
            return false;
        }
    }
  
}
