package UD22_MVC.Ejercicio3.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import UD22_MVC.Ejercicio3.Controller.conexion_database;

public class Proyecto {
    // Atributos
    private String idProyecto;
    private String nombre;
    private int horas;

    // Constructor vacío
    public Proyecto() {}

    // Constructor con parámetros
    public Proyecto(String idProyecto, String nombre, int horas) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.horas = horas;
    }

    // Getters y setters
    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    // Métodos de acceso a datos
    public void addProyecto() {
        String sql = "INSERT INTO proyecto (id_proyecto, nombre, horas) VALUES (?, ?, ?)";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getIdProyecto());
            stmt.setString(2, this.getNombre());
            stmt.setInt(3, this.getHoras());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Proyecto> getAllProyectos() {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getString("id_proyecto"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setHoras(rs.getInt("horas"));
                proyectos.add(proyecto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyectos;
    }

    public static Proyecto getProyectoById(String idProyecto) {
        Proyecto proyecto = null;
        String sql = "SELECT * FROM proyecto WHERE id_proyecto = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProyecto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    proyecto = new Proyecto();
                    proyecto.setIdProyecto(rs.getString("id_proyecto"));
                    proyecto.setNombre(rs.getString("nombre"));
                    proyecto.setHoras(rs.getInt("horas"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyecto;
    }

    public void updateProyecto() {
        String sql = "UPDATE proyecto SET nombre = ?, horas = ? WHERE id_proyecto = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getNombre());
            stmt.setInt(2, this.getHoras());
            stmt.setString(3, this.getIdProyecto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProyecto(String idProyecto) {
        String sql = "DELETE FROM proyecto WHERE id_proyecto = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProyecto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}