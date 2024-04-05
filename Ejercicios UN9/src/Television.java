
public class Television extends Electrodomesticos1 {

	private static final double RESOLUCION_DEFAULT = 20;
    private static final boolean SINTONIZADOR_TDT_DEFAULT = false;
    private static final double PORCENTAJE_INCREMENTO_RESOLUCION = 0.3;
    private static final double PRECIO_INCREMENTO_SINTONIZADOR_TDT = 50;
    
    private double resolucion;
    private boolean sintonizadorTDT;
    
    public Television() {
    	this.precioBase=PRECIO_BASE_DEFAULT;
    	this.peso=PESO_DEFAULT;
    	this.color=COLOR_DEFAULT;
    	this.consumoEnergetico=CONSUMO_ENERGETICO_DEFAULT;
    	this.resolucion=RESOLUCION_DEFAULT;
    	this.sintonizadorTDT=SINTONIZADOR_TDT_DEFAULT;
    	
    	
    }
    public Television(double precio,double peso) {
    	this.precioBase=precio;
    	this.peso=peso;
    	this.color=COLOR_DEFAULT;
    	this.consumoEnergetico=CONSUMO_ENERGETICO_DEFAULT;
    	this.resolucion=RESOLUCION_DEFAULT;
    	this.sintonizadorTDT=SINTONIZADOR_TDT_DEFAULT;

    }
    public Television( double precio, double peso, char consumoEnergetico,String color,double resolucion, boolean sintonizadorTDT) {
        super(precio, peso, consumoEnergetico,color);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
}
    public double getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    // Método precioFinal()
    
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal *= (1 + PORCENTAJE_INCREMENTO_RESOLUCION);
        }

        if (sintonizadorTDT) {
            precioFinal += PRECIO_INCREMENTO_SINTONIZADOR_TDT;
        }

        return precioFinal;
    }

}
