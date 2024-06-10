
import java.sql.Connection;     // necesarias para trabajar con JDBC (Java Database Connectivity), que es la API estándar de Java para interactuar con bases de datos//
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ejercicio3 {
	 // JDBC URL, username, and password de Mysql//
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
 // JDBC variables que abren y manejan la conexión
    private static Connection con;
    private static Statement stmt;
//creación de bases de datos (la vertebra y la carne)//
    public static void main(String[] args) {
        String dbName = "tiendaInformatica";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableFabricantesSQL = "CREATE TABLE IF NOT EXISTS FABRICANTES ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL"
                + ")";

        String createTableArticulosSQL = "CREATE TABLE IF NOT EXISTS ARTICULOS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Precio INT NOT NULL,"
                + "Fabricante INT,"
                + "FOREIGN KEY (Fabricante) REFERENCES FABRICANTES(Codigo)"
                + ")";

        String[] insertFabricantesSQL = {
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante A')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante B')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante C')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante D')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante E')"
        };

        String[] insertArticulosSQL = {
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 1', 100, 1)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 2', 200, 2)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 3', 300, 3)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 4', 400, 4)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 5', 500, 5)"
        };

        try {
            // abrir la conexión a bases de datos//
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();

            // creación//
            stmt.executeUpdate(createDatabaseSQL);

            //uso de la nva base de datos//
            stmt.executeUpdate(useDatabaseSQL);

            // crear tablas//
            stmt.executeUpdate(createTableFabricantesSQL);
            stmt.executeUpdate(createTableArticulosSQL);

            // Insertar datos en FABRICANTES
            for (String sql : insertFabricantesSQL) {
                stmt.executeUpdate(sql);
            }

            // lo mismo para ARTICULOS//
            for (String sql : insertArticulosSQL) {
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
