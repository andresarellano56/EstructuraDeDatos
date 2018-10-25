package Ejercicio13;

import Ejercicio11.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Prueba {
    
    File f;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    Scanner leer;
    String path, n, m, elementos;
    String[] o;
    int c;
    Set s1, s2, u, d, i;
    
    public Prueba() {
        leer = new Scanner(System.in);
        path = "conjunto\\";
    }
     
    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba();        
        
        p.meta();
        p.navegabilidad();
    }
    
    void meta(){
        print("Realizar un programa que permita probar las prestaciones\n");
        print("del ADT Conjunto de forma persistente.\n");
        print("El programa debará poder crear un archivo nuevo por cada \n");
        print("conjunto nuevo que ingrese el usuario y mostrar los \n");
        print("resultados en consola");
    }
    
    public void conjuntoNuevo() {
        try{
            print("Dame nombre del conjunto: ");
            n = leer.next();
            do{
                print("Dame numero de elementos: ");
                m = leer.next();
            }while(!isNum(m));
            c = Integer.parseInt(m);
            openOut(n);
            for (int i = 0; i < c; i++) {
                print("Dame elemento: ");
                m = leer.next();
                write(n, m);
            }
            print("\n");
        }catch(IOException ex){
            System.err.println("Error en conjuntoNuevo " + ex);
        } 
    }
    
    public void leerElementos(int i, Set s){
        try{
            do{
                print("Dame nombre del Conjunto #" + i + ": ");
                n = leer.next();
                openIn(n);
            }while(!f.exists()); 
            elementos = read(n);
            o = elementos.split(" ");
            for(String x: o) s.add(x);
        }catch(IOException ex){
            System.err.println("Error en leerElementos " + ex);
        }  
    }   
    
    public void calculos(){
        s1 = new Set();
        leerElementos(1, s1);
        
        s2 = new Set();
        leerElementos(2, s2);

        u = s1.union(s2);
        i = s1.intersection(s2);
        d = s1.difference(s2);
    }
    
    public void resultados(){
        s1.print();
        s2.print();
        print("Union: ");
        u.print();
        print("Interseccion: ");
        i.print();
        print("Diferencia: ");
        d.print();
        print("\n");
    }
    
    public void navegabilidad(){
        String s;
        int op;
        
        do{
            print("1. Ingresar un nuevo conjunto a la lista\n");
            print("2. Realizar operaciones entre conjuntos\n");
            print("3. Salir\n");
            do{
                print("Que deseas hacer: ");
                s = leer.next();
            }while(!isNum(s));
            op = Integer.parseInt(s);
            switch(op){
                case 1: 
                    conjuntoNuevo();
                    break;
                case 2:
                    calculos();
                    resultados();
                    break;
                case 3: break;
                default:
                    print("Opcion erronea \n");
                    break;
            }    
        }while(op != 3);
    }
    
    public void openOut(String n){
        try{ 
            f = new File(path + n + ".txt");
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
        }catch(IOException ex){
            System.err.println("Error en abrir el archivo para escribir " +ex);
        }
    }
    
    public void openIn(String n){
        try{
            f = new File(path + n + ".txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
     
    public void write(String n, String o) throws IOException{
        try{
            openOut(n);
            for (int i = 0; i < o.length(); i++) {
                bw.write(o + " ");
            }
            bw.flush();
        }catch(IOException ex){
            System.err.println("Couldn´t write into file" + ex);
        }finally{
            fw.close();
            bw.close();
        }
    }
    
    public String read(String n) throws IOException{
        String aux, a;
        StringBuilder c = new StringBuilder();
 
        openIn(n);
        while((a = br.readLine()) != null){
            c.append(a);
        }
        aux = c.toString();
        fr.close();
        br.close(); 
        return aux;
    }
    
    void print(String s){ System.out.print(s); }
    
    boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            System.err.println("No es numero, Intentelo de nuevo");
            return false;
        }
    }
}