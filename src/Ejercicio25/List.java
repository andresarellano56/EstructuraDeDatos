package Ejercicio25;

public class List implements Listable {
    Node head, previous, nuevo, siguiente; 
    
    public List(){ this.head = null; }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int c = 0;
        
        if(!isEmpty()){
            Node aux = head;
            while(aux != null){
                c++;
                aux = aux.getNext();
            }
        }
        return c;
    }
    
    @Override
    public void insert(Object o) { head = new Node(o);}
    
    @Override
    public void insert(Object o, Node n) {
        if(n == null) //Inserta el primer nodo de la lista
            head = new Node(o);
        else {//Inserta un nodo en cualquier lugar de la lista
            nuevo = new Node(o, n);
            Node aux = head;
            while(aux != null && aux.getInfo() != n.getInfo())
                aux = aux.getNext();
            if(aux != null){
                nuevo.next = aux.getNext();
                aux.next = nuevo;
            }
        }
    }

    @Override
    public Node trace(Object o) { //Busca el nodo especifico dentro de la lista
        nuevo = new Node(o);
        Node aux = head;
        while(aux != null && !aux.getInfo().equals(o))
            aux = aux.getNext();
        return aux;
    }

    @Override
    public Node delete(Object o){ //Borra un nodo de la lista
        if(!isEmpty() && trace(o) != null){
            Node aux = head;
            while(aux != null){
                if(aux.getInfo().equals(o)) break;
                previous = aux;
                aux = aux.getNext();
            }
            if(aux != null){
                if(aux == head)
                    head = aux.getNext();
                else
                    previous.next = aux.getNext();
            } else previous.next = null;
            return aux;
        }else return null;
    }

    @Override
    public Node behind(Node n) {//Devuelve el anterior al ingresado
        try{
            if(!isEmpty() && trace(n.getInfo()) != null){
            Node aux = head;
            while(aux != null){
                if(aux.getInfo().equals(n.getInfo())) break;
                previous = aux;
                aux = aux.getNext();
            }     
        }
        }catch(NullPointerException nl){
            err("El primer nodo no tiene ningun predecesor " + nl);
        }
        return previous;
        
    }

    @Override
    public Node first() { //Devuelve el primer elemento de la lista
        if(!isEmpty())
            return head;
        else return null;
    }

    @Override
    public Node last() { //Devuelve el ultimo elemento de la lista
        if(!isEmpty()){
            Node aux = head;
            while(aux != null)
                if(aux.getNext() == null) break;
                else aux = aux.getNext();
            return aux;
        }else return null;
    }

    @Override
    public Node next(Node n) {//Devuelve el siguiente nodo del ingresado
        try{
            if(!isEmpty() && trace(n.getInfo()) != null){
            Node aux = head;
            while(aux != null){
                if(!aux.getInfo().equals(n.getInfo()))
                    aux = aux.getNext();
                else {
                    siguiente = aux.getNext();
                    break;
                }
            }     
        }
        }catch(NullPointerException nl){
            err("El ultimo nodo apunta a null " + nl);
        }
        return siguiente;
    }
 
    public void out(String s){System.out.print(s);}
    public void err(String s){System.err.print(s);}
}