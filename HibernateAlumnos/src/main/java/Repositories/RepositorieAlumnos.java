package Repositories;


import Modelo.Dataclasses.Alumno;
import org.hibernate.query.Query;

import java.util.List;

public class RepositorieAlumnos {
       SessionAlumno sesion;

       public RepositorieAlumnos() {
       }

     public void insertarAlumno(Alumno aInsertar)
     {
           generarSesion();
           sesion.getSesionIniciada().beginTransaction();
           sesion.getSesionIniciada().save(aInsertar);
           sesion.getSesionIniciada().getTransaction().commit();
           sesion.getSesionIniciada().close();
     }
     public List<Alumno> totalAlumnos()
     {
           generarSesion();
           sesion.getSesionIniciada().beginTransaction();
           Query<Alumno> query = sesion.getSesionIniciada().createQuery("from Alumno", Alumno.class);
           List<Alumno> AlumnosL = query.getResultList();
           sesion.getSesionIniciada().getTransaction().commit();
           return AlumnosL;
}
    public Alumno sacarAlumno(int id) {
        try {
            generarSesion();
            sesion.getSesionIniciada().beginTransaction();
            Alumno fede = sesion.getSesionIniciada().get(Alumno.class, id);
            sesion.getSesionIniciada().getTransaction().commit();
            return fede;
        } catch (Exception e) {return null;}
    }
    public void updateAlumno(Alumno L) {
        generarSesion();
        sesion.getSesionIniciada().beginTransaction();
        sesion.getSesionIniciada().update(L);
        sesion.getSesionIniciada().getTransaction().commit();
    }
    public void borrarAlumno(Alumno L) {
        generarSesion();
        sesion.getSesionIniciada().beginTransaction();
        sesion.getSesionIniciada().delete(L);
        sesion.getSesionIniciada().getTransaction().commit();
    }

 public void generarSesion() {
           sesion= new SessionAlumno();
 }
}
