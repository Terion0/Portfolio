package Ejercicio15.Presenter;

import Ejercicio15.View.vistaMain;
import Ejercicio15.Model.ModeloAlumnos;

import java.util.List;

public class Presentador {
   private ModeloAlumnos alumnado;
   private vistaMain vista;

    public Presentador(ModeloAlumnos ejem, vistaMain vist) {
        alumnado=ejem;
        vista=vist;
    }
void mostrarMenu() {
    vista.actualozarVista("Menú operaciones alumnos");
    vista.actualozarVista("1-Consultar alumnos");
    vista.actualozarVista("2-Insertar alumno");
    vista.actualozarVista("3-Modificar nota alumno");
    vista.actualozarVista("4-Borrar alumno por identificador");
    vista.actualozarVista("6-Consultar alumnos V2");
    vista.actualozarVista("5-Salir");
}
    void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1: hacerConsulta05(); break;
            case 2: insertarAlumno();break;
            case 3: modificarNotaAlumno();break;
            case 4: borrarAlumno(); break;
            case 5: finPrograma();break;
            case 6: hacerConsulta1();
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
    void hacerConsulta05() {
        List<String> lineas= alumnado.hacerConsultaV05();
        for (String linea : lineas) {
            vista.actualozarVista(linea);
        }
        vista.actualozarVista("Fin de muestra");
    }
    void hacerConsulta1() {
       alumnado.hacerConsultaV1();
    }
    void insertarAlumno() {
            vista.actualozarVista("Introduce nombre");
            String nombre = vista.cuestionarioString();
            vista.actualozarVista("Introduce apellido");
            String apellido = vista.cuestionarioString();
            vista.actualozarVista("Introduce edad");
            int edad = vista.cuestionarioint();
            vista.actualozarVista("Introduce nota");
            int nota = vista.cuestionarioint();
            boolean insertado = alumnado.insertarNuevoAlumno(nombre, apellido, edad, nota);
            if (insertado) {
                vista.actualozarVista("Intorducido con éxito");
            }
    }
    void modificarNotaAlumno() {
        vista.actualozarVista("Introduce id");
        int id = vista.cuestionarioint();
        vista.actualozarVista("Introduce nota");
        int nota = vista.cuestionarioint();
        boolean modificado = alumnado.modificarNotaAlumno(id, nota);
        if (modificado) {
            vista.actualozarVista("Modificado con éxito");
        }
    }
    void borrarAlumno() {
        vista.actualozarVista("Introduce id");
        int id = vista.cuestionarioint();
        boolean borrado=alumnado.borrarAlumno(id);
        if (borrado) {
            vista.actualozarVista("Eliminado con éxito");
        }
    }
    void limpiarPantalla(int opcion) {
        try {
            if (opcion==2 || opcion==3 || opcion==4)
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
