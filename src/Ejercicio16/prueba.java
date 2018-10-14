package Ejercicio16;

import Ejercicio15.Cronometro;

public class prueba {
    int x = 25;
    int[] n = new int[x];
    
    void meta(){
        print("Mostrar la serie Fibonacci un determinado numero de veces\n");
    }
    
    int[] calculos(){
        n[0] = 0;
        n[1] = 1;
        for (int i = 2; i < x; i++) {
            n[i] = n[i-1] + n[i-2];
        }
        return n;
    }
    
    void resultados(){
        for (int i = 0; i < x; i++) {
            print(n[i] + "\n");
        }
    }
    
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        prueba p = new prueba();
        
        c.tiempoIncio();
        p.meta();
        p.calculos();
        p.resultados();
        c.tiempoFinal();
        c.resultado(c.tiempoTotal());
        
    }
    
    private void print(String s){
        System.out.print(s);
    }
    
}
