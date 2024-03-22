import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
import java.util.Scanner;
public class Password {

	private final int DEFAULT_LENGHT=8;
	private int longitud;
	private String contraseña;
	
	public Password() {
		this.longitud=DEFAULT_LENGHT;
		this.contraseña= generarPass(DEFAULT_LENGHT);
	}
	public Password(int passManual) {
		this.longitud=passManual;
		this.contraseña=generarPass(passManual);
	}
	public String toString()
	{
		return this.contraseña;
		
	}
		private String generarPass(int passLongitud)
		{
			Random randomGenerator = new Random();
			StringBuilder password = new StringBuilder();
			
			for(int i=0; i<passLongitud; i++) {
				password.append(randomGenerator.nextInt(0,9));
			}
			
			return password.toString();
		}
		
		
		public int getLongitud() {
			return longitud;
		}

		public void setLongitud(int longitud) {
			this.longitud = longitud;
		}

		public String getPass() {
			return contraseña;
		}

		public void setPass(String pass) {
			this.contraseña = pass;
		}

	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Scanner sc = new Scanner(System.in);
		int mp = sc.nextInt();
		Password nueva = new Password (mp);
		System.out.println(nueva);
	}

}
