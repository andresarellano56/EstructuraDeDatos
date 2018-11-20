package Tarea5;

import java.io.*;
import java.util.Scanner;

public class Prueba {
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    String dir, con, sex, nom, ape;
    String datos[] = new String[6];
    Scanner leer = new Scanner(System.in);

    public void meta(){
        print("Realizar un programa que permita probar el ADT Email.");
        print("El programa deberá de permitirle al usuario crear un correo");
        print("electronico o acceder a su cuenta ya previamente creada"); 
        print("ademas de permitirle modificar su cuenta.");    
    }
    
    public void registrarse() throws IOException{
        print("Ingresa la direccion de correo: ");
        String aux = leer.nextLine();
        datos[0] = aux.concat("@gmail.com");
        print("Ingresa la contraseña: ");
        datos[1] = leer.nextLine();
        print("Ingresa tu nombre: ");
        datos[2] = leer.nextLine();
        print("Ingresa tu apellido: ");
        datos[3] = leer.nextLine();
        datos[4] = nacimiento();
        print("Ingresa tu sexo[M/F]: ");
        datos[5] = leer.nextLine();
        write(datos[0], datos);
    }
    
    public String nacimiento() {
        String d, m, y;
        
        do{
            print("Ingresa dia de nacimiento: ");
            d = leer.nextLine();
        }while(!isNum(d));
        do{
            print("Ingresa mes de nacimiento: ");
            m = leer.nextLine();
        }while(!isNum(m));
        do{
            print("Ingresa año de nacimiento: ");
            y = leer.nextLine();
        }while(!isNum(y));
        return d + "/" + m + "/" + y;
    }
    
    public void write(String name, String[] info) throws IOException{
        for(String i: info)
           write(name, i);
    }

    public void cambiarContra(Email e) {
        String c1, c2;
        
        do{
            print("Ingrese la antigua contraseña: ");
            c1 = leer.nextLine();
            print("Ingrese la nueva contraseña: ");
            c2 = leer.nextLine();
        }while(!e.cambiarContraseña(c1, c2));
        datos[1] = e.getContraseña();     
    }
    
    public void cambiarCumpleaños(Email e){
        e.cambiarCumpleaños(nacimiento());
        datos[4] = e.getCumple();   
    }
    
    public void cambiarSexo(Email e){
        String s;
        
        print("Ingresa tu sexo[M/F]: ");
        s = leer.nextLine();
        e.cambiarSexo(s);
        datos[5] = e.getSexo();
    }
    
    public void navegabilidad() throws IOException{
        Email e;
        String op, di;
        
        do{
            int des = menu();
            switch(des){
                case 1: registrarse(); break;
                case 2:
                    do{
                        print("Direccion de correo: ");
                        di = leer.nextLine();
                        datos = read(di);
                        e = new Email(datos[0], datos[1], datos[2], datos[3],
                            datos[4],datos[5]);
                        print("Contraseña: ");
                        con = leer.nextLine();
                    }while(!e.accesar(datos[0], con));
                    System.out.println("Se elimino");
                    int des2 = submenu();
                    switch(des2){
                        case 1:cambiarContra(e);break;
                        case 2:cambiarCumpleaños(e);break;
                        case 3:cambiarSexo(e);break;
                        default: break;
                    }
                    write(di, datos);
                    break;
                case 3: break;
                default: 
                    print("Opcion invalida");
                    break;
            }
            print("Deseas realizar otra accion?[s/n]: ");
            op = leer.nextLine();
        }while(op.equalsIgnoreCase("s"));
    }
    
    public int menu(){
        String des;
        
        do{
            print("Bienvenido\n");
            print("Presiona 1 para crear un nuevo correo. \n");
            print("Presiona 2 para acceder a tu cuenta. \n");
            print("¿Que deseas hacer?:  ");
            des = leer.nextLine();
        }while(!isNum(des));
        return Integer.parseInt(des);
    }
    
    public int submenu(){
        String des;
        
        do{
            print("Bienvenido \n");
            print("Presiona 1 para cambiar la contraseña. \n");
            print("Presiona 2 para cambiar tu fecha de cumpleaños. \n");
            print("Presiona 3 para cambiar tu sexo. \n");
            print("¿Que deseas hacer?:  ");
            des = leer.nextLine();
        }while(!isNum(des));
        return Integer.parseInt(des);
    }

    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba();
        
        p.navegabilidad();

    }
    
    void openOutFile(String correo) throws IOException {
        fw = new FileWriter("emails\\" + correo + ".txt",true);
        bw = new BufferedWriter(fw);
    }
    
    void openInFile(String correo) {
        try {
            fr = new FileReader("emails\\" + correo + ".txt");
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        }
    }
    
    void write(String cuenta, Object dato) throws IOException{
        try{
            openOutFile(cuenta);
            bw.write(dato + ",");
            bw.newLine();
            bw.flush();
        }catch(IOException ex){
            System.err.println("Error con la cuenta");
        }finally{
            fw.close();
            bw.close();
        }
    }
    
    String[] read(String cuenta) throws IOException{
        String aux, a;
        StringBuilder c = new StringBuilder();
 
        openInFile(cuenta);
        while((a = br.readLine()) != null){
            c.append(a);
        }
        aux = c.toString();
        fr.close();
        br.close();
        
        return aux.split(",");
    }
    
    boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            System.err.println("No es numero, "
                    + "Intentelo de nuevo");
            return false;
        }
    }
    
    public void print(String s){ System.out.print(s); }
}
