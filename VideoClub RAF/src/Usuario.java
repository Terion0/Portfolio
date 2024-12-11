import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Usuario {
    private String nombre;
    private int numeroCliente;
    private int edad;
    private int numPeliculas;
    static int numCliente;
    final static int LONGITUDNOMBRE=20;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumPeliculas() {
        return numPeliculas;
    }

    public void setNumPeliculas(int numPeliculas) {
        this.numPeliculas = numPeliculas;
    }
    Usuario(String nombre, int edad ) {
        this.nombre=nombre;
        this.edad=edad;
        numeroCliente=numCliente;
        numCliente++;
        numPeliculas=0;
    }
    Usuario(){};
    Usuario(int numClienteR){
        numCliente=numClienteR;
    }
    int getTamanoRegister(){
        return (LONGITUDNOMBRE*2 + (3*4));//2 bytes por caracter y 4 bytes por int;
        // Tamaños típicos de los tipos de datos primitivos en Java en bytes:
         // byte: 1 byte
         // short: 2 bytes
         // int: 4 bytes
         // long: 8 bytes
         // float: 4 bytes
         // double: 8 bytes
         // char: 2 bytes
        // boolean: Tamaño específico no definido, generalmente se almacena como 1 byte
    }
    void irARegistro(RandomAccessFile f, int pos, int tamReg) throws IOException {
        f.seek(pos* tamReg);
    }
    char [] rellenarNombre(String nombre){
        char nombreChar []=new char[LONGITUDNOMBRE];
        for (int letra=0;letra<nombre.length();letra++){
            nombreChar[letra]=nombre.charAt(letra);
        }
        for (int espacio=nombre.length();espacio<nombreChar.length;espacio++){
            nombreChar[espacio]=(char) 0;
        }
        return nombreChar;
    }
    void escribirRAF(RandomAccessFile archivo) throws IOException {
        char nombreChar[];
        nombreChar=rellenarNombre(this.getNombre());
        archivo.writeInt(this.getNumeroCliente());
        archivo.writeChars(String.valueOf(nombreChar));
        archivo.writeInt(getEdad());
        archivo.writeInt(getNumPeliculas());
    }
    void borrarUsuario(RandomAccessFile archivo) throws IOException {
        char nombreChar[];
        nombreChar=rellenarNombre("");
        archivo.writeInt(0);
        archivo.writeChars(String.valueOf(nombreChar));
        archivo.writeInt(0);
        archivo.writeInt(0);
    }
    boolean leerRAF(RandomAccessFile archivo) {
        try {
            StringBuffer nombreBuffer=new StringBuffer(LONGITUDNOMBRE);
            nombreBuffer.setLength(LONGITUDNOMBRE);
            char letra='a';
            int cantLetras=0, tamanoString=LONGITUDNOMBRE;
            this.setNumeroCliente(archivo.readInt());
            for (cantLetras=0;cantLetras<LONGITUDNOMBRE;cantLetras++){
                letra=archivo.readChar();
                nombreBuffer.setCharAt(cantLetras,letra);
                if (letra=='\0'){tamanoString=cantLetras;}
            }
            nombreBuffer.setLength(cantLetras);
            setNombre(nombreBuffer.toString());
            setEdad(archivo.readInt());
            setNumPeliculas(archivo.readInt());
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    public String acortarNombre(){
        StringBuffer nombre= new StringBuffer(this.getNombre());
        int longitud=0;
        boolean finNombre=false;
        for (int letras=0;letras<nombre.length() && !finNombre;letras++){
            char n=nombre.charAt(letras);
            if (Character.isLetter(n)){
                longitud++;
            }
            else {finNombre=true;}
        }
        nombre.setLength(longitud);
        String nombreAcortado=nombre.toString();
        return nombreAcortado;
    }
    public boolean comprobarNombre(){
        boolean vacio=true;
        for (int letras=0;letras<this.nombre.length();letras++){
            char n=nombre.charAt(letras);
            if (Character.isLetter(n)){
                vacio=false;
            }
        }
       return vacio;
    }
    public void cambiarDatos(Teclado t) throws IOException {
            System.out.println("!Hola!" +this.getNombre());
            System.out.println("¿Qué quieres cambiar?");
            System.out.println("0-Nombre  1-edad  2-Peliculas alquiladas");
            int opcion = t.leerInt();
            switch (opcion) {
                case 0:
                        System.out.println(this.getNombre());
                        System.out.println("Introduce tu nuevo nombre");
                        String nombre = t.leerString();
                        char [] nombreC=rellenarNombre(nombre);
                        this.setNombre(String.valueOf(nombreC));
                break;
                case 1:
                      System.out.println("tu edad es de " +this.getEdad()+" años.");
                      System.out.println("cambia tu edad");
                      int edad = t.leerInt();
                        this.setEdad(edad);
                break;
                case 2:
                    System.out.println("Has alquilado "+this.getNumPeliculas());
                    System.out.println("cambia tus peliculas");
                    int peliculas = t.leerInt();
                    this.setNumPeliculas(peliculas);
                    break;
            }
        }



    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", numeroCliente=" + numeroCliente +
                ", edad=" + edad +
                ", numPeliculas=" + numPeliculas +
                '}';
    }

    public static void main(String[] args) throws IOException {
        Usuario nuevo=new Usuario();
        Teclado t2=new Teclado();
        System.out.println(nuevo);
        System.out.println(nuevo);
    }


}
