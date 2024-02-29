import java.util.Scanner;

public class ejercicio12UN5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Definir la contraseña correcta
        String contraseñaCorrecta = "12345";

        // Solicitar al usuario que introduzca la contraseña
        Scanner scanner = new Scanner(System.in);
        int intentosRestantes = 3;
        boolean contraseñaCorrectaEncontrada = false;

        while (intentosRestantes > 0 && !contraseñaCorrectaEncontrada) {
            System.out.print("Introduce la contraseña: ");
            String contraseñaIntroducida = scanner.nextLine();

            if (contraseñaIntroducida.equals(contraseñaCorrecta)) {
                contraseñaCorrectaEncontrada = true;
                System.out.println("Enhorabuena!");
            } else {
                intentosRestantes--;
                if (intentosRestantes == 0) {
                    System.out.println("Lo siento, has agotado tus intentos.");
                } else {
                    System.out.println("Contraseña incorrecta. Te quedan " + intentosRestantes + " intentos.");
                }
            }
        }

        scanner.close();
    }
}