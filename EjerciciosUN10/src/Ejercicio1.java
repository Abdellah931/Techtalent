import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    private int numeroAdivinar;
    private int intentos;

    public Ejercicio1() {
        Random rand = new Random();
        this.numeroAdivinar = rand.nextInt(500) + 1;
        this.intentos = 0;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean adivinado = false;
               

        System.out.println("Bienvenido al juego de adivinar el número!");
        System.out.println("Intenta adivinar el número entre 1 y 500.");

        while (!adivinado) {
            System.out.print("Introduce tu intento: ");
            try {
                int intento = scanner.nextInt();
                this.intentos++;
                
                int a = 10;
                int b = 0;
                
                int resultado = a/b;

                if (intento < 1 || intento > 500) {
                    System.out.println("El número debe estar entre 1 y 500.");
                    continue;
                }

                if (intento < this.numeroAdivinar) {
                    System.out.println("El número a adivinar es mayor.");
                } else if (intento > this.numeroAdivinar) {
                    System.out.println("El número a adivinar es menor.");
                } else {
                    adivinado = true;
                    System.out.println("¡Felicidades! ¡Has adivinado el número " + this.numeroAdivinar + "!");
                    System.out.println("Número de intentos: " + this.intentos);
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                scanner.next(); // Limpiar el buffer del scanner
                this.intentos++;
            } catch (ArithmeticException e) {
    			System.out.println("No puedes dividir por cero");
    		}
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Ejercicio1 juego = new Ejercicio1();
        juego.jugar();
    }
}