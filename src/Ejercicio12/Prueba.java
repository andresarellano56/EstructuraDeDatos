package Ejercicio12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Prueba {

    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    Scanner leer;
    String path;

    public Prueba() {
        leer = new Scanner(System.in);
        path = "\\Conjuntos\\";
    }
     
    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba();        
        System.out.println(p.read("Set"));
    }
    
    void meta(){
        print("Realizar un programa que permita probar las prestaciones\n");
        print("del ADT Conjunto de forma persistente.");
    }
    
    public void ingresaConjunto(){
        print("Dame nombre del conjunto: "); 
    }
    
    public void openOut(String n){
        try{
            fw = new FileWriter(path + n + ".txt", true);
            bw = new BufferedWriter(fw);
        }catch(IOException ex){
            System.err.println("Error en abrir el archivo para escribir " + ex);
        }
    }
    
    public void openIn(String n){
        try{
            fr = new FileReader(path + n + ".txt");
            br = new BufferedReader(fr);
        }catch(IOException ex){
            System.err.println("Error en abrir el archivo para leer " + ex);
        }
    }
    
    public void write(String n, String o) throws IOException{
        try{
            openOut(n);
            for (int i = 0; i < o.length(); i++) {
                bw.write(o);
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
        String aux = "";
        
        openIn(n);
        while(br.readLine() != null){
            aux = br.readLine();
        }
        
        return aux;
    }
    
    void print(String s){ System.out.print(s); }
}
