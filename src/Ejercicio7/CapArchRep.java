package Ejercicio7;

import java.io.*;
import java.util.Scanner;

public class CapArchRep {
    Scanner t = new Scanner(System.in);
    FileOutputStream fw;
    DataOutputStream ds; //flujo de salida
    FileInputStream f;
    DataInputStream dis; //flujo de entrada 
    String aux = "";
    char m, n;
    
    void abreSal() throws IOException{
        fw = new FileOutputStream("Data.mbd", false);
        ds = new DataOutputStream(fw);
    }
    
    void inicio(){
        System.out.println("Para ilustrar la interpretacion");
        System.out.println("del formato de datos leidos del teclado");
        System.out.println("y guardarlos en archivo");
    }
    
    boolean isNum(String cad){
        try{
            Double.parseDouble(cad);
            return true;
        }catch(NumberFormatException nfe){
            System.out.println("Favor de introducir un numero\n");
            return false;
        }
    }
    
    public String bitPattern(short value){
        short BIT1_MASK = 1;
        final char[] bits = new char[0];
        
        for (short i = 7; i >= 0; i--) {
            bits[i] = (value & BIT1_MASK) == 1 ? '1' : '0';
            value >>>= 1;
        }
        return new String(bits);
    }
    
    boolean isBin(String cad){
        for (int i = 0; i < cad.length(); i++) 
            if(cad.charAt(i) != '0' && cad.charAt(i) != 1)
                return false;
        return true;
    }
    
    int menu(){
        int op;
        
        do{
            System.out.println("Menu de camptura\n");
            System.out.println(" Desea capturar:\n");
            System.out.println("1.- En binario");
            System.out.println("2.- En caracter");
            System.out.println("3.- Numero short");
            System.out.println("4.- Numero entero");
            System.out.println("5.- flotante");
            System.out.println("6.- Salir");
            System.out.print("Su eleccion: ");
            aux = t.nextLine();
        }while(!isNum(aux));
        op = Integer.parseInt(aux);
        return op;
    }
    
    void captura() throws IOException{
        int op =  menu();
        
        if(op != 6){
            switch(op){
                case 1: leeBinEsChArch(); break;
                case 2: leeCharEsArch(); break;
                case 3: leeShortEsArch(); break;
                case 4: leeEntEsArch(); break;
                case 5: leeFloatEsArch();break;
                default: System.out.println("Opciones validas 1-5");  
            }
        }
    }
    
    int toInt(String s){
        int n = 0;
        
        for (int i = s.length()-1, j = 0; i >= 0; j++) {
            n += (s.charAt(i) - '0') * Math.pow(2, j);
        }
        return n;
    }
    
    void leeShortEsArch(){
        short m, n;
        
        do{
            System.out.println("Deme un numero corto: ");
            aux = t.nextLine();
        }while(!isNum(aux));
        m = Short.parseShort(aux);
        do{
            System.out.println("Deme otro numero corto: ");
            aux = t.nextLine();
        }while(!isNum(aux));
        n = Short.parseShort(aux);
        try{
            ds.writeShort(m);
            ds.writeShort(n);
        }catch(IOException ioe){
            System.out.println("Excepcion al guardar el short");
        }
    }
    
    void leeBinEsChArch(){ //con c de la a la z
       String entra = "";
       
       do{
           System.out.print("Deme un numero de 32 bits en binario: ");
           entra = t.nextLine();
       }   while(!isBin(entra));
       m = (char) toInt(entra.substring(0, 15));
       n = (char) toInt(entra.substring(16, 31));
       try{
           ds.writeChar(m);
           ds.writeChar(n);
       }catch(IOException ioe){
           System.out.println("Hubo excepcion al escribir en el archivo");
       }       
    }
    
    void leeCharEsArch(){ //leer 2 char
        System.out.print("Deme un caracter: ");
        aux = t.nextLine();
        if(aux.length() > 1){
            m = aux.charAt(0);
            n = aux.charAt(1);
        }else{
            m = aux.charAt(0);
            System.out.println("Deme otro caracter: ");
            aux = t.nextLine();
            n = aux.charAt(0);
        }
        try{
            ds.writeChar(m);
            ds.writeChar(n);
        }catch(IOException ioe){
            System.out.println("Hubo excepcion al escribir en el archivo");
        }
    }
    
    void leeEntEsArch() throws IOException{
        int num;
        
        do{
            System.out.println("Dame un numero: ");
            aux = t.nextLine();
        }while(!isNum(aux));
        num = Integer.parseInt(aux);
        ds.writeInt(num);
    }
    
    void leeFloatEsArch() throws IOException{
        float f;
        
        do{
            System.out.println("Dame un numero con decimales: ");
            aux = t.nextLine();
        }while(!isNum(aux));
        f = Integer.parseInt(aux);
        ds.writeFloat(f);
    }
    
    void abreArchivo()throws IOException{
        f = new FileInputStream("Data.mbd");
        dis = new DataInputStream(f);
    }
    
    void r3f(short n){
        System.out.print("En el archivo hay un numero con formato binario: ");
        System.out.println(bitPattern(n));
        System.out.printf("el mismo como char es %c\n", n);
        System.out.printf("se ve como un numero corto asi: %d\n", n);
        System.out.printf("con formato decimal %d\n", n);
    }
    
    void reporta() throws IOException { // todos los formatos
        short num, o;
        int n;
        float f;
        
        ds.close();
        abreArchivo();
        num = dis.readShort();
        r3f(num);
        n = dis.readInt();
        System.out.println("El numero entero es: " + n);
        dis.close();
        abreArchivo();
        f = dis.readFloat();
        System.out.println("El numero flotante es: " + f);
        dis.close();
    }
    
    public static void main(String[] args) throws IOException{
        CapArchRep car = new CapArchRep();
        
        car.inicio();
        car.abreSal();
        car.captura();
        car.reporta();
    }
    
}
