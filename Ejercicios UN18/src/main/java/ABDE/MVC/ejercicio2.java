package ABDE.MVC;
import java.sql.Connection;     // necesarias para trabajar con JDBC (Java Database Connectivity), que es la API estándar de Java para interactuar con bases de datos//
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ejercicio2 {
	 // JDBC URL, username, and password de Mysql//
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
 // JDBC variables que abren y manejan la conexión
    private static Connection con;
    private static Statement stmt;
    
    
//creación de bases de datos (la vertebra y la carne)//
    public static void main(String[] args) {
        String dbName = "empleados";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableDepartamentosSQL = "CREATE TABLE IF NOT EXISTS DPS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100),"
                + "Presupuesto INT"
                + ")";
        
        String createTableEmpleadoSQL = "CREATE TABLE IF NOT EXISTS EMPLEADO ("
                + "DNI INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Apellidos NVARCHAR(255) NOT NULL,"
                + "Departamento INT,"
                + "FOREIGN KEY (Departamento) REFERENCES DPS(Codigo)"
                + ")";

        String[] insertEmpleadosSQL = {
                "INSERT INTO EMPLEADO (Nombre, Apellidos, Departamento) VALUES ('Empleado A','Apellidos A', 1)",
                "INSERT INTO EMPLEADO (Nombre, Apellidos, Departamento) VALUES ('Empleado B','Apellidos B', 2)",
                "INSERT INTO EMPLEADO (Nombre, Apellidos, Departamento) VALUES ('Empleado C','Apellidos C', 3)",
                "INSERT INTO EMPLEADO (Nombre, Apellidos, Departamento) VALUES ('Empleado D','Apellidos D', 4)",
                "INSERT INTO EMPLEADO (Nombre, Apellidos, Departamento) VALUES ('Empleado E','Apellidos E', 5)"
        };

        String[] insertDepartamentosSQL = {
                "INSERT INTO DPS (Nombre, Presupuesto) VALUES ('Departamento 1', 100)",
                "INSERT INTO DPS (Nombre, Presupuesto) VALUES ('Departamento 2', 200)",
                "INSERT INTO DPS (Nombre, Presupuesto) VALUES ('Departamento 3', 300)",
                "INSERT INTO DPS (Nombre, Presupuesto) VALUES ('Departamento 4', 400)",
                "INSERT INTO DPS (Nombre, Presupuesto) VALUES ('Departamento 5', 50)"
        };

        try {
            // abrir la conexión a bases de datos//
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            System.out.println();
            // creación//
            stmt.executeUpdate(createDatabaseSQL);

            //uso de la nva base de datos//
            stmt.executeUpdate(useDatabaseSQL);
       

            // crear tablas//
            stmt.executeUpdate(createTableDepartamentosSQL);
            stmt.executeUpdate(createTableEmpleadoSQL);


            // Insertar datos en FABRICANTES
            for (String sql : insertDepartamentosSQL) {
                stmt.executeUpdate(sql);
            }

            // lo mismo para ARTICULOS//
            for (String sql : insertEmpleadosSQL) {
                stmt.executeUpdate(sql);
            }

            System.out.println("Database, tables created, and records inserted successfully.");

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //finalmente, se cierra la conexión a la base//
            try {
                con.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
            try {
                stmt.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
