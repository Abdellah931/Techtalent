public class Ejercicio2 {
    
	
    public static class CustomEx extends Exception {
        public CustomEx(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando el programa...");
          
            throw new CustomEx("Este es un mensaje de "
            		+ "excepción personalizado.");

        } catch (CustomEx e) {
            
            System.out.println("Excepción capturada: " + e.getMessage());
        } finally {
            System.out.println("Bloque finally ejecutado.");
        }
    }
}