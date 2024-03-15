import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.Iterator;
import java.util.Scanner;


public class ejercicio1UN7 {

	public static void main(String[] args) {

		
			Scanner scanner = new Scanner(System.in);

			System.out.print("Ingrese la cantidad de alumnos: ");
			int totalAlumnos = scanner.nextInt();
			System.out.print("Ingrese la cantidad de notas x alumno: ");
			int totalNotas = scanner.nextInt();


			Map<String, Double> notasAlumnos = new HashMap<>();
			
			for (int i = 1; i <= totalAlumnos; i++) {
				
				
				System.out.print("Ingrese el nombre del alumno " + i + ": ");
				String nombreAlumno = scanner.next();
			
				
				for (int j = 1; j <= totalNotas; j++) {
				System.out.print("Ingrese la nota ");
				double nota = scanner.nextDouble();
				
				notasAlumnos.put(nombreAlumno,nota);

				double sumaNotas = 0;
				for (double notas : notasAlumnos.values()) {
					sumaNotas += notas;
				}

				double notaMedia = sumaNotas / totalNotas;
				
				System.out.println(notaMedia);
				
								}
			}
			
double deu=0;
	double fin=0;

			for (double notas : notasAlumnos.values()) {
				deu += notas;
			

			 fin = deu / totalAlumnos;
			
			}
			System.out.println("La nota media de los " + totalNotas + " alumnos es: " + fin);
		
			scanner.close();
			
			}
	}
	