package ABDE.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicio3 {
	   
	
   private static final String URL = "jdbc:mysql://localhost:3306";
   private static final String USER = "root";
   private static final String PASSWORD = "";
   


   private static Connection con;
   private static Statement stmt;
   
   
   public static void main(String[] args) {
       String dbName = "losAlmacenes";
       
       String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
       String useDatabaseSQL = "USE " + dbName;

       String createTableAlmacenesSQL = "CREATE TABLE IF NOT EXISTS ALMACENES ("
               + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
               + "Lugar NVARCHAR(100),"
               + "Capacidad INT"
               + ")";
       
 
       
       String createTableCajasSQL = "CREATE TABLE IF NOT EXISTS CAJAS ("
               + "Num_ref char(5) PRIMARY KEY,"
               + "Contenido NVARCHAR(100) NOT NULL,"
               + "Valor INT NOT NULL,"
               + "Almacen INT,"
               + "FOREIGN KEY (Almacen) REFERENCES ALMACENES(Codigo)"
               + ")";

       String[] insertAlmacenesSQL = {
               "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Almacen 1', 1000)",
               "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Almacen 2', 1500)",
               "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Almacen 3', 2000)",
               "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Almacen 4', 2500)",
               "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Almacen 5', 3000)"
       };

       String[] insertCajasSQL = {
               "INSERT INTO CAJAS (Num_ref, Contenido, Valor, Almacen) VALUES ('A001', 'Contenido A', 100, 1)",
               "INSERT INTO CAJAS (Num_ref, Contenido, Valor, Almacen) VALUES ('B002', 'Contenido B', 200, 2)",
               "INSERT INTO CAJAS (Num_ref, Contenido, Valor, Almacen) VALUES ('C003', 'Contenido C', 300, 3)",
               "INSERT INTO CAJAS (Num_ref, Contenido, Valor, Almacen) VALUES ('D004', 'Contenido D', 400, 4)",
               "INSERT INTO CAJAS (Num_ref, Contenido, Valor, Almacen) VALUES ('E005', 'Contenido E', 500, 5)"
       };


       try {
           
           con = DriverManager.getConnection(URL, USER, PASSWORD);
           stmt = con.createStatement();
           System.out.println();
          
           stmt.executeUpdate(createDatabaseSQL);

          
           stmt.executeUpdate(useDatabaseSQL);
      

          
           stmt.executeUpdate(createTableAlmacenesSQL);
           stmt.executeUpdate(createTableCajasSQL);


           for (String sql : insertAlmacenesSQL) {
               stmt.executeUpdate(sql);
           }

           
           for (String sql : insertCajasSQL) {
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
