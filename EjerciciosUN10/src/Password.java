import java.util.*;

public class Password {
    // ATRIBUTOS
    int longitud;
    final int LONG_PRED = 8;
    String password;
    final String[] simbolos = { "!", "@", "#", "$", "%", "^", "&", "*", "-", "_", "+", "=", "~", "/", "<", ">" };
    boolean esFuerte;

    // CONSTRUCTORES
    public Password() {
        this.longitud = LONG_PRED;

        Random numAleatorio = new Random();
        while (true) {
            StringBuilder pass = new StringBuilder();
            filtroGeneracion(simbolos, pass, longitud, numAleatorio);
            if (filtroMarc(simbolos, pass.toString())) {
                this.password = pass.toString();
                break;
            }
        }

        if (verFuerza(getPass())) {
            esFuerte = true;
        } else {
            esFuerte = false;
        }
    }

    public Password(int longitud) {
        this.longitud = longitud;

        Random numAleatorio = new Random();
        while (true) {
            StringBuilder pass = new StringBuilder();
            filtroGeneracion(simbolos, pass, longitud, numAleatorio);
            if (filtroMarc(simbolos, pass.toString())) {
                this.password = pass.toString();
                break;
            }
        }

        if (verFuerza(getPass())) {
            esFuerte = true;
        } else {
            esFuerte = false;
        }
    }

    // METODOS
    public boolean getFuerza() {
        return esFuerte;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getPass() {
        return password;
    }

    public Password generarPassword() {
        Password password = new Password(longitud);
        return password;
    }

    public boolean verFuerza (String password) {
        int numeros = 0;
        int mayus = 0;
        int minus = 0;
        for (char caracter : password.toCharArray()) {
            if (Character.isDigit(caracter)) {
                numeros++;
            } else if (Character.isUpperCase(caracter)) {
                mayus++;
            } else if (Character.isLowerCase(caracter)) {
                minus++;
            }
        }
        if (mayus > 2 && minus > 1 && numeros > 5) {
            return true;
        } else {
            return false;
        }
    }

    public static void filtroGeneracion(String[] simbolos, StringBuilder pass, int longitud, Random numAleatorio) {
        for (int i = 1; i <= longitud; i++) {
            int indiceLetra = numAleatorio.nextInt(10000);
            if (indiceLetra % 13 == 0) {
                indiceLetra = numAleatorio.nextInt(simbolos.length);
                pass.append(simbolos[indiceLetra]);
            } else if (indiceLetra % 7 == 0) {
                indiceLetra = numAleatorio.nextInt(10) + 48;
                char character = (char) indiceLetra;
                pass.append(character);
            } else if (indiceLetra % 2 == 0) {
                indiceLetra = numAleatorio.nextInt(26) + 65;
                char character = (char) indiceLetra;
                pass.append(character);
            } else {
                indiceLetra = numAleatorio.nextInt(26) + 97;
                char character = (char) indiceLetra;
                pass.append(character);
            }
        }
    }

    public static boolean filtroMarc(String[] simbolos, String contra) {
        int cantidadSimbolos = 0;
        double veintePorcientoDouble = contra.length()/5;
        int veintePorcientoInt = contra.length()/5;
        int veintePorciento = 0;
        if (veintePorcientoDouble - veintePorcientoInt != 0) {
            veintePorciento = veintePorcientoInt+1;
        } else {
            veintePorciento = veintePorcientoInt;
        }

        char[] caracteres = contra.toCharArray();
        for (char caracter : caracteres) {
            String simbolo = String.valueOf(caracter);
            if (Arrays.asList(simbolos).contains(simbolo)) {
                cantidadSimbolos++;
            }
        }
        if (cantidadSimbolos == veintePorciento) {
            return true;
        } else {
            return false;
        }
    }
}