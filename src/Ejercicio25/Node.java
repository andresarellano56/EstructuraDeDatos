package Ejercicio25;

public class Node {
    protected Object info;
    protected Node next;
    protected int position;

    public Node(){
        info = null;
        next = null;
        position = 0;
    }
    
    public Node(Object o, Node n){
        this.setInfo(o);
        this.setNext(n);
    }
    
    public Node(Object o){
        this.setInfo(o);
        next = null;
        position = 0;
    }

    public Object getInfo() { return info; }
    public void setInfo(Object info) { this.info = info; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
    public int getPosition() {return position;}
    public void setPosition(int position) {this.position = position;}
   
}
