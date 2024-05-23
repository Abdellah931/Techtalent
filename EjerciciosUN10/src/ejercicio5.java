import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Password contra = new Password();
        Scanner sc = new Scanner(System.in);

        System.out.println("\033[33mIndique la cantidad de contraseñas que se generarán:\u001b[0m");
        int cantidad = sc.nextInt();

        System.out.println("\033[33mIndique la longitud de las contraseñas:\u001b[0m");
        int longitud = sc.nextInt();
        sc.close();
        Password contrasenas[] = new Password[cantidad];
        boolean fuerzasContras[] = new boolean[cantidad];
        System.out.println("\033[35m  Contraseña \u001b[0m |  \u001B[34mEs fuerte?\u001b[0m  |  \033[32mLongitud\u001b[0m  |  \033[31mNº Contraseña\u001b[0m  ");
        contra.setLongitud(longitud);
        for (int i = 0; i < contrasenas.length; i++) {
            contrasenas[i] = contra.generarPassword();
            fuerzasContras[i] = contrasenas[i].getFuerza();
            System.out.println("\033[35m" + contrasenas[i].getPass() + "\u001b[0m | \u001B[34m" + "\u001b[0m | \033[31m[" + i + "]\u001b[0m");
        }
    }
}