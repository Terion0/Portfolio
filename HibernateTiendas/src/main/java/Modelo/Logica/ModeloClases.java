package Modelo.Logica;


import Modelo.Dataclasses.Tiendas;
import Repositories.RepositorieTiendas;

import java.util.List;

public class ModeloClases {
    RepositorieTiendas RepTiendas;

    public ModeloClases() {
        RepTiendas =new RepositorieTiendas();
    }

    public void Insertar(String nombre, String localidad, double dineros1, double dineros2) {
        Tiendas aIntroducit=new Tiendas();
        aIntroducit.setNombre(nombre);
        aIntroducit.setLocalidad(localidad);
        aIntroducit.setBenefAnuales(dineros1);
        aIntroducit.setBenefMensuales(dineros2);
        RepTiendas.insertarTienda(aIntroducit);
    }
    public List<Tiendas> Consultar() {
        return  RepTiendas.totalTiendas();
    }

    public void Modificar(Tiendas Nuevo) {
        RepTiendas.updateTiendas(Nuevo);

    }
    public  void Borrar(Tiendas L) {
        RepTiendas.borrarTiendas(L);
    }
    public Tiendas buscar(int id) {
       return RepTiendas.sacarTiendas(id);
    }



}
