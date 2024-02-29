	import java.util.Scanner;

public class ejercicio11N5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Solicitar al usuario un día de la semana
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un día de la semana: ");
        String dia = scanner.nextLine().toLowerCase();

        // Determinar si es un día laboral o no
        boolean esDiaLaboral;
        switch (dia) {
            case "lunes":
            case "martes":
            case "miercoles":
            case "jueves":
            case "viernes":
                esDiaLaboral = true;
                break;
            case "sabado":
            case "domingo":
                esDiaLaboral = false;
                break;
            default:
                System.out.println("No es un día válido");
                return;
        }

        // Mostrar el resultado
        System.out.println(esDiaLaboral ? "Es un día laboral" : "No es un día laboral");
    }
}