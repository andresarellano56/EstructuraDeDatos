package Ejercicio25;

public class prueba {

    public static void main(String[] args) {

        List lista = new List();
        //System.out.println(lista.isEmpty());
        lista.insert(23, lista.getNext());
        System.out.println(lista.size());
    }
    
}
