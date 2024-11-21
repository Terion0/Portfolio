package EjercicioMenu.Modelo;

import EjercicioMenu.Data.ConnectionMySQL;
import EjercicioMenu.Data.DAOAlumnos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ModeloAlumnos {
    DAOAlumnos bbdd= new DAOAlumnos();

    public ModeloAlumnos() {
        ConnectionMySQL conexion= new ConnectionMySQL();
        bbdd.setConexion(conexion.getConexionBBDD());
    }
    public List<String> hacerConsulta() {
        return bbdd.hacerConsulta();
    }
    public boolean insertarNuevoAlumno(String nombre, String apellido, int edad, int nota) {
       return bbdd.insertarNuevoAlumno(nombre,apellido,edad,nota);

    }
    public boolean modificarNotaAlumno(int id, int nota) {
       return  bbdd.modificarNotaAlumno(id,nota);
    }
    public boolean borrarAlumno(int id) {
       return bbdd.borrarAlumno(id);
    }
}
