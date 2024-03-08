import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.Iterator;
import java.util.Scanner;



public class ejercicioclase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de alumnos: ");
		int cantidadAlumnos = scanner.nextInt();
		
		
			System.out.print("Ingrese cantidad de notas x alumno ");
			int cantidadNotas = scanner.nextInt();

		Map<String, Double> notasAlumnos = new HashMap<>();
		
		
		// Indicar las Key(alumnos)
		for (int i = 1; i <= cantidadAlumnos; i++) {
			System.out.print("Ingrese el nombre del alumno " + i + ": ");
			String nombreAlumno = scanner.next();
			double notaMediaPorAlumno = 0;
			// Indicar las Value(nota)
			for (double j = 1; j <= cantidadNotas; j++) {
				System.out.print("Ingrese la nota " + j + ": ");
				notaMediaPorAlumno += scanner.nextDouble();
			
				// Almacenar la nota en el HashMap
			}
			notaMediaPorAlumno/=cantidadNotas;
			notasAlumnos.put(nombreAlumno, notaMediaPorAlumno);
			
			System.out.println("La nota media de "+ nombreAlumno + "es de " + notaMediaPorAlumno);
		}
		
		double sumaNotas = 0;
		
		// Calcular la suma de las notas
		for (double nota : notasAlumnos.values()) {
			 
			sumaNotas += nota;
		}

		double notaMedia = sumaNotas/cantidadAlumnos;

		System.out.println("La nota media de los " + cantidadAlumnos + " alumnos es: " + notaMedia);

		scanner.close();
		}
	}
		
