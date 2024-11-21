package Ejercicio15;

import Ejercicio15.Model.ModeloAlumnos;
import Ejercicio15.Presenter.Presentador;
import Ejercicio15.View.vistaMain;

public class Programa {
    public static void main(String[] args) {
        ModeloAlumnos modelo=new ModeloAlumnos();
        vistaMain vista=new vistaMain();
        Presentador menu=new Presentador(modelo,vista);
        menu.menuPresentador();
    }
}
