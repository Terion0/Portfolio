package Repositories;




import Modelo.Dataclasses.Tiendas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionTiendas {

    private Session sesionIniciada;


    SessionTiendas() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tiendas.class).buildSessionFactory();
        sesionIniciada = factory.getCurrentSession();
    }

    public Session getSesionIniciada() {
        return sesionIniciada;
    }
}


