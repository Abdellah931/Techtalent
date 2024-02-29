public class prueba1UN6 {

	public static void main(String[] args) {
		int operador1=-6, operador2=5;
		int resultado = sumaNumeros (operador1, operador2);
		System.out.println("El resultado es : " + resultado);
		
		if (positivos(resultado)) {
			System.out.println("El resultado es positivo");
		} else {
			System.out.println("El resultado es negativo");
		}

	}
	public static int sumaNumeros(int num1, int num2) {
		return num1+num2;
	}
	public static boolean positivos(int param1) {
		
		
		if (param1 >=0) {
			return true;
		} else {
			return false;
		}
	}
}
