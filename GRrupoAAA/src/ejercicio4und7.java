import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ejercicio4und7 {

	public static void main(String[] args) {

//		double precioProductoNeto;
		double sumaCompra = 0;
		Map<String, Double> stockProducto = new HashMap<>();

		stockProducto.put("patano", 2.99);
		stockProducto.put("po", 5.2);
		stockProducto.put("pato", 2.0);
		stockProducto.put("pata", 9.0);
		stockProducto.put("pelel", 99.8);
		stockProducto.put("zatano", 39.0);
		stockProducto.put("aranadno", 2.0);
		stockProducto.put("pera", 7.8);

		Scanner sc = new Scanner(System.in);

		System.out.print("Quiere ver los articulos disponibles en stock? ");
		String articulosDisponibles = sc.next();
		System.out.print("Quiere añadir al carrito articulos ? ");
		String añadirAcarrito = sc.next();

		if (articulosDisponibles.equals("si")) {
			System.out.println(stockProducto);

		} else if (articulosDisponibles.equals("no")) {
			System.out.println("no se mostrara el stock");

		}

		if (añadirAcarrito.equals("si")) {
			System.out.println("\nProcede a añadir los productos y las cantidades de forma manual");

			System.out.println("Escriba cantidad de productos que quiere comprar ");
			int cantidadProducto = sc.nextInt();

			Map<String, Double> precio = new HashMap<>();

			for (int i = 1; i <= cantidadProducto; i++) {

				System.out.println("añade producto al carrito: ");
				String nombrearticulo = sc.next();

				if (stockProducto.containsKey(nombrearticulo)) {
					System.out.println("El producto cuesta: " + stockProducto.get(nombrearticulo));
					double producto = stockProducto.get(nombrearticulo);

					System.out.println("añade cantidad de ese articulo que quiere comprar: ");
					int cantidad = sc.nextInt();
					double preciofinal = producto * cantidad;
					System.out.println("El total del producto es: " + preciofinal + "€");

					System.out.print("Es producto de primera necesidad: ");
					String necesidadIVA = sc.next();

					necesidadIVA = necesidadIVA.toLowerCase();
					double precioProductoNeto;

					if (necesidadIVA.equals("si")) {
						precioProductoNeto = (preciofinal * 1.04);
						System.out.println("el IVA sera del 4%: " + preciofinal * 0.04 + "\nEl precio neto es de: "
								+ precioProductoNeto);

					} else {
						precioProductoNeto = (preciofinal * 1.21);
						System.out.println("El IVA sera del 21%: " + preciofinal * 0.21 + "\nEl precio neto es de: "
								+ precioProductoNeto);
					}

					precio.put(nombrearticulo, precioProductoNeto);

				} else {

					System.out.println("Escriba el precio de " + nombrearticulo + ": ");
					double precioProducto = sc.nextDouble();

					System.out.print("Es producto de primera necesidad: ");
					String necesidadIVA = sc.next();

					necesidadIVA = necesidadIVA.toLowerCase();
					double precioProductoNeto;

					if (necesidadIVA.equals("si")) {
						precioProductoNeto = (precioProducto * 1.04);
						System.out.println("el IVA sera del 4%: " + precioProducto * 0.04 + "\nEl precio neto es de: "
								+ precioProductoNeto);

					} else {
						precioProductoNeto = (precioProducto * 1.21);
						System.out.println("El IVA sera del 21%: " + precioProducto * 0.21 + "\nEl precio neto es de: "
								+ precioProductoNeto);
					}

					System.out.println("Escriba la cantidad del articulo que desea añadir: ");
					int cantidadProductos = sc.nextInt();

					double PrecioTotal = (double) (cantidadProductos * precioProductoNeto);
					System.out.println(cantidadProductos + " " + nombrearticulo + " de " + precioProductoNeto
							+ "€ son: " + PrecioTotal + "€");

					precio.put(nombrearticulo, PrecioTotal);

				}

				sumaCompra = 0;
				for (double m : precio.values()) {
					sumaCompra += m;
				}

			}
			System.out.println(sumaCompra);
		}
		sc.close();

	}

}
