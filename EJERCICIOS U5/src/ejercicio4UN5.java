import java.util.Scanner;

public class ejercicio4UN5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Introduce RADIO");
		String num=sc.nextLine();
		sc.close();
		
		double radio=Double.parseDouble(num);
		double area= Math.PI * Math.pow(radio, 2);
		System.out.println("El radio es de " + radio);
		System.out.println("El area es de " + area)
;	}

}
