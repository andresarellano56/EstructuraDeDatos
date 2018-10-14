package Ejercicio1;

public class Calculo {

    private int cociente, residuo, t = 0;
    private int[] num;
    private String[] aux;
    private final int n[] = {10, 11, 12, 13, 14, 15};
    private final String l[] = {"A", "B", "C", "D", "E", "F"};
    

    public String[] conversion(String s, int base) {
        int numero = Integer.parseInt(s);
        while (true) {
            cociente = numero / base;
            residuo = numero % base;
            numero = cociente;
            if (numero == 0) {
                break;
            }
            t++;
        }
        int x = Integer.parseInt(s);
        num = new int[t+1];
        aux = new String[t+1];
        for (int i = 0; i < num.length; i++) {
            cociente = x / base;
            residuo = x % base;
            num[i] = residuo;
            aux[i] = Integer.toString(residuo);
            x = cociente;
            for (int j = 0; j < n.length; j++) {
                if (n[j] == num[i]) {
                    aux[i] = l[j];
                }
            }
        }
        return aux;
    }

}
