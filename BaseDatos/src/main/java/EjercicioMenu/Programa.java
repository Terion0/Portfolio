package EjercicioMenu;

import EjercicioMenu.Modelo.ModeloAlumnos;
import EjercicioMenu.Presentador.Presentador;
import EjercicioMenu.Vistas.vistaMain;

public class Programa {
    public static void main(String[] args) {
        ModeloAlumnos modelo=new ModeloAlumnos();
        vistaMain vista=new vistaMain();
        Presentador menu=new Presentador(modelo,vista);
        menu.menuPresentador();
    }
}
