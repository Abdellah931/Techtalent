import java.util.*;

public class ejercicio3 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(0, 1000);
        try {
            System.out.println("\033[32mNúmero generado.\u001b[0m");
            CustomEx.esPar(numero);
        } catch (CustomEx e) {
            System.out.println("\033[33mTipo de excepción capturada:"+
            "\u001b[0m [ " + e.getMessage() + " ]");
        } finally {
            System.out.println("\033[31mFinal programa.\u001b[0m");
        }
    }
}