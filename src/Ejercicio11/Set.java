package Ejercicio11;

public class Set implements Settable{
    private Object[] element;
    private int c;

    public Set() {
        this.element = new Object[5];
    }
    
    public Set(int c){
        this.element = new Object[c];
        
        for (int i = 0; i < element.length; i++) 
            element[i] = null;  
    }
    
    public Set(Set s1){
        this.element = new Object[s1.space()];
        
        for (int i = 0; i < element.length; i++) 
            element[i] = s1.element[i];
    }
    
    public int space(){ return this.element.length; }

    @Override
    public void add(Object o) {
        int n;
        
        try {
            if(full()) moreSpace();
            n = space();
            for (int i = 0; i < n; i++) {
                if (element[i] == null && !pertain(o)){ element[i] = o; } 
            }
        } catch (Exception ex) {
            System.err.println("Error en add " + ex);
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            return space() == 0;
        }catch(Exception ex){
            System.err.println("Error en isEmpty" + ex);
            return false;
        }
    }

    @Override
    public Set union(Set s1) {
        int n = space();
        int m = s1.space();
        Set s2 = new Set(n + m);
        
        try{
            for(Object x : this.element){
                s2.add(x);
            }
            for(Object x : s1.element){
                if(!s2.pertain(x)){
                    s2.add(x);
                }
            }
//          for (int i = 0; i < n; i++) { s2.element[i] = element[i]; }
//          for (int i = 0; i < m; i++) { s2.element[n + i] = s1.element[i]; } 
        }catch(Exception ex){
            System.err.println("Error en Union " + ex);
        }
        return s2;
    }

    @Override
    public Set intersection(Set s1) {
        int n = space();
        int m = s1.space();
        Set s2 = new Set(n + m);
        
        try {
            for(Object x: this.element){
                if(s1.pertain(x)){
                    s2.add(x);
                }
            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (this.element[i].equals(s1.element[j])) {
//                        aux[i] = element[i];
//                    }
//                }
//            }
        }catch(Exception ex){
            System.err.println("Error en Intersection " + ex);
        }
        return s2;
    }

    @Override
    public Set difference(Set s1) {
        int n = this.cardinality();
        Set s2 = new Set(n);
   
        try {
            for(Object x : this.element){
                if(!s1.pertain(x))
                    s2.add(x);
            }
        } catch (Exception ex) {
            System.err.println("Error en Difference " + ex);
        }
        return s2;
    }

    @Override
    public boolean pertain(Object o) {
        int a = 0;
        
        try{
            if(!isEmpty()){
                for(Object x: this.element){
                    if(o.equals(x)) a = 1;
                }
//              for (int i = 0; i < space(); i++) {
//                    if(o.equals(element[i])) a = 1;
//              }
            }
            return a == 1;
        }catch(Exception ex){
            System.err.println("Error en pertain " + ex);
            return false;
        }
    }
    
    public Object[] auxiliary() {
        int n = space();
        Object[] aux = new Object[n];

        for (int i = 0; i < n; i++) {
            if(this.element[i] == null){
                i = i + 1;
            }
            aux[i] = element[i];
        }
        return aux;
    }
    
    public boolean full(){
        int i = 0;
        
        for(Object x: this.element)
            if(x != null) i++;
//        for (int i = 0; i < space(); i++) 
//            if(this.element[i] != null) i++;     

        return i == space();
    }
    
    public void moreSpace(){
        int n = space();
        Object[] aux = new Object[n + 1];

        for (int i = 0; i < n; i++) {
            aux[i] = element[i];
        }

        element = aux;
    }
    
    public void remove() {
        try{
            element = new Object[0];
        }catch(Exception ex){
            System.err.println("Error en remove simple " + ex);
        }
    }

    public void remove(Object o) {    
        try{
            if(!isEmpty()){
                for (int i = 0; i < space(); i++) 
                    element = auxiliary();  
            }
        }catch(Exception ex){
            System.err.println("Error en remove object " + ex);
        }
    }
    
    public void print(){
        try {
            System.out.print("{ ");
            for (int i = 0; i < space(); i++) {
                if (element[i] != null) {
                    System.out.print(this.element[i] + " ");
                }
            }
            System.out.print("}");
        }catch(Exception ex){
            System.err.println("Error de impresion " + ex);
        }
        
    }

    @Override
    public int cardinality() {
        int x = 0;
        
        for(Object o: this.element){
            if(o != null) x++;
        }
//        for (int i = 0; i < space(); i++) {
//            if(element[i] != null) x++;
//        } 
        return x;
    }
}