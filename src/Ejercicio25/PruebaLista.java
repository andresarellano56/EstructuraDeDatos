package Ejercicio25;

public class PruebaLista {

    public static void main(String[] args) {
        List miLista = new List();
        Node n1 = new Node(":D");
        Node n2 = new Node(":c");
        Node n3 = new Node(":/");
        Node n4 = new Node(":3");
        
        miLista.insert(n1.getInfo());
        miLista.insert(n2.getInfo());
        miLista.insert(n3.getInfo());
        miLista.insert(n4.getInfo());
    
//        System.out.println(miLista.size());
//        System.out.println(miLista.isEmpty());
//        System.out.println(miLista.trace(n2.getInfo()) != null);
//        
//        System.out.println(" * "+miLista.delete(":D").getInfo());
          System.out.println(miLista.size());
//        System.out.println(miLista.first().getInfo());
//        System.out.println(miLista.last().getInfo());

          System.out.println(miLista.last().getNext()==null);
    }
    
}
