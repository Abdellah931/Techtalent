import java.util.List;
import UD22_MVC.Ejercicio3.Modelo.Proyecto;


public class ProyectoController {

    public static void addProyecto(String idProyecto, String nombre, int horas) {
        Proyecto proyecto = new Proyecto(idProyecto, nombre, horas);
        proyecto.addProyecto();
    }

    public static List<Proyecto> getAllProyectos() {
        return Proyecto.getAllProyectos();
    }

    public static Proyecto getProyectoById(String idProyecto) {
        return Proyecto.getProyectoById(idProyecto);
    }

    public static void updateProyecto(String idProyecto, String nombre, int horas) {
        Proyecto proyecto = new Proyecto(idProyecto, nombre, horas);
        proyecto.updateProyecto();
    }

    public static void deleteProyecto(String idProyecto) {
        Proyecto.deleteProyecto(idProyecto);
    }

}
