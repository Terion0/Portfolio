package Ejercicio15.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAlumnos {
    private Connection conexion = null;

    public void setConexion(Connection con) {
        this.conexion = con;
    }

    public Connection getCon() {
        return conexion;
    }
    public List<String> hacerConsultaV05() {
        List<String> lineas = new ArrayList<>();
            try {
                String consulta="Select * from alumnos";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
                ResultSet rs= stmt.executeQuery();
                {
                    while (rs.next()) {
                        String [] linformacion=new String[5];
                        linformacion[0]="El id es: " + rs.getString("id");
                        linformacion[1]="El nombre es: " + rs.getString("nombre");
                        linformacion[2]="El apellido es: " + rs.getString("apellido");
                        linformacion[3]="La edad es: " + rs.getString("edad");
                        linformacion[4]="La nota es: " + rs.getInt("nota");
                        StringBuffer linea=new StringBuffer();
                        for (String l : linformacion) {
                            linea.append("\n"+l);
                        }
                        lineas.add(linea.toString());
                    }
                }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
           return  lineas;
    }
    public List<String> hacerConsultaV1() {
        List<String> lineas = new ArrayList<>();
        try {
            String consulta="Select * from alumnos";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            ResultSet rs= stmt.executeQuery();
            {
                while (rs.next()) {
                    String [] linformacion=new String[3];
                    linformacion[0]=rs.getString("id")+",";
                    linformacion[1]=rs.getString("apellido")+",";
                    linformacion[2]= String.valueOf(rs.getInt("nota"));
                    StringBuffer linea=new StringBuffer();
                    for (String l : linformacion) {
                        linea.append(l);
                    }
                    lineas.add(linea.toString());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  lineas;
    }
    public boolean insertarNuevoAlumno(String nombre, String apellido, int edad, int nota) {
        boolean insertado=false;
        try
        {
            String consulta = "Insert into alumnos (nombre,apellido,edad,nota) VALUES (?,?,?,?)";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);
            ps.setInt(4,nota);
            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                insertado = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: El ID ya existe. No se puede insertar el alumno.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertado;
    }
    public boolean modificarNotaAlumno(int id, int nota) {
        boolean insertado=false;
        try {
            String consulta = "UPDATE alumnos SET nota=? WHERE id=?";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setInt(2,id);
            ps.setInt(1, nota);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                insertado = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: El ID ya existe. No se puede modificar la nota del alumno.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertado;
    }
    public boolean borrarAlumno(int id) {
        boolean borrado=false;
        try {
            String consulta = "delete from alumnos  WHERE id=?";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setInt(1,id);
            int filasBorradas = ps.executeUpdate();
            if (filasBorradas > 0) {
                borrado = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: El ID no existe. No se puede borrar este alumno.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return borrado;
    }
}
