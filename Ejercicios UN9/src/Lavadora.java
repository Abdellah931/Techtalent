
public class Lavadora extends Electrodomesticos1 {

	
	private static final double CARGA_DEFAULT= 5;
	
	private double carga;
	
	public Lavadora() {
		this.precioBase=PRECIO_BASE_DEFAULT;
		this.color=COLOR_DEFAULT;
		this.peso=PESO_DEFAULT;
		this.consumoEnergetico=CONSUMO_ENERGETICO_DEFAULT;
		this.carga=CARGA_DEFAULT;
		
	}
	public Lavadora(double precioBase, double peso){
		this.precioBase=precioBase;
		this.peso=peso;
		this.color=COLOR_DEFAULT;
		this.consumoEnergetico=CONSUMO_ENERGETICO_DEFAULT;
		this.carga=CARGA_DEFAULT;
	}
	public Lavadora(double carga, double precioBase, double peso, String color, char consumoEnergetico) {
		this.precioBase=precioBase;
		this.peso=peso;
		this.color=color;
		this.consumoEnergetico=consumoEnergetico;
        this.carga = carga;
	}
        public double getCarga() {
            return carga;
        }

        // Método precioFinal()
        @Override
        public double precioFinal() {
            double precioFinal = super.precioFinal();

            if (carga > 30) {
                precioFinal += 50;
            }

            return precioFinal;
        }

    }
