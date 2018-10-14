package Ejercicio17;

import java.util.Scanner;

public class Prueba {
    
    Scanner leer = new Scanner(System.in);
    int n;
    
    public static void main(String[] args) {
        Prueba p = new Prueba();     
        
        do{
            p.resultados(p.datos());
        }while(p.navegabilidad().equalsIgnoreCase("s"));
    }
    
    public int datos(){
        String s;
        
        do{
            System.out.print("Dame un numero: ");
            s = leer.next();
        }while(!isNum(s));
        return n = Integer.parseInt(s);      
    }
    
    public int factorialIterativo(int n){
        int fac = 1;
        
        for (int i = 1; i <= n; i++) {
            fac = fac * i;
        }
        return fac;
    }
    
    public int factorialRecursivo(int n){
        if(n > 1)
            return n * factorialRecursivo(n - 1);
        else 
            return 1;
    }
    
    public void resultados(int n){
        int a = factorialIterativo(n);
        int b = factorialIterativo(n);
        
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
