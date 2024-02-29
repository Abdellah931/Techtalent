import javax.swing.JOptionPane;

public class ejercicio9UN5 {

	public static void main(String[] args) {
		// TODO Auto-generated
		int numero = Integer.parseInt(JOptionPane.showInputDialog("" + "Introduce el numero "));
		numero = 1;
		{

			if (numero % 2 == 0) {
				// Si es divisible, imprímelo
				System.out.println("es primo");

			} else {
				// Si es divisible, imprímelo
				System.out.println("no es primo");

			}

		}
	}
}