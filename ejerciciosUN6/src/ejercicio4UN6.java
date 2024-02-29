import java.util.Scanner;

public class ejercicio4UN6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
	
		System.out.println(factorial(num));
	}

	public static int factorial(int n) {
		n = Math.abs(n);

		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
			
		}

	}
}