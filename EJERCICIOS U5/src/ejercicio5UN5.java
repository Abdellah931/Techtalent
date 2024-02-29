import javax.swing.JOptionPane;

public class ejercicio5UN5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
int resto=numero%2;
if (resto==0) {
	JOptionPane.showMessageDialog(null, "Si, es par");
}else {
	JOptionPane.showMessageDialog(null, "Es impar");
}
	}

}
