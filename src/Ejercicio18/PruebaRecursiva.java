package Ejercicio18;

import Ejercicio15.Cronometro;

public class PruebaRecursiva {
    int x = 25;
    int[] n = new int[x];
    
    void meta(){
        print("Mostrar la serie Fibonacci un determinado numero de veces\n");
    }
    
    int[] calculoRecursivo(int x){
       
        return n;
    }
    
    void resultados(){
        for (int i = 0; i < x; i++) {
            print(n[i] + "\n");
        }
    }
    
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        PruebaRecursiva p = new PruebaRecursiva();
        
        c.tiempoIncio();
        p.meta();
        p.calculoRecursivo(25);
        p.resultados();
        c.tiempoFinal();
        c.resultado(c.tiempoTotal());
        
    }
    
    private void print(String s){
        System.out.print(s);
    }
    
}
