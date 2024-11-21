package Repositories;



import Modelo.Dataclasses.Tiendas;
import org.hibernate.query.Query;

import java.util.List;

public class RepositorieTiendas {
       SessionTiendas sesion;

       public RepositorieTiendas() {
       }

     public void insertarTienda(Tiendas aInsertar)
     {
           generarSesion();
           sesion.getSesionIniciada().beginTransaction();
           sesion.getSesionIniciada().save(aInsertar);
           sesion.getSesionIniciada().getTransaction().commit();
           sesion.getSesionIniciada().close();
     }
     public List<Tiendas> totalTiendas()
     {
           generarSesion();
           sesion.getSesionIniciada().beginTransaction();
           Query<Tiendas> query = sesion.getSesionIniciada().createQuery("from Tiendas", Tiendas.class);
           List<Tiendas> TiendasL = query.getResultList();
           sesion.getSesionIniciada().getTransaction().commit();
           return TiendasL;
}
    public Tiendas sacarTiendas(int id) {
        try {
            generarSesion();
            sesion.getSesionIniciada().beginTransaction();
            Tiendas consultada = sesion.getSesionIniciada().get(Tiendas.class, id);
            sesion.getSesionIniciada().getTransaction().commit();
            return consultada;
        } catch (Exception e) {return null;}
    }
    public void updateTiendas(Tiendas L) {
        generarSesion();
        sesion.getSesionIniciada().beginTransaction();
        sesion.getSesionIniciada().update(L);
        sesion.getSesionIniciada().getTransaction().commit();
    }
    public void borrarTiendas(Tiendas L) {
        generarSesion();
        sesion.getSesionIniciada().beginTransaction();
        sesion.getSesionIniciada().delete(L);
        sesion.getSesionIniciada().getTransaction().commit();
    }

 public void generarSesion() {
           sesion= new SessionTiendas();
 }
}
