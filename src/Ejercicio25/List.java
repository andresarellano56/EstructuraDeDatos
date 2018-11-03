package Ejercicio25;

public class List extends Node implements Listable{
    private Node nodo;
    private List lista;
    
    public List getList(){ return this.lista; }
    
    public List(){ this.nodo = null; }

    @Override
    public void emptyList(List l) {
        try {
            nodo = null;
        }catch(Exception ex){
            System.out.println("Error in emptyList");
        } 
    }

    @Override
    public boolean isEmpty(List l) {
        try{
            return this.nodo == null;
        }catch(Exception ex){
            System.out.println("Error in isEmpty");
            return false;
        }   
    }

    @Override
    public int size(List l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List insert(List l, Object o, Node n) {
        if(!isEmpty(l))
            nodo = new Node(o, n);
        return l.getList();
    }

    @Override
    public Node find(Object o, List l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node delete(Object o, List l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node previous(List l, Node p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node fist(List l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node last(List l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node next(List l, Node p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
