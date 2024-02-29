import java.util.Scanner;

public class ejercicio9un6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Entra un tamaño de array: ");
        int size = scanner.nextInt();
        int sumarTotal = 0;
        int array9[]= new int [size];
        for (int i = 0; i < array9.length; i++) {
        	array9[i]=(int) (Math.random()*10);
			
		}
        for (int i = 0; i < array9.length; i++) {
            System.out.print(array9[i]+",");
            					
		}
   
		for (int i = 0; i < array9.length; i++) {
        	sumarTotal+= array9[i];
        }
        
        scanner.close();
        System.out.println("\nLa suma total es: " + sumarTotal);
	}
	}


