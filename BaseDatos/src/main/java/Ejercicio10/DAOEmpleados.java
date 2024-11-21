package Ejercicio10;

import EjercicioBasico.ConnectionMySQL;

import java.sql.*;

public class DAOEmpleados {
    private Connection conexion = null;

    public void setConexion(Connection con) {
        this.conexion = con;
    }

    public Connection getCon() {
        return conexion;
    }
    public int cambioAInt(String agr)  {
        int depta=0;
        try {
            depta = Integer.parseInt(agr.trim());
        } catch (NumberFormatException e) {System.out.println("Error de tipado de dato (int)");}
        return depta;
    }
    public double cambioADouble(String agr) {
        double salar=0.0;
        try {
             salar = Double.parseDouble(agr.trim());
        } catch (NumberFormatException e) {System.out.println("Error de tipado de dato (double)");}
        return salar;
    }
    public boolean comprobarArgs(String [] agr)
    {
        if (agr.length<7) {
            System.out.println("Los argumentos son 7. Faltan argumentos");
            return false;
        }
        else {return true;}
    }
    public boolean comprobarDept(int depta)
    {
        try {
            String consulta = "select count(dept_no) as cantidad from departamentos where dept_no=?";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            stmt.setInt(1,depta);
            ResultSet rs = stmt.executeQuery();
               return rs.next();
        }
        catch(SQLException e)
        {
                System.out.println("Error de sql"); return false;
        }

    }
    public boolean comprobarnumEmpleado(int empleado)
    {
        {
            try {
                String consulta = "select count(emp_no) as cantidad from empleados where emp_no=?";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
                stmt.setInt(1,empleado);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
            catch(SQLException e)
            {
                System.out.println("Error de sql"); return false;
            }
        }
    }
    public boolean salarioBien(double salario)
    {
        return salario > 0;
    }
    public boolean DirExiste(int direct)
    {
        {
            int cant=0;
            try {
                String consulta = "select count(dir) as cantidad from empleados where dir=?";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
                stmt.setInt(1,direct);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
            catch(SQLException e)
            {
                System.out.println("Error de sql"); return false;
            }
        }
    }
    public void insertarNuevoEmpleado(int emp_noD, String apellidoD,
                                      String oficioD, int dirD, String fechaD,
                                      double salarioD, double comisionD, int dept_noD) {
        try {
            String consulta = "Insert into empleados (emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dept_no) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setInt(1, emp_noD);
            ps.setString(2,apellidoD);
            ps.setString(3,oficioD);
            ps.setInt(4, dirD);
            ps.setString(5,fechaD);
            ps.setDouble(6,salarioD);
            ps.setDouble(7,comisionD);
            ps.setInt(8,dept_noD);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        try {
            ConnectionMySQL act = new ConnectionMySQL();
            DAOEmpleados ejem = new DAOEmpleados();
            ejem.setConexion(act.getConexionBBDD());
            if (ejem.comprobarArgs(args))
            {
                int emp_no = ejem.cambioAInt(args[0]);
                String apellido=args[1];
                String oficio=args[2];
                int dir = ejem.cambioAInt(args[3]);
                String fecha=args[4];
                double salario = ejem.cambioADouble(args[5]);
                double comision = ejem.cambioADouble(args[6]);
                int dept_no = ejem.cambioAInt(args[7]);
                if (ejem.comprobarDept(dept_no)) {
                    if (ejem.comprobarnumEmpleado(emp_no)) {
                        if (ejem.salarioBien(salario)) {
                            if (ejem.DirExiste(dir)) {
                                ejem.insertarNuevoEmpleado(emp_no,apellido,oficio,dir,fecha,salario,comision,dept_no);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {e.getMessage();}
    }
}
