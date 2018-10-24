package Ejercicio11;

public class Set implements Settable{
    private Object[] element;

    public Set() {
        this.element = new Object[5];
    }
    
    public Set(int c){
        this.element = new Object[c];
        
        for (int i = 0; i < element.length; i++) 
            element[i] = null;  
    }
    
    public Set(Set s1){
        this.element = new Object[s1.cardinality()];
        
        for (int i = 0; i < element.length; i++) 
            element[i] = s1.element[i];
    }
    
    public int space(){ return this.element.length; }

    public void add(Object o) {
        int n;
        
        try {
            if(isFull()) moreSpace();
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
            return this.cardinality() == 0;
        }catch(Exception ex){
            System.err.println("Error en isEmpty" + ex);
            return false;
        }
    }

    @Override
    public Set union(Set s1) {
        int n = this.cardinality();
        int m = s1.cardinality();
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
        }catch(Exception ex){
            System.err.println("Error en Union " + ex);
        }
        return s2;
    }

    @Override
    public Set intersection(Set s1) {
        int n = this.cardinality();
        int m = s1.cardinality();
        Set s2 = new Set(n + m);
        
        try {
            for(Object x: this.element){
                if(s1.pertain(x)){
                    s2.add(x);
                }
            }
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
            }
            return a == 1;
        }catch(Exception ex){
            //System.err.println("Error en pertain " + ex);
            return false;
        }
    }
    
    public boolean isFull(){
        int i = 0;
        
        for(Object x: this.element)
            if(x != null) i++;  

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
    
    @Override
    public int cardinality() {
        int x = 0;
        
        for(Object o: this.element){
            if(o != null) x++;
        }
        return x;
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
                for(int i = 0; i < cardinality(); i++)
                    if(this.pertain(o) && o.equals(this.element[i])) 
                        this.element[i] = null;   
            }
        }catch(Exception ex){
            System.err.println("Error en remove object " + ex);
        }
    }
    
    public void print(){
        try {
            System.out.print("{ ");
            for (int i = 0; i < cardinality(); i++) 
                if (element[i] != null) 
                    System.out.print(this.element[i] + " ");
            System.out.print("} \n");
        }catch(Exception ex){
            System.err.println("Error de impresion " + ex);
        }
        
    } 
}