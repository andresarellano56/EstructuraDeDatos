package Tarea5;

import java.io.*;
import java.util.Scanner;

public class Prueba {
    FileWriter fw;
    BufferedWriter bw;
    FileReader r;
    BufferedReader br;
    String nom, ape, sex, dir, con;
    int d, m, y;
    Scanner leer = new Scanner(System.in);

    public void meta(){
        print("Realizar un programa que permita probar el ADT Email.");
        print("El programa deberá de permitirle al usuario crear un correo");
        print("electronico o acceder a su cuenta ya previamente creada"); 
        print("demas de permitirle modificar su cueta en todo momento.");    
    }
    
    public void registrarse() throws IOException{
        print("Ingresa la direccion de correo: ");
        String aux = leer.nextLine();
        dir = aux.concat("@gmail.com"); 
        write(dir, dir);
        print("Ingresa la contraseña: ");
        con = leer.nextLine();
        write(dir, con);
        print("Ingresa tu nombre: ");
        nom = leer.nextLine();
        write(dir, nom);
        print("Ingresa tu apellido: ");
        ape = leer.nextLine();
        write(dir, ape);
        nacimiento();
    }
    
    public void nacimiento() throws IOException{
        String a;
        
        do{
            print("Ingresa dia de nacimiento: ");
            a = leer.nextLine();
        }while(!isNum(a));
        write(dir, a);
        do{
            print("Ingresa mes de nacimiento: ");
            a = leer.nextLine();
        }while(!isNum(a));
        write(dir, a);
        do{
            print("Ingresa año de nacimiento: ");
            a = leer.nextLine();
        }while(!isNum(a));
        write(dir, a);
    }
    
    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba();
        
        p.registrarse();
    }
    
    void openOutFile(String correo) throws IOException {
        fw = new FileWriter("emails\\" + correo + ".txt",true);
        bw = new BufferedWriter(fw);
    }
    
    void openInFile(String correo) {
        try {
            r = new FileReader("emails\\" + correo + ".txt");
            br = new BufferedReader(r);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        }
    }
    
    void write(String cuenta, String dato) throws IOException{
        try{
            openOutFile(cuenta);
            bw.write(dato + ",");
            bw.flush();
        }catch(IOException ex){
            System.err.println("Error al crear la cuenta");
        }finally{
            fw.close();
            bw.close();
        }
    }
    
    boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            System.err.println("No es numero, Intentelo de nuevo");
            return false;
        }
    }
    
    public void print(String s){ System.out.print(s); }
}
