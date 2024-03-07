import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class pruebas {
    public static void main(String[] args) {
        // Nombres y edades
        String[] nombres = {"Abde", "Laia", "Jess", "Isabel", "Joel", "Alex", "Santos", "Alejandro", "Diego", "Jose", "Sebas", "Ana Maria", "Toni", "Manel", "Aurora"};
        Integer[] edades = {22, 23, 26, 18, 19, 28, 24, 22, 22, 26, 29, 27, 23, 23, 30};

        boolean [] asignado= new boolean [nombres.length];
        
        // Crear un array de objetos Person con nombres y edades
        Person[] personas = new Person[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            personas[i] = new Person(nombres[i], edades[i]);
        }

        // Generar e imprimir 5 grupos aleatorios
        System.out.println("Grupos Aleatorios:");
        for (int i = 0; i < 5; i++) {
            Person[] grupoAleatorio = generarGrupoAleatorio(personas,asignado);
            imprimirGrupo(grupoAleatorio);
        }

        // Ordenar las personas por edades de menor a mayor
        Arrays.sort(personas, Comparator.comparing(Person::getEdad));

        // Generar e imprimir 5 grupos ordenados por edades
        System.out.println("\nGrupos Ordenados por Edades:");
        for (int i = 0; i < 5; i++) {
            Person[] grupoOrdenado = Arrays.copyOfRange(personas, i * 3, (i + 1) * 3);
            imprimirGrupo(grupoOrdenado);
        }

        // Ordenar las personas alfabéticamente
        Arrays.sort(personas, Comparator.comparing(Person::getNombre));

        // Generar e imprimir 5 grupos ordenados alfabéticamente
        System.out.println("\nGrupos Ordenados Alfabéticamente:");
        for (int i = 0; i < 5; i++) {
            Person[] grupoAlfabetico = Arrays.copyOfRange(personas, i * 3, (i + 1) * 3);
            imprimirGrupo(grupoAlfabetico);
        }
    }

    // Método para generar un grupo aleatorio
    private static Person[] generarGrupoAleatorio(Person[] personas, boolean [] asignado) {
        Person[] grupo = new Person[3];
        Set<String> nombresUsados = new HashSet<>();
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int index;
            do {
            	
                index = rand.nextInt(personas.length);
                
                
            } while (asignado[index]);
            asignado [index]= true;
            grupo[i] = personas[index];
            nombresUsados.add(personas[index].getNombre());
        }
        return grupo;
        
    }

    // Método para imprimir un grupo de personas
    private static void imprimirGrupo(Person[] grupo) {
        for (Person persona : grupo) {
            System.out.println(persona.getNombre() + ": " + persona.getEdad());
        }
        System.out.println();
    }
}

// Clase para representar a una persona con nombre y edad
class Person {
    private String nombre;
    private int edad;

    public Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}