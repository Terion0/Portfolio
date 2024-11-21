package Modelo.Logica;


import Modelo.Dataclasses.Alumno;

import Repositories.RepositorieAlumnos;


import java.util.List;

public class ModeloClases {
    RepositorieAlumnos RepAlumnos;

    public ModeloClases() {
        RepAlumnos=new RepositorieAlumnos();
    }

    public void InsertarAlumnos(String nombre,String apellido,int edad,double nota) {
        Alumno aIntroducit=new Alumno();
        aIntroducit.setNombre(nombre);
        aIntroducit.setApellido(apellido);
        aIntroducit.setEdad(edad);
        aIntroducit.setNota(nota);
        RepAlumnos.insertarAlumno(aIntroducit);


    }
    public List<Alumno> ConsultarAlumnos() {
        return  RepAlumnos.totalAlumnos();
    }

    public void ModificarAlumno(Alumno Nuevo) {
        RepAlumnos.updateAlumno(Nuevo);

    }
    public  void BorrarAlumno(Alumno L) {
        RepAlumnos.borrarAlumno(L);
    }
    public Alumno buscarAlumno(int id) {
       return RepAlumnos.sacarAlumno(id);
    }



}
