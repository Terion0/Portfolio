package EjercicioBasico;

public class Programa {

    public static void main(String[] args) {
        ConnectionMySQL act = new ConnectionMySQL();
        DAOEjemplos ejem = new DAOEjemplos();
        ejem.setConexion(act.getConexionBBDD());
       ejem.hacerConsulta();
        System.out.println("----------");
      ejem.insertarNuevoAlumno();
       ejem.hacerConsulta();
        System.out.println("----------");
       ejem.modificarAlumno();
       ejem.hacerConsulta();
        System.out.println("----------");
       ejem.borrarAlumno();
       ejem.hacerConsulta();
    }
}
