import java.text.SimpleDateFormat;
import java.util.Date;

public class prueba2UN5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				int dia = 1; // Por ejemplo, 3 representa el miércoles

				String nombreDia;

				switch (dia) {
				case 1:
					nombreDia = "Lunes";
					break;
				case 2:
					nombreDia = "Martes";
					break;
				case 3:
					nombreDia = "Miércoles";
					break;
				case 4:
					nombreDia = "Jueves";
					break;
				case 5:
					nombreDia = "Viernes";
					break;
				case 6:
					nombreDia = "Sábado";
					break;
				case 7:
					nombreDia = "Domingo";
					break;
				default:
					nombreDia = "Día inválido";
					break;
				}

				System.out.println("La semana comienza el : " + nombreDia);

				// Ejemplo con Date()
				Date fecha = new Date();
				System.out.println(fecha);
				SimpleDateFormat formatoDia = new SimpleDateFormat("u");
				int diaNumero = Integer.parseInt(formatoDia.format(fecha));

				switch (diaNumero) {
				case 1:
					nombreDia = "Lunes";
					break;
				case 2:
					nombreDia = "Martes";
					break;
				case 3:
					nombreDia = "Miércoles";
					break;
				case 4:
					nombreDia = "Jueves";
					break;
				case 5:
					nombreDia = "Viernes";
					break;
				case 6:
					nombreDia = "Sábado";
					break;
				case 7:
					nombreDia = "Domingo";
					break;
				default:
					nombreDia = "Día inválido";
					break;
				}

				System.out.println("Hoy es: " + nombreDia);
	}

}
