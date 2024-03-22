import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class final4 {

    
	    //	ATRIBUTOS
	    String nombre;
	    double precioBruto;
	    double IVA;
	    int cantidad;

	    // Lista para almacenar los productos
	    static List<StockArticulos> inventario = new ArrayList<>();

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	

		 StockArticulos leche = new StockArticulos("LECHE", 1.10, 4, 20);
     	inventario.add(leche);
     StockArticulos pan = new StockArticulos("PAN", 0.90, 4, 30);
     	inventario.add(pan);
     StockArticulos huevos = new StockArticulos("HUEVOS", 2.50, 4, 40);
     	inventario.add(huevos);
     StockArticulos arroz = new StockArticulos("ARROZ", 1.30, 21, 15);
     	inventario.add(arroz);
     StockArticulos pasta = new StockArticulos("PASTA", 1.25, 21, 25);
     	inventario.add(pasta);
     StockArticulos tomates = new StockArticulos("TOMATES", 2.35, 21, 35);
     	inventario.add(tomates);
     StockArticulos patatas = new StockArticulos("PATATAS", 2.10, 21, 10);
     	inventario.add(patatas);
     StockArticulos manzanas = new StockArticulos("MANZANAS", 1.75, 21, 45);
     	inventario.add(manzanas);
     
     Scanner sc = new Scanner(System.in);
     boolean otroCliente = true;
     double gananciasBrutoTotal = 0;
     double gananciasNetoTotal = 0;

     while (otroCliente) {
			HashMap<String, Double[]> compra = new HashMap<>();
			
			System.out.println("Este es el stock actual de la tienda:\n");
			mostrarStock();
			
			System.out.println("-- INICIO COMPRA --");
			comprarArticulos(sc, compra);
			imprimirResumenCompra(compra);

			double totalCompraBruto = calcularTotalCompraBruto(compra);
			double totalCompraNeto = calcularTotalCompraNeto(compra);
			gananciasBrutoTotal += totalCompraBruto;
			gananciasNetoTotal += totalCompraNeto;
			imprimirTotalesCompra(totalCompraBruto, totalCompraNeto);
			procesarPago(sc, totalCompraNeto);

			System.out.println("¿Hay otro cliente? (Y/N)");
			String respuesta = sc.nextLine().toUpperCase();

			if (!respuesta.equals("Y")) {
				otroCliente = false;
				System.out.println("\n-- CAJA FINAL --" +
						"\nGanancias totales (Bruto): " + gananciasBrutoTotal
						+ "\nGanancias totales (Neto): " + gananciasNetoTotal);
				
			} else {
				mostrarOpcionesInventario();
			}

     boolean continuar = true; // Variable para controlar si continuar en el bucle while

     while (continuar) {
         String opcion = JOptionPane.showInputDialog(null,
                 "Seleccione una opción:\n" + "1. Agregar artículo\n" + "2. Eliminar artículo\n"
                         + "3. Modificar cantidad\n" + "4. Mostrar stock\n" + "5. Salir",
                 "Menú de Opciones", JOptionPane.PLAIN_MESSAGE);

         switch (opcion) {
             case "1":
                 agregarArticulo();
                 break;
             case "2":
                 eliminarArticulo();
                 break;
             case "3":
                 modificarCantidad();
                 break;
             case "4":
                 mostrarStock();
                 // Preguntar al usuario si desea continuar después de mostrar el stock
                 continuar = JOptionPane.showConfirmDialog(null,
                 		"¿Desea realizar otra acción?", "Continuar",
                 			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                 break;
             case "5":
                 continuar = false; // Salir del bucle
                 break;
             default:
                 JOptionPane.showMessageDialog(null,
                 		"Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
	}
 
     }
     }
     }
	}
}
