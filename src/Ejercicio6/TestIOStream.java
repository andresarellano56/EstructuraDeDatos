package Ejercicio6;

import java.io.*;
import java.util.Scanner;

public class TestIOStream {

    File outFile, inFile;
    FileOutputStream outStream;
    FileInputStream inStream;
    byte byteArray[] = {10, 20, 30, 40, 50, 60, 70, 80};
    Scanner leer = new Scanner(System.in);

    void inicio() {
        print("Crea un archivo binario con datos");
        print("Lo guarda en el disco con el nombre Sample1.data");
        print("Leer el archivo recien creado abriendolo del"
                + " disco");
        print("Lo despliega en consola");
    }

    String capArchName() {
        String aux;
        do {
            print("Dame nombre del archivo: ");
            aux = leer.next();
        } while (aux.length() <= 0);
        return aux;
    }

    public void openOut(String name) {
        outFile = new File(name);
        try {
            outStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException fne) {
            System.err.println("No se creo el archivo " + fne);
        }
    }

    public void openIn(String name) {
        inFile = new File(name);
        try {
            inStream = new FileInputStream(inFile);
        } catch (FileNotFoundException fne) {
            System.err.println("No se creo el archivo " + fne);
        }
    }

    public void out(String arch) throws IOException {
        openOut(arch);
        outStream.write(byteArray); //Escribe datos en el archivo del Stream
        outStream.close(); //Ya escrito, se cierra el Stream
    }

    public void in(String arch) throws IOException {
        //Preparar un array para leer los datos
        byte[] bytebuff = new byte[byteArray.length];

        openIn(arch);
        for (int i = 0; i < bytebuff.length; i++) {
            print(bytebuff[i] + " ");
        }
        inStream.close();
    }

    
    public static void main(String args[]) {
        TestIOStream tfios = new TestIOStream();
        String archivo;

        tfios.inicio();
        archivo = tfios.capArchName();
        try {
            tfios.out(archivo);
            tfios.in(archivo);
        }catch(IOException ioe){
            tfios.print("Error de entrada/salida. " + ioe);
        }
    }
    
    void print(String s){
        System.out.println(s);
    }

}
