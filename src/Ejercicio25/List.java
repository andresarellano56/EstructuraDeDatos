package Ejercicio25;

public class List extends Node implements Listable{
    private Node nodo;
    private List lista;
    
    public List getList(){ return this.lista; }
    
    public List(){ this.nodo = null; }

    @Override
    public boolean isEmpty() {
        try{
            return this.nodo == null;
        }catch(Exception ex){
            System.out.println("Error in isEmpty");
            return false;
        }   
    }

    @Override
    public int size() {
        int c = 0;
        while(nodo !=  null)
            c++;
        return c;
    }

    @Override
    public void insert(Object o, Node n) {
        try{
            if(isEmpty()){
               nodo = new Node(o, n); 
            }
        }catch(Exception ex){
            System.out.println("Error en insert " + ex);
        }
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
