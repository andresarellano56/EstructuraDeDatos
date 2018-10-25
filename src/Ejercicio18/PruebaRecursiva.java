package Ejercicio18;

import Ejercicio15.Cronometro;

public class PruebaRecursiva {
     
    void meta(){
        print("Mostrar la serie Fibonacci un determinado numero de veces"
                + "usando recursividad\n");
    }
     
    int calculoRecursivo(int x){
        if(x == 0) return 0;
        if(x == 1) return 1;
        else return calculoRecursivo(x - 1) + calculoRecursivo(x - 2);
    }
    
    void resultados(int x){
        for (int i = 0; i < x; i++) {
            print(calculoRecursivo(i)+ "\n");
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
