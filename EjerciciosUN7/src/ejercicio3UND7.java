import java.util.HashMap; 
import java.util.Map;
import java.util.Scanner;

public class ejercicio3UND7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
			
			Map<String, Integer> stockProducto = new HashMap<>();
			
			stockProducto.put("platano", 2);
			stockProducto.put("manzana ", 5);
			stockProducto.put("pato ",2);
			stockProducto.put("kebab ", 9);
			stockProducto.put("zanahoria ", 99);
			stockProducto.put("zatano ", 39);
			stockProducto.put("aranadno ", 2);
			stockProducto.put("pera" , 7);
			


			
			Scanner sc = new Scanner(System.in);
			
			
			
			System.out.print("Quiere ver los articulos disponibles en stock? ");
			String articulosDisponibles =  sc.next();
			
			if ( articulosDisponibles.equals("si")) {
	            System.out.println(stockProducto);
	            
		} else {
			System.out.println("\nProcede a añadir los productos y las cantidades de forma manual");
	            
			
		}
			
			
			System.out.println("\nEscriba la cantidad de productos que quiere añadir ");
			int cantidadProductos =  sc.nextInt();
			
			
			
			
			for (int i = 1; i <= cantidadProductos; i++) {
			System.out.println("\nEscriba el nombre del articulo: " );
			String nombreProducto =  sc.next();
			
			
	            
	           
			
			System.out.println("\nEscriba la cantidad del articulo que desea añadir: ");
			int cantidadArticulos =  sc.nextInt();
			
			System.out.println("\nAñadimos al stock " + cantidadArticulos + " unidades de " + nombreProducto);
			
		
			}
			
			}
			
			
	
			
			
			
		
		    	

		
			}

	


