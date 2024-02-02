package intro1;

public class Abdellah2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer num1= Integer.valueOf("125");

		Integer num2= Integer.valueOf(20);

		int n1=num1.intValue();
		int n2=num2.intValue();
		System.out.println("Suma de "+n1+" y "+n2+" vale "+(n1+n2));
		if(n1+n2>130)
		    n1++;
		else
		    n1--;
		System.out.println(n1);
	}

}
