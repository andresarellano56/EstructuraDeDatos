package Ejercicio11;

public interface Settable {
    public void add(Object o);

    public boolean isEmpty();
    public int cardinality();
    public Set union(Set s1);
    public Set intersection(Set s1);
    public Set difference(Set s1);
    public boolean pertain(Object o);
}
