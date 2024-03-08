import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.Iterator;
import java.util.Scanner;


public class ejercicio1UN7 {

	public static void main(String[] args) {

		
			Scanner scanner = new Scanner(System.in);

			System.out.print("Ingrese la cantidad de alumnos: ");
			int totalNotas = scanner.nextInt();

			Map<String, Double> notasAlumnos = new HashMap<>();
			// Indicar las Key(alumnos)
			for (int i = 1; i <= totalNotas; i++) {
				System.out.print("Ingrese el nombre del alumno " + i + ": ");
				double cantidadNotas = scanner.nextDouble();
				
				// Indicar las Value(nota)
				System.out.print("Ingrese la nota " + i + ": ");
				double nota = scanner.nextDouble();

				// Almacenar la nota en el HashMap
				notasAlumnos.put(nota,cantidadNotas);
			}

			double sumaNotas = 0;

			// Calcular la suma de las notas
			for (double nota : notasAlumnos.values()) {
				sumaNotas += nota;
			}

			double notaMedia = sumaNotas / totalNotas;

			System.out.println("La nota media de los " + cantidadNotas + " alumnos es: " + notaMedia);

			scanner.close();
		}
	}