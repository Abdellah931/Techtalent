import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ejercicio4UN7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Double> stockProducto = new HashMap<>();
		
		stockProducto.put("Patano", 2.99);
		
		stockProducto.put("po ", 5.2);
		stockProducto.put("pato ",2.0);
		stockProducto.put("pata ", 9.0);
		stockProducto.put("pelel ", 99.8);
		stockProducto.put("zatano ", 39.0);
		stockProducto.put("aranadno ", 2.0);
		stockProducto.put("pera" , 7.8);
		

//		System.out.println("Escriba la cantidad de Articulos que quiere añadir ");
//		int cantidadCesta =  sc.nextInt();
//		idea antigua
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("Quiere ver los articulos disponibles y sus precios? ");
		String articulosDisponibles =  sc.next();
		
		if ( articulosDisponibles.equals("si")) {
            System.out.println(stockProducto);
	} else {
		System.out.println("Procede a añadir los productos y las cantidades de forma manual");
            
		
	}
		Map<String, Double> Precio = new HashMap<>();
		
		System.out.println("Escriba la cantidad de Articulos que quiere añadir ");
		int cantidadArticulos =  sc.nextInt();
		
		
		
		
		for (int i = 1; i <= cantidadArticulos; i++) {
		System.out.println("Escriba el nombre del articulo: " );
		String nombreProducto =  sc.next();
		
		

		System.out.println("Escriba el precio de " + nombreProducto + ": ");
		double precioProducto =  sc.nextDouble();
		
		System.out.println("Escriba la cantidad del articulo que desea añadir: ");
		int cantidadProducto =  sc.nextInt();
		
		double PrecioTotal = (double) (cantidadProducto * precioProducto);
		System.out.println(cantidadProducto + " " + nombreProducto + " de "  + precioProducto + "€ son: " + PrecioTotal+"€");
		
		
		Precio.put(nombreProducto, PrecioTotal);
		}
		
		
		
		double sumaCompra = 0;
    	for (double m : Precio.values()) {
			sumaCompra += m;
		}

	
		
		System.out.println("El preu total de la compra sera de: " + sumaCompra);
		
		
		
		
	
	}        	

	}

