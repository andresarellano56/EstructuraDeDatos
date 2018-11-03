package Ejercicio25;

public class Node {
    private Object info;
    private Node next;
    
    public Node(){
        info = null;
        next = null;
    }
    
    public Node(Object o, Node n){
        setInfo(o);
        setNext(n);
    }

    public Object getInfo() { return info; }

    public void setInfo(Object info) { this.info = info; }

    public Node getNext() { return next; }

    public void setNext(Node next) { this.next = next; }
   
}
