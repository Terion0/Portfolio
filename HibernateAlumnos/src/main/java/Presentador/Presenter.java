package Presentador;


import Modelo.Dataclasses.Alumno;

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
        vista.actualozarVista("0-Insertar Alumno");
        vista.actualozarVista("1-Consultar Alumnos");
        vista.actualozarVista("2-Modificar Alumnos");
        vista.actualozarVista("3-Borrar Alumnos");
        vista.actualozarVista("5-Salir");
    }
    void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 0: InsertarAlumno(); break;
            case 1: consultarAlumnos();break;
            case 2: modificarAlumnos();break;
            case 3: borrarAlumnos();break;
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
  public void InsertarAlumno(){
      vista.actualozarVista("Introduce nombre");
      String nombre = vista.cuestionarioString();
      vista.actualozarVista("Introduce apellido");
      String apellido = vista.cuestionarioString();
      vista.actualozarVista("Introduce edad");
      int edad = vista.cuestionarioint();
      vista.actualozarVista("Introduce nota");
      double nota = vista.cuestionariodouble();
      clases.InsertarAlumnos(nombre, apellido, edad, nota);
  }
  public void consultarAlumnos(){
        List<Alumno> lista= clases.ConsultarAlumnos();
        for (Alumno a: lista) {
            vista.actualozarVista(a.toString());
        }
  }
  public void modificarAlumnos() {
      vista.actualozarVista("Introduce id");
      int id = vista.cuestionarioint();
      Alumno L = clases.buscarAlumno(id);
      if (L != null) {
          vista.actualozarVista("Introduce nombre");
          L.setNombre(vista.cuestionarioString());
          vista.actualozarVista("Introduce apellido");
          L.setApellido(vista.cuestionarioString());
          vista.actualozarVista("Introduce edad");
          L.setEdad(vista.cuestionarioint());
          vista.actualozarVista("Introduce nota");
          L.setNota(vista.cuestionariodouble());
          clases.ModificarAlumno(L);
      }
      else{
              vista.actualozarVista("Alumno no existe");
          }

      }

  public void borrarAlumnos()
  {
      vista.actualozarVista("Introduce id");
      int id = vista.cuestionarioint();
      Alumno L = clases.buscarAlumno(id);
      if (L != null) {
          clases.BorrarAlumno(L);
      }
      else{
          vista.actualozarVista("Alumno no existe");
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
