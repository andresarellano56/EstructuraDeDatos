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
        this.element = new Object[s1.cardinality()];
        
        for (int i = 0; i < element.length; i++) 
            element[i] = s1.element[i];
    }
    
    public int cardinality(){ return this.element.length; }

    @Override
    public void add(Object o) {
        int n = cardinality();
        try{
           if(!pertain(o)){
               for (int i = 0; i < n; i++) {
                   if(element[i] != null){
                       isFull();
                   }
               }
               element[n + 1] = o;
           }
        }catch(Exception ex){
            System.err.println("Error en add " + ex);
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            return cardinality() == 0;
        }catch(Exception ex){
            System.err.println("Error en isEmpty" + ex);
            return false;
        }
    }

    @Override
    public Set union(Set s1) {
        int n = cardinality();
        int m = s1.cardinality();
        Set s2 = new Set(n + m);
        
        try{
            for (int i = 0; i < n; i++) { s2.element[i] = element[i]; }
            for (int i = 0; i < m; i++) { s2.element[n + i] = s1.element[i]; } 
        }catch(Exception ex){
            System.err.println("Error en Union " + ex);
        }
        return s2;
    }

    @Override
    public Set intersection(Set s1) {
        int n = cardinality();
        int m = s1.cardinality();
        int a = 0;
        Set s2 = new Set(n + m);
        
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (element[i].equals(s1.element[j])) {
                        s2.element[i] = element[i];
                    }
                }
            }
        }catch(Exception ex){
            System.err.println("Error en Intersection " + ex);
        }
        return s2;
    }

    @Override
    public Set difference(Set s1) {
        Set inter = intersection(s1);
        int n = cardinality();
        Set s2 = new Set(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inter.cardinality(); j++) {
                if(!element[i].equals(s1.element[j])){
                    s2.element[i] = element[i];
                }
            }
        }
        return s2;
    }

    @Override
    public boolean pertain(Object o) {
        int a = 0;
        
        try{
            if(!isEmpty()){
                for (int i = 0; i < cardinality(); i++) {
                    if(o.equals(element[i])) a = 1;
                }
            }
            return a == 1;
        }catch(Exception ex){
            System.err.println("Error en isOf" + ex);
            return false;
        }
    }
    
    public Object[] auxiliary() {
        int n = cardinality();
        Object[] aux = new Object[n - 1];

        for (int i = 0; i < n; i++) {
            if(this.element[i] == null){
                i = i + 1;
            }
            aux[i] = element[i];
        }
        return aux;
    }
    
    public void isFull(){
        int n = cardinality();
        int m = n + 5;
        Object[] aux = new Object[m];
        
        for (int i = 0; i < n; i++) aux[i] = element[i];
        
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
                for (int i = 0; i < cardinality(); i++) 
                    element = auxiliary();  
            }
        }catch(Exception ex){
            System.err.println("Error en remove object " + ex);
        }
    }
}