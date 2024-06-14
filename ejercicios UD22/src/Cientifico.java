


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import UD22_MVC.Ejercicio3.Controller.conexion_database;

public class Cientifico {
    // Atributos
    private String dni_cientifico;
    private String nom_apels;

    // Constructor vacío
    public Cientifico() {}

    // Constructor con parámetros
    public Cientifico(String DNI, String nomApels) {
        this.dni_cientifico = DNI;
        this.nom_apels = nomApels;
    }

    // Getters y setters
    public String getdni_cientifico() {
        return dni_cientifico;
    }

    public void setdni_cientifico(String DNI) {
        this.dni_cientifico = DNI;
    }

    public String getNomApels() {
        return nom_apels;
    }

    public void setNomApels(String nomApels) {
        this.nom_apels = nomApels;
    }

    // Métodos de acceso a datos
    
    public static List<String> getAllNombresCientificos() {
        List<String> nombres = new ArrayList<>();
        String sql = "SELECT nom_apels FROM cientificos";
        try (Connection conn = conexion_database.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nombres.add(rs.getString("nom_apels"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombres;
    }
    
    public void addCientifico() {
        String sql = "INSERT INTO cientificos (dni_cientifico, nom_apels) VALUES (?, ?)";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getdni_cientifico());
            stmt.setString(2, this.getNomApels());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cientifico> getAllCientificos() {
        List<Cientifico> cientificos = new ArrayList<>();
        String sql = "SELECT * FROM cientificos";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cientifico cientifico = new Cientifico();
                cientifico.setdni_cientifico(rs.getString("dni_cientifico"));
                cientifico.setNomApels(rs.getString("nom_apels"));
                cientificos.add(cientifico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cientificos;
    }

    public static Cientifico getCientificoByDNI(String dni_cientifico) {
        Cientifico cientifico = null;
        String sql = "SELECT * FROM cientificos WHERE dni_cientifico = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dni_cientifico);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cientifico = new Cientifico();
                    cientifico.setdni_cientifico(rs.getString("dni_cientifico"));
                    cientifico.setNomApels(rs.getString("nom_apels"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cientifico;
    }

    public void updateCientifico() {
        String sql = "UPDATE cientificos SET nom_apels = ? WHERE dni_cientifico = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getNomApels());
            stmt.setString(2, this.getdni_cientifico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCientifico(String dni_cientifico) {
        String sql = "DELETE FROM cientificos WHERE dni_cientifico = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dni_cientifico);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        return nom_apels; // Devuelve solo el nombre y apellidos para su representación en el JComboBox
    }
}