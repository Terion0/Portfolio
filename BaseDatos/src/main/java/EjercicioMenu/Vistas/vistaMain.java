package EjercicioMenu.Vistas;

import java.util.Scanner;

public class vistaMain {
 private Scanner sc=new Scanner(System.in);
 public void actualozarVista(String linea) {System.out.println(linea);}
    public int  cuestionarioint() {
     return    sc.nextInt();
    }
    public String cuestionarioString() {
    String t=sc.next();
    return t;}


}
