public class CustomEx extends Exception {
    public CustomEx(String mensaje) {
        super(mensaje);
    }

    public static void esPar(int numero) throws CustomEx {
        if (numero % 2 == 0) {
            throw new CustomEx("\033[35mNúmero par\u001b[0m");
        } else {
            throw new CustomEx("\033[35mNúmero impar\u001b[0m");
        }
    }
}