package Ejercicio18;

import Ejercicio15.Cronometro;

public class PruebaRecursiva {
    
    
    void meta(){
        print("Mostrar la serie Fibonacci un determinado numero de veces"
                + "usando recursividad\n");
    }
    
    int calculoRecursivo(int x){
        print(x + "\n");
        if(x > 2) return calculoRecursivo(x - 1) + calculoRecursivo(x - 2);
        else return x;
    }
    
    void resultados(int x){
        for (int i = 0; i < x; i++) {
            print(calculoRecursivo(i)+"\n");
        }
    }
    
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        PruebaRecursiva p = new PruebaRecursiva();
        
        c.tiempoIncio();
        p.resultados(25);
        c.tiempoFinal();
        c.resultado(c.tiempoTotal());
        
    }
    
    private void print(String s){
        System.out.print(s);
    }
    
}
