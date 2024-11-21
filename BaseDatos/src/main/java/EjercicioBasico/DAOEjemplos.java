package EjercicioBasico;

import java.sql.*;

public class DAOEjemplos {
    private Connection conexion = null;

    public void setConexion(Connection con) {
        this.conexion = con;
    }

    public Connection getCon() {
        return conexion;
    }
    public void hacerConsulta() {
            try {
                String consulta="Select * from alumnos";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
                ResultSet rs= stmt.executeQuery(); {
                while (rs.next()) {
                    System.out.println("El nombre es: " + rs.getString("nombre") +
                            " y el ides: " + rs.getInt("id"));
                }
            }

        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
    public void insertarNuevoAlumno() {
        try {
            String consulta = "Insert into alumnos (nombre,apellido,edad,nota) VALUES (?,?,?,?)";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setString(1, "Carlos");
            ps.setString(2, "Lopez");
            ps.setInt(3, 20);
            ps.setInt(4, 9);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void modificarAlumno() {
        try {
            String consulta = "UPDATE alumnos SET nombre=?, apellido=? WHERE id=?";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setString(1, "Sanchinarro");
            ps.setString(2, "Julian");
            ps.setInt(3,3);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarAlumno() {
        try {
            String consulta = "delete from alumnos  WHERE id=?";
            PreparedStatement ps= conexion.prepareStatement(consulta);
            ps.setInt(1,4);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
