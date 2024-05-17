
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionPrueba {

    public static void main(String[]args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306","root","");
            System.out.print("Server Connected");
        }catch(SQLException | ClassNotFoundException e) {
            System.out.print("Lo siento. No se puede conectar a la Base de datos");
            System.out.print(e);
        }
    }
}