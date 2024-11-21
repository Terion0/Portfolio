import Modelo.Logica.ModeloClases;
import Presentador.Presenter;
import Vista.VistaMain;

public class Programa {
    public static void main(String[] args) {
        ModeloClases modelo=new ModeloClases();
        VistaMain vista=new VistaMain();
        Presenter menu=new Presenter(modelo,vista);
        menu.menuPresentador();
    }
}
