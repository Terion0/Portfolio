package Repositories;



import Modelo.Dataclasses.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionAlumno {

    private Session sesionIniciada;


    SessionAlumno() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alumno.class).buildSessionFactory();
        sesionIniciada = factory.getCurrentSession();
    }

    public Session getSesionIniciada() {
        return sesionIniciada;
    }
}


