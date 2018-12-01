package Tarea5;

import java.util.Date;

public class Email implements Emailable{
    private String nombre, apellido, sexo, direccion, contraseña;
    private Date cumple;
    public Email(){}
    
    public Email(String d, String c, String n, String a, String s, Date cum){
        this.direccion = d;
        this.contraseña = c;
        this.nombre = n;
        this.apellido = a;
        this.sexo = s;
        this.cumple = cum;
    }
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}
    public Date getCumple() { return cumple; }
    public void setCumple(Date cumple) { this.cumple = cumple; }
    

    @Override
    public boolean accesar(String di, String c) {
        return this.getDireccion().equals(di) && this.getContraseña().equals(c);
    }

    @Override
    public boolean cambiarContraseña(String c1, String c2) {
        if(this.getContraseña().equals(c1)){
            this.setContraseña(c2);
            print("La contraseña ha sido cambiada.");
            return true;
        }
        else{
            print("La contraseña no ha sido cambiada");
            return false;
        }
    }      
    public void print(String s){ System.out.print(s + "\n"); }
    
}
