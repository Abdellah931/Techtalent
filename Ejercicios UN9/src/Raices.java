
public class Raices {

	protected double a;
	protected double b;
	protected double c;

	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getDiscriminante() {
		double discriminante = (Math.pow(b, 2)) - 4 * a * c;
		return discriminante;

	}

	public boolean tieneRaices() {
		boolean tieneRaices = false;
		if (getDiscriminante() > 0) {
			tieneRaices = true;
		}
		return tieneRaices;
	}

	public boolean tieneRaiz() {
		boolean tieneRaiz = false;
		if (getDiscriminante() == 0)
			;
		{
			tieneRaiz = true;
		}
		return tieneRaiz;
	}

	public void calcular() {
		
		if(tieneRaices()) {
			obtenerRaices();
			
		} else if (tieneRaiz()) {
			obtenerRaiz();
		}
	}

	public void obtenerRaices() {
		
		double x1=(-b + Math.sqrt(getDiscriminante())) / (2 * a);
		double x2=(-b - Math.sqrt(getDiscriminante())) / (2 * a);
		System.out.println("Las soluciones son " + x1 + " y " + x2);
	}

	public void obtenerRaiz() {

		double x3=-b / (2 * a);
		System.out.println("La unica solucion es: " + x3);

	}
@Override
public String toString() {
	return "a= "+a+"\nb= "+b+"\nc= "+c;
}
}
