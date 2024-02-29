import java.util.Scanner;
import java.util.stream.DoubleStream;

public class ejercicio10UN5 {

    public static void main(String[] args) {
        // Solicitar al usuario el número de ventas a introducir
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce the number of sales to enter: ");
        int numVentas = scanner.nextInt();

        
        double[] ventas = new double[numVentas];

       
        for (int i = 0; i < numVentas; i++) {
            System.out.print("Introduce sale " + (i + 1) + ": ");
            ventas[i] = scanner.nextDouble();
        }

        
        double sumaVentas = DoubleStream.of(ventas).sum();

       
        System.out.println("The sum of all sales is: " + sumaVentas);
    }
}
