
package ConexionBaseDtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigMySql {

  public static String url = "jdbc:mysql://localhost/proyectobd?useSSL=false&allowPublicKeyRetrieval=true";
    public static String usuario = "root";
    public static String contraseña = "123456";

 
    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.print("conexion establecida \n");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }
        return conexion;
    }

}
