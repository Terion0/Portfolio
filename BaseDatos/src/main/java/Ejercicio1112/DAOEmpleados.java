package Ejercicio1112;

import EjercicioBasico.ConnectionMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpleados {
    private Connection conexion = null;

    public void setConexion(Connection con) {
        this.conexion = con;
    }

    public Connection getCon() {
        return conexion;
    }
    public String  sacarNombreDepartamento(int dept) {
        String nomDepart=null;
        try {
            String consulta = "select  dnombre as nombre from departamentos where dept_no=?";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            stmt.setInt(1,dept);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
              nomDepart=rs.getString("nombre");
                nomDepart="Departamento "+dept+ " ===> "+nomDepart;
            }
            else {nomDepart="INEXISTENTE";}

        }
        catch(SQLException e)
        {
            System.out.println("Error de sql"); return null;
        }
        return nomDepart;
    }
    public List<String> sacarMiembrosDepartamento(int dept) {
        List<String> trabajadores=new ArrayList<>();
        String linea;
        try {
            String consulta = "select apellido,oficio, salario  from empleados where dept_no=?";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            stmt.setInt(1,dept);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                linea=rs.getString("apellido")+"**"+rs.getString("oficio")+"**"+ rs.getDouble("salario");
                trabajadores.add(linea);
            }

        }
        catch(SQLException e)
        {
            System.out.println("Error de sql"); return null;
        }
        return trabajadores;
    }
    public float sacarMediaDept(int dept) {
        float media=0;
        try {
            String consulta="Select avg(salario) as media from empleados where dept_no=?";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            stmt.setInt(1,dept);
            ResultSet rs= stmt.executeQuery();
            {
                while (rs.next())
                {
                    media =  rs.getFloat("media");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return media;
    }
    public String sacarCantidadMiembrosDepartamento(int dept) {

        String linea="";
        try {
            String consulta = "select count(emp_no) as curritos  from empleados where dept_no=?";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            stmt.setInt(1,dept);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int lin=rs.getInt("curritos");
                linea=String.valueOf(lin);
            }

        }
        catch(SQLException e)
        {
            System.out.println("Error de sql"); return null;
        }
        return linea;
    }




    public static void main(String[] args) {
        try {
            ConnectionMySQL act = new ConnectionMySQL();
            DAOEmpleados ejem = new DAOEmpleados();
            ejem.setConexion(act.getConexionBBDD());
            System.out.println(ejem.sacarNombreDepartamento(20));
            List<String> curritos= ejem.sacarMiembrosDepartamento(20);
            curritos.forEach(System.out::println);
            System.out.println("Media : "+ ejem.sacarMediaDept(20));
            System.out.println("Cantidad de trabajadores : "+ ejem.sacarCantidadMiembrosDepartamento(20));

        } catch (Exception e) {e.getMessage();}
    }
}
