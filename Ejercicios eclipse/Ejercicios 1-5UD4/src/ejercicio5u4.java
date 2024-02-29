
public class ejercicio5u4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int A = 1;
	        int B = 2;
	        int C = 3;
	        int D = 4;

	        System.out.println("Valor inicial de A = " + A);
	        System.out.println("Valor inicial de B = " + B);
	        System.out.println("Valor inicial de C = " + C);
	        System.out.println("Valor inicial de D = " + D);

	        int temp = B;
	        B = C;
	        C = A;
	        A = D;
	        D = temp;

	        System.out.println("Valor final de A = " + A);
	        System.out.println("Valor final de B = " + B);
	        System.out.println("Valor final de C = " + C);
	        System.out.println("Valor final de D = " + D);
	}

}
