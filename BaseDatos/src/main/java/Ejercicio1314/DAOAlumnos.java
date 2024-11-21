package Ejercicio1314;

import java.sql.*;

public class DAOAlumnos {
    private Connection conexion = null;

    public void setConexion(Connection con) {
        this.conexion = con;
    }

    public Connection getCon() {
        return conexion;
    }
    public void hacerConsultaUltimaF1() {
            try {
                String consulta="Select * from alumnos order by id desc limit 1";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
                ResultSet rs= stmt.executeQuery();
                {
                    if (rs.next()) {
                       System.out.println("El id es: " + rs.getString("id"));
                        System.out.println("El nombre es: " + rs.getString("nombre"));
                        System.out.println("El apellido es: " + rs.getString("apellido"));
                        System.out.println("La edad es: " + rs.getString("edad"));
                        System.out.println("La nota es: " + rs.getInt("nota"));
                    }
                }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
    public void hacerConsultaUltimaF2() {
        try {

            String consulta="Select * from alumnos";
            Statement stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(consulta);
            {
                if (rs.last()) {
                    System.out.println("El id es: " + rs.getString("id"));
                    System.out.println("El nombre es: " + rs.getString("nombre"));
                    System.out.println("El apellido es: " + rs.getString("apellido"));
                    System.out.println("La edad es: " + rs.getString("edad"));
                    System.out.println("La nota es: " + rs.getInt("nota"));
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void hacerConsultaPrimeraF1() {
        try {
            String consulta="Select * from alumnos order by id asc limit 1";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            ResultSet rs= stmt.executeQuery();
            {
                if (rs.next()) {
                    System.out.println("El id es: " + rs.getString("id"));
                    System.out.println("El nombre es: " + rs.getString("nombre"));
                    System.out.println("El apellido es: " + rs.getString("apellido"));
                    System.out.println("La edad es: " + rs.getString("edad"));
                    System.out.println("La nota es: " + rs.getInt("nota"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void hacerConsultaPrimeraF2() {
        try {

            String consulta="Select * from alumnos";
            Statement stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(consulta);
            {
                if (rs.first()) {
                    System.out.println("El id es: " + rs.getString("id"));
                    System.out.println("El nombre es: " + rs.getString("nombre"));
                    System.out.println("El apellido es: " + rs.getString("apellido"));
                    System.out.println("La edad es: " + rs.getString("edad"));
                    System.out.println("La nota es: " + rs.getInt("nota"));
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
    DAOAlumnos EJEM = new DAOAlumnos();
    ConnectionMySQL n=new ConnectionMySQL();
    EJEM.setConexion(n.getConexionBBDD());
    EJEM.hacerConsultaPrimeraF1();
   // EJEM.hacerConsultaUltimaF2();
     EJEM.hacerConsultaPrimeraF2();
    }
}
