package Ejercicio15.Model;

import Ejercicio15.Data.ConnectionMySQL;
import Ejercicio15.Data.DAOAlumnos;
import Ejercicio15.Data.DAOHTML;

import java.util.List;

public class ModeloAlumnos {
   private DAOAlumnos bbdd= new DAOAlumnos();
   private DAOHTML html=new DAOHTML();

    public ModeloAlumnos() {
        ConnectionMySQL conexion= new ConnectionMySQL();
        bbdd.setConexion(conexion.getConexionBBDD());
    }
    public List<String> hacerConsultaV05() {
        return bbdd.hacerConsultaV05();
    }
    public void hacerConsultaV1() {
         if (!html.existeArchivo()) {html.generarArchivo();}
         String htmlS= rellenarArchivo(bbdd.hacerConsultaV1());
         html.escribirArchivo(htmlS);
         html.irAPagina();
    }
    public boolean insertarNuevoAlumno(String nombre, String apellido, int edad, int nota) {
       return bbdd.insertarNuevoAlumno(nombre,apellido,edad,nota);

    }
    public boolean modificarNotaAlumno(int id, int nota) {
       return  bbdd.modificarNotaAlumno(id,nota);
    }
    public boolean borrarAlumno(int id) {
       return bbdd.borrarAlumno(id);
    }
    public String rellenarArchivo(List<String> alumnos) {
        StringBuilder html=new StringBuilder();
        String finiquitado;
        html.append("<!DOCTYPE html>");
        html.append("<html>");
        // Etiqueta <head> con <title>
        html.append("<head>");
        html.append("<title>Mi Página con Tabla</title>");
        html.append("<meta charset='UTF-8'>"); // Definimos el charset para UTF-8
        html.append("</head>");
        // Etiqueta <body> con la tabla
        html.append("<body>");
        html.append("<h1>Tabla de Usuarios</h1>");
        // Crear la tabla
        html.append("<table border='1'>");
        html.append("<tr>");
        html.append("<th>ID</th>");
        html.append("<th>Apellido</th>");
        html.append("<th>Nota</th>");
        html.append("</tr>");
        // Cabecera de la tabla
        for (int x=0;x< alumnos.size();x++) {
            String [] split=alumnos.get(x).split(",");
            html.append("<tr>");
            html.append("<td>"+split[0]+"</td>");
            html.append("<td>"+split[1]+"</td>");
            html.append("<td>"+split[2]+"</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        html.append("</body>");

        // Cierre del HTML
        html.append("</html>");
        finiquitado=html.toString();
        return finiquitado;
    }




}
