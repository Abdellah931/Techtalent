import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.Iterator;


public class ejercicio2UN7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de productos: ");
		int cantidadProductos = scanner.nextInt();
		
		
Map<String, Double> PrecioProducto = new HashMap<>();
		
		
		
		for (int i = 1; i <= cantidadProductos; i++) {
			System.out.print("Ingrese el nombre del producto " + i + ": ");
			String nombreProducto = scanner.next();

			
		System.out.print("Ingrese precio producto: ");
		double precioProductoBruto = scanner.nextDouble();
		
		System.out.print("Es producto de primera necesidad: ");
		String necesidadIVA =  scanner.next();
		
		necesidadIVA = necesidadIVA.toLowerCase();
		double precioProductoNeto;
		
		if ( necesidadIVA.equals("si")) {
			precioProductoNeto = (precioProductoBruto*0.04)+precioProductoBruto;
            System.out.println("el IVA sera del 4%: "  + precioProductoBruto*0.04 +
            		"\nEl precio neto es de: " + precioProductoNeto);
            
        } else {
        	precioProductoNeto = (precioProductoBruto*0.21)+precioProductoBruto;
            System.out.println("El IVA sera del 21%: " + precioProductoBruto*0.21 +
            		"\nEl precio neto es de: " + precioProductoNeto);
        }
            PrecioProducto.put(nombreProducto, precioProductoNeto);
		}
            
		
		
		double sumaCompra = 0;
        	for (double m : PrecioProducto.values()) {
				sumaCompra += m;
			}

			double totalCompra = sumaCompra;

				
				System.out.println( "El precio total de la compra sera de: "+ totalCompra);
				
				System.out.print("El pago del cliente sera ");
				double pagoCliente =  scanner.nextDouble();
//				
				double cambioCliente = pagoCliente - totalCompra;
				System.out.println("El cliente pago " + pagoCliente + " y el cambio sera de " + cambioCliente);
			
			}
}

	
		
		
		
		
	