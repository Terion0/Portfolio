package Ejercicio8;

import EjercicioBasico.ConnectionMySQL;
import EjercicioBasico.DAOEjemplos;

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
    public float sacarMediaDept() {
        float media=0;
            try {
                String consulta="Select avg(salario) as media from empleados where dept_no=10";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
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
    public String sacarMaxDept() {
       String linea = "";
        try {
            String consulta="Select apellido,salario from empleados " +
                    "where dept_no=10 and salario=(select max(salario) from empleados)";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            ResultSet rs= stmt.executeQuery(); {
                while (rs.next()) {

                    linea =  rs.getString("apellido") + " "+rs.getFloat("salario");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return linea;
    }
    public List<String> sacarInfoEmpleadosDept() {
        List<String> empelados=new ArrayList<>();
        try {
            String consulta = "Select * from empleados where dept_no=10";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empelados.add(rs.getString("apellido") +","
                         + rs.getString("oficio")+","+ rs.getFloat("salario"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empelados;
    }
    public String rellenarArchivo(List<String> empelados) {
        StringBuilder html=new StringBuilder();
        String finiquitado;
        html.append("<!DOCTYPE html>");
        html.append("<html>");
        // Etiqueta <head> con <title>
        html.append("<head>");
        html.append("<title>Mi Página con Tabla</title>");
        html.append("<meta charset='UTF-8'>"); // Definimos el charset para UTF-8
        html.append("</head>");
        // Etiqueta <body> con la tabla
        html.append("<body>");
        html.append("<h1>Tabla de empelados</h1>");
        // Crear la tabla
        html.append("<table border='1'>");
        html.append("<tr>");
        html.append("<th>ID</th>");
        html.append("<th>oficio</th>");
        html.append("<th>salario</th>");
        html.append("</tr>");
        // Cabecera de la tabla
        for (int x=0;x< empelados.size();x++) {
            String [] split=empelados.get(x).split(",");
            html.append("<tr>");
            html.append("<td>"+split[0]+"</td>");
            html.append("<td>"+split[1]+"</td>");
            html.append("<td>"+split[2]+"</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        html.append("</body>");

        // Cierre del HTML
        html.append("</html>");
        finiquitado=html.toString();
        return finiquitado;
    }
    public void sacarDatos(List<String> empelados, float media, String max) {
        System.out.println("============================================");
        System.out.println("APELLIDO           OFICIO           SALARIO ");
        for (String linea : empelados) {
            System.out.println(linea);
        }
        System.out.println("============================================");
        System.out.println("El salario medio es: "+media+"              ");
        System.out.println("============================================");
        System.out.println(max);

    }



    public static void main(String[] args) {
        ConnectionMySQL act = new ConnectionMySQL();
        DAOEmpleados ejem = new DAOEmpleados();
        DAOHTML view= new DAOHTML();
        ejem.setConexion(act.getConexionBBDD());
        List<String> n=ejem.sacarInfoEmpleadosDept();
        if (!view.existeArchivo()) {view.generarArchivo();}
        String html= ejem.rellenarArchivo(n);
        view.escribirArchivo(html);
        view.irAPagina();}
}
