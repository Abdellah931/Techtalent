import java.util.Scanner;

public class ejercicio10UN6 {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un tamaño de array: ");

        int size = scanner.nextInt();
        int array10[] = new int[size];
        int rangoFinal, rangoInicial;
        System.out.println("Dame el rango inicial: ");
        rangoInicial = scanner.nextInt();
        System.out.println("Dame el rango final: ");
        rangoFinal = scanner.nextInt();

        for (int i = 0; i < array10.length; i++) {
            int random=generarNumeroAleatorio(rangoInicial, rangoFinal);
            while (!esPrimo(random)) {
                random=generarNumeroAleatorio(rangoInicial, rangoFinal);
            }
            array10[i]=random;
        }
        for (int i = 0; i < array10.length; i++) {
            if (i==0) {
                System.out.print("{"+array10[i]+",");
            } else if(i < array10.length-1){
                System.out.print(array10[i]+",");
            } else
            System.out.print((array10[i])+"}");
        }
       
    }

    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int generarNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * maximo - minimo + 1) + minimo;
	}

}
