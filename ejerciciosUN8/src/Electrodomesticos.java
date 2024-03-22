
public class Electrodomesticos {

	private int preciobase;
	private String color;
	private String consumoenergetico;
	private int peso;

	public Electrodomesticos() {
		this.preciobase = 100;
		this.color = "blanco";
		this.consumoenergetico = "F";
		this.peso = 5;

	}

	public Electrodomesticos(int precio, int weight) {

		this.preciobase = precio;
		this.color = "blanco";
		this.consumoenergetico = "F";
		this.peso = weight;

	}

	public Electrodomesticos(int precio, String colores, String consumo, int weight) {

		this.preciobase = precio;
		this.color = colores;
		this.consumoenergetico = consumo;
		this.peso = weight;

		switch (colores) {
		case "blanco":

			break;
		case "negro":

			break;
		case "azul":

			break;
		case "rojo":

			break;
		case "gris":

			break;
		default:
			this.color = null;
			break;

		}
	}

	@Override
	public String toString() {
		return "Electrodomestico:\n\t{Precio: " + preciobase + ", Color: " + color + ", Consumo: " + consumoenergetico
				+ " y Peso: " + peso;
	}

}
