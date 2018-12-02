package Ejercicio25;

public interface Listable {
    
    public boolean isEmpty();
    public int size();
    public void insert(Object o);
    public Node trace(Object o);
    public Node delete(Object o);
    public Node behind(Node n);
    public Node first();
    public Node last();
    public Node next(Node n);
}
