package Ejercicio25;

public interface Listable {
    
    public boolean isEmpty();
    public int size();
    public void insert(Object o, Node n);
    public Node find(Object o, List l);
    public Node delete(Object o, List l);
    public Node previous(List l, Node p);
    public Node fist(List l);
    public Node last(List l);
    public Node next(List l, Node p);
}
