import java.util.Scanner;
public class ejercicio6UN5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce precio inicial del producto");
		String num=sc.nextLine();
		sc.close();
		
		double IVA= 0.21;
		double precioproducto=Double.parseDouble(num);
		double IVAproducto= IVA * precioproducto;
		double preciofinal = IVAproducto + precioproducto;
				
System.out.println("El precio final con IVA es de : " + preciofinal);

	}

}
