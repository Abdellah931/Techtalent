import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aula {

	Map<String, Double> Alumnos = new HashMap<>();
	Map<String, String> Profesores = new HashMap<>();

	protected String nombreP;
	protected int cantidadAlumnos;
	protected int edadP;
	protected String sexo;
	protected int indentificador;
	protected int numMaxEstudiantes;
	protected String materia;

	public Aula(String nombreP, int cantidadAlumnos, int edadP, String sexo, int identificador, int numMaxEstudiantes,
			String materia) {
		this.nombreP = nombreP;
		this.cantidadAlumnos = cantidadAlumnos;
		this.edadP = edadP;
		this.sexo = sexo;
		this.indentificador = identificador;
		this.numMaxEstudiantes = numMaxEstudiantes;
		this.materia = materia;

		Profesores.put(nombreP, materia);
	}

	public void Aula() {

		if (cantidadAlumnos > 15 || cantidadAlumnos < 0) {
			System.out.println("La cantidad de alumnos es incorrecta");
		} else {
			{
				if (nombreP.contains("marc") && materia.contains("matematicas")
						|| nombreP.contains("joan") && materia.contains("filosofia")
						|| nombreP.contains("diego") && materia.contains("fisica")) {

					Scanner sc = new Scanner(System.in);
					for (int i = 1; i <= cantidadAlumnos; i++) {
						System.out.println("Ingrese nombre de los alumnos");
						String nombres = sc.next();
						System.out.println("Ingrese la edad del alumno");
						int edades = sc.nextInt();

					}

//			if (cantidadAlumnos > 15 || cantidadAlumnos < 0) {
//				System.out.println("La cantidad de alumnos es incorrecta");
//				break;
//			}
//			{
//				if (nombreP.contains("marc") && materia.contains("matematicas")
//						|| nombreP.contains("joan") && materia.contains("filosofia")
//						|| nombreP.contains("diego") && materia.contains("fisica")) {
//					System.out.println("La materia no coincide con el profesor");
//					break;
//				}
				} else {
					System.out.println("La materia no coincide con el profesor");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Nombre profesor: " + nombreP + "\nCantidad de alumnos: " + cantidadAlumnos + "\nEdad del profesor: "
				+ edadP + "\nSexo: " + sexo + "\nIdentificador: " + numMaxEstudiantes + "\nMateria: " + materia;
	}
}
// clase estudiantes profesor y aula y una interfaz