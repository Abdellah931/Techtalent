import java.util.Scanner;

public class ejercicio6UN6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in); 
        System.out.println("Introduce un número");  
        String num = sc.nextLine(); 
    
        int numero =Integer.parseInt(num);
        System.out.println(Factorial(numero));
        
        sc.close();
    }
    
    public static int Factorial(int fact) {
        int resultado=1; 
        
        while (fact>1) {
            resultado = resultado *= fact;
            fact--;
        }
    
        return resultado; 
    }
	}

