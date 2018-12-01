package Tarea5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebaFecha {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String texto = "69/01/2000";
        Date fecha = formato.parse(texto);
        String x = String.valueOf(fecha);
        System.out.println(fecha);
        System.out.println("**" + x);
        System.out.println(formato.format(fecha));
    }

}
