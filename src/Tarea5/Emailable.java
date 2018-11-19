package Tarea5;

public interface Emailable {
    public boolean accesar(String di, String c);
    public boolean cambiarContraseña(String c1, String c2);
    public void mandarMensaje(String di, String msm);
    public void cambiarCumpleaños(int d, int m, int y);
    public void cambiarSexo(String s);
}
