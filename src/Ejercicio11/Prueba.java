package Ejercicio11;

public class Prueba {

    public static void main(String[] args) {
        Set s1 = new Set();
        Set s2 = new Set();
       
        
        s1.add(1.2);
        s1.add("True");
        s1.add(2);
        s1.add(false);
        s1.add(":D");
        s1.add("putito");
        s1.add(7);

        s2.add(1.2);
        s2.add(2);
        s2.add(false);
        s2.add(":D");
        s2.add(7);
        s2.add("HOLA");
        s2.add(6969);
    
        
        
        s1.print();
        System.out.println("");
        s2.print();
        System.out.println("\n---");
//        System.out.println("\n" + s2.isEmpty());
//        System.out.println(s1.cardinality());
        
//        Set s3 = s1.union(s2);
//        s3.print();

//        Set s3 = s1.intersection(s2);
//        s3.print();
        
        System.out.println("\n---");
        Set s5 = s2.union(s1);
        s5.print();


        System.out.println("\n---");
        Set s4 = s2.intersection(s1);
        s4.print();
        
        System.out.println("\n---");
        Set s3 = s2.difference(s1);
        s3.print();
        
        System.out.println("");
        s1.remove("putito");
        s1.print();
        
        
       
        
    }

}
