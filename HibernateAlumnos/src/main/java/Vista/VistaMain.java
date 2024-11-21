package Vista;

import java.util.Scanner;

public class VistaMain {
    private Scanner sc=new Scanner(System.in);
    public void actualozarVista(String linea) {System.out.println(linea);}
    public int  cuestionarioint() {
        return    sc.nextInt();
    }
    public double  cuestionariodouble() {
        return    sc.nextDouble();
    }
    public String cuestionarioString() {
        String t=sc.next();
        return t;}


}
