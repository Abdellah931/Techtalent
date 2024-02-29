import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.swing.JOptionPane; 

public class ejercicio1UN7 {

	public static void main(String[] args) {

		ArrayList<String> lista = new ArrayList<>();
		lista.add("Marc");
		
		for (Object o : lista) {
			System.out.println(o);
		}
		System.out.println(lista.toString());

		Scanner sc= new Scanner(System.in); 
        System.out.println("Introduce nota");  
        
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int numero=0;
        for( int i=0; i<3; i++) {
        String num = sc.nextLine(); 
        numero =Integer.parseInt(num);
		listaNumeros.add(numero);
        }
    
		System.out.println(numero());
        
        sc.close();
  
	
		System.out.println("Notas: " );
		System.out.println(listaNumeros.toString());
//		System.out.println( "Media:" listaNumeros.get());
		
		Iterator<Integer> it = listaNumeros.iterator();
		int num1, sumaNumeros=0;
		while (it.hasNext()) {
			num1= it.next();
			sumaNumeros+=num1;
			
		}
		int mediaNumeros= sumaNumeros/listaNumeros.size();
		System.out.println("Nota media: " + mediaNumeros);
		
	}

	private static char[] numero() {
		// TODO Auto-generated method stub
		return null;
	}

	
    }

