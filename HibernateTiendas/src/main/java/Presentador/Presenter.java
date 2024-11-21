package Presentador;


import Modelo.Dataclasses.Tiendas;
import Modelo.Logica.ModeloClases;
import Vista.VistaMain;

import java.util.List;

public class Presenter {
    private ModeloClases clases;
    private VistaMain vista;

    public Presenter(ModeloClases ejem, VistaMain vist) {
        clases=ejem;
        vista=vist;
    }
    void mostrarMenu() {
        vista.actualozarVista("Menú operaciones usuarios");
        vista.actualozarVista("0-Insertar tienda");
        vista.actualozarVista("1-Consultar tiendas");
        vista.actualozarVista("2-Modificar tiendas");
        vista.actualozarVista("3-Borrar tiendas");
        vista.actualozarVista("5-Salir");
    }
    void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 0: InsertarTienda(); break;
            case 1: consultarTienda();break;
            case 2: modificarTienda();break;
            case 3: borrarTienda();break;
            case 5: finPrograma();break;
            default: opcionnovalida();
        }
    }
    public void menuPresentador() {
        int opcion=-1;
        while (opcion!=5) {
            mostrarMenu();
            opcion=vista.cuestionarioint();
            ejecutarOpcion(opcion);
            limpiarPantalla(opcion);
        }
    }
  public void InsertarTienda(){
      vista.actualozarVista("Introduce nombre");
      String nombre = vista.cuestionarioString();
      vista.actualozarVista("Introduce localidad");
      String localidad = vista.cuestionarioString();
      vista.actualozarVista("Introduce benefAnuales");
      double benefAnual = vista.cuestionariodouble();
      vista.actualozarVista("Introduce benefMensuales");
      double benefMensual = vista.cuestionariodouble();
      clases.Insertar(nombre, localidad, benefAnual, benefMensual);
  }
  public void consultarTienda(){
        List<Tiendas> lista= clases.Consultar();
        for (Tiendas a: lista) {
            vista.actualozarVista(a.toString());
        }
  }
  public void modificarTienda() {
      vista.actualozarVista("Introduce id");
      int id = vista.cuestionarioint();
      Tiendas L = clases.buscar(id);
      if (L != null) {
          vista.actualozarVista("Introduce nombre");
          L.setNombre(vista.cuestionarioString());
          vista.actualozarVista("Introduce localidad");
          L.setLocalidad(vista.cuestionarioString());
          vista.actualozarVista("Introduce benefAnuales");
          L.setBenefAnuales(vista.cuestionariodouble());
          vista.actualozarVista("Introduce benefMensuales");
          L.setBenefMensuales(vista.cuestionariodouble());
          clases.Modificar(L);
      }
      else{
              vista.actualozarVista("Tienda no existe");
          }

      }

  public void borrarTienda()
  {
      vista.actualozarVista("Introduce id");
      int id = vista.cuestionarioint();
      Tiendas L = clases.buscar(id);
      if (L != null) {
          clases.Borrar(L);
      }
      else{
          vista.actualozarVista("Tienda no existe");
      }

  }



    void limpiarPantalla(int opcion) {
        try {
            if (opcion!=5)
            {
                Thread.sleep(2000);
                for (int x=0;x<50;x++)
                {
                    vista.actualozarVista("");
                }
            }

        } catch (InterruptedException e) {System.out.println("Error de threads"); }
    }
    void finPrograma() {vista.actualozarVista("Fin de programa");}
    void opcionnovalida() {vista.actualozarVista("Opción no válida");}


}
