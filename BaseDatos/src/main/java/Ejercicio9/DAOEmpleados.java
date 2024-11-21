package Ejercicio9;

import EjercicioBasico.ConnectionMySQL;

import java.sql.*;
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

    public void sacarDatos()  {
        try {
            Statement statement = this.getCon().createStatement();
            ResultSet rs = statement.executeQuery("select * from empleados");
            ResultSetMetaData result = rs.getMetaData();
            int numeroColumnas= result.getColumnCount();
            //Las columnas empiezan en 1!!!!!!
            for (int x=1;x<numeroColumnas;x++)
            {
              System.out.println("Columna "+x);
              System.out.println("Nombre: "+result.getColumnName(x)) ;
              System.out.println("tipo: "+result.getColumnTypeName(x)) ;
              System.out.println("¿Puede ser nulo?  " +result.isNullable(x));
              System.out.println("Máxima anchura: "+result.getColumnDisplaySize(x) );

            }
        } catch (SQLException e) {
            System.out.println("Error sql");
        }


    }


    public static void main(String[] args) {
        ConnectionMySQL act = new ConnectionMySQL();
        DAOEmpleados ejem = new DAOEmpleados();
        ejem.setConexion(act.getConexionBBDD());
        ejem.sacarDatos();

    }
}
