package Ejercicio15.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private final String URL="jdbc:mysql://localhost:3306/ejemplos";
    private final String USUARIO="root";
    private final String CONTRASENA="";
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private Connection conexionBBDD;

    public Connection getConexionBBDD() {
        try {
            if (conexionBBDD==null) {
                Class.forName(DRIVER);
            conexionBBDD = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión CORRECTA a la base de datos."); }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
    } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  conexionBBDD;
    }

    public static void main(String[] args) {

    }
}
