import java.io.*;

public class Videoclub {
    final static String VIDEOCLUB = "Clientes.dat";


    void mostrarMenu() {
        System.out.println("1. Alta cliente.");
        System.out.println("2. Baja cliente.");
        System.out.println("3. Modificar opciones.");
        System.out.println("4. Consultar datos.");
        System.out.println("5. Listado de clientes.");
        System.out.println("6. Alquilar pelicula.");
        System.out.println("0. Finalizar programa");
        System.out.println("Elegir opción");
    }

    int pedirOpcion(Teclado t) throws IOException {
        int nIntroducido = 0;
        boolean valido = false;
        while (!valido) {
            try {
                mostrarMenu();
                nIntroducido = Integer.parseInt(t.leerString());
                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("No has introducido número");
            }
        }
        return nIntroducido;
    }

    void ejecutarOpcion(int nIntroducido, Teclado t) throws Exception {
        switch (nIntroducido) {
            case 1:
                dardeAltaUsuario(VIDEOCLUB,t);

                break;
            case 2:
               bajaUsuario(VIDEOCLUB,t);
                break;
            case 3:
               cambiarDatos(VIDEOCLUB,t);
                break;
            case 4:
                mostrar1Usuario(VIDEOCLUB,t);
                break;
            case 5:
                mostrarTodosUsuarios(VIDEOCLUB);
                break;
            case 6:
                alquilarPelicula(VIDEOCLUB,t);
                break;
            case 0:
                System.out.println("Fin programa");
                break;
            default:
                System.out.println("Opción no válida. Por favor, introduzca una opción válida");
        }
    }


   public void programaEntero() throws Exception {
        comprobarSiexiste();
       Teclado t = new Teclado();
       int n = 0;
       do {
           try {
               n = pedirOpcion(t);
               ejecutarOpcion(n, t);
           } catch (Exception e) {
               System.out.println("Error: "+e.getMessage());
           }
       } while (n != 0);
   }


    public void dardeAltaUsuario(String fichero, Teclado t) throws IOException {
        try {
            RandomAccessFile archivo = new RandomAccessFile(fichero, "rw");
            int linea = contarTodosUsuarios(fichero);
            Usuario nuevo = preguntarDatos(t);
            nuevo.irARegistro(archivo, linea, nuevo.getTamanoRegister());
            nuevo.escribirRAF(archivo);
        } catch (Exception e) {
            System.out.println("No hay archivo");
        }
    }
    public int contarTodosUsuarios(String fichero) throws IOException {
        RandomAccessFile archivo=new RandomAccessFile(fichero,"r");
        Usuario lectura=new Usuario();
        boolean hayDatos=lectura.leerRAF(archivo);
        int contadorPosicion=0;
        while (hayDatos) {
            contadorPosicion++;
            hayDatos=lectura.leerRAF(archivo);
        }
        archivo.close();
        return contadorPosicion;
    }
    public  void mostrarTodosUsuarios(String fichero) throws FileNotFoundException {
        RandomAccessFile archivo=new RandomAccessFile(fichero,"r");
        Usuario lectura=new Usuario();
        boolean hayDatos=lectura.leerRAF(archivo);

            while (hayDatos) {
                if (!lectura.comprobarNombre()) {
                    System.out.println(lectura);
                }
                hayDatos = lectura.leerRAF(archivo);
            }

    }
    public  void mostrar1Usuario(String fichero, Teclado t) throws IOException {
        System.out.println("Introduce tu nombre");
        String nombre=t.leerString();
        RandomAccessFile archivo=new RandomAccessFile(fichero,"r");
        Usuario lectura=new Usuario();
        boolean encontrado=false;
        boolean hayDatos=true;
        try {
            while (!encontrado && hayDatos) {
                hayDatos = lectura.leerRAF(archivo);
                lectura.setNombre(lectura.acortarNombre());
                if (lectura.getNombre().equals(nombre)) {
                    System.out.println(lectura);
                    encontrado = true;
                }
            }
            archivo.close();
            if (!encontrado){throw new Exception("Usuario no encontrado");}
    } catch (EOFException e){System.out.println("Se ha alcanzado fin de fichero");}
        catch (Exception e){System.out.println("Fallo inesperado. Error entrada/Salida");}
    }

    public  void alquilarPelicula(String fichero, Teclado t) throws Exception {
        System.out.println("Introduce tu nombre");
        String nombre = t.leerString();
        RandomAccessFile archivo = new RandomAccessFile(fichero, "rw");
        Usuario lectura = new Usuario();
        boolean encontrado = false;
        boolean hayDatos = true;
        int contadorRegistro = 0;
        try {
            while (!encontrado && hayDatos) {
                hayDatos = lectura.leerRAF(archivo);
                lectura.setNombre(lectura.acortarNombre());
                if (lectura.getNombre().equals(nombre)) {
                    lectura.setNumPeliculas(lectura.getNumPeliculas() + 1);
                    lectura.irARegistro(archivo, contadorRegistro, lectura.getTamanoRegister());
                    lectura.escribirRAF(archivo);
                    encontrado = true;
                    System.out.println("Pelicula alquilada");
                }
                contadorRegistro++;
            }
                if (!encontrado){throw new Exception("No se ha podido alquilar pelicula. Usuario no encontrado");}
        } catch (EOFException e){System.out.println("Se ha alcanzado fin de fichero");}
        catch (IOException e){System.out.println("Fallo inesperado. Error entrada/Salida");}
        }

    public void cambiarDatos(String fichero, Teclado t) throws Exception {
        System.out.println("Introduce tu nombre");
        String nombre=t.leerString();
        RandomAccessFile archivo=new RandomAccessFile(fichero,"rw");
        Usuario lectura=new Usuario();
        boolean encontrado=false;
        boolean hayDatos=true;
        int contadorRegistro=0;
        try {
            while (!encontrado && hayDatos) {
                hayDatos = lectura.leerRAF(archivo);
                lectura.setNombre(lectura.acortarNombre());
                if (lectura.getNombre().equals(nombre)) {
                    lectura.cambiarDatos(t);
                    lectura.irARegistro(archivo, contadorRegistro, lectura.getTamanoRegister());
                    lectura.escribirRAF(archivo);
                    encontrado=true;
                }
                contadorRegistro++;
            }
            if (!encontrado){throw new Exception("No se han podido realizar cambios sobre el usuario. Usuario no encontrado");}
        }  catch (EOFException e){System.out.println("Se ha alcanzado fin de fichero");}
        catch (IOException e){System.out.println("Fallo inesperado. Error entrada/Salida");}
        }

    public void bajaUsuario(String fichero, Teclado t) throws Exception {
        System.out.println("Introduce nombre");
        String nombre=t.leerString();
        RandomAccessFile archivo=new RandomAccessFile(fichero,"rw");
        Usuario lectura=new Usuario();
        boolean encontrado=false;
        boolean hayDatos=true;
        int contadorRegistro=0;
        try {
            while (!encontrado && hayDatos) {
                hayDatos = lectura.leerRAF(archivo);
                lectura.setNombre(lectura.acortarNombre());
                if (lectura.getNombre().equals(nombre)) {

                    lectura.irARegistro(archivo, contadorRegistro, lectura.getTamanoRegister());
                    lectura.borrarUsuario(archivo);
                    encontrado = true;
                }
                contadorRegistro++;
            }
            if (!encontrado) {throw new Exception("Usuario no existe");}
        } catch (EOFException e){System.out.println("Usuario no encontrado2");}
        catch (IOException e){System.out.println("Fallo inesperado. Error entrada/Salida");}

    }

    public Usuario preguntarDatos(Teclado t) throws IOException, Exception {
        try {
            System.out.println("Introduce tu nombre");
            String nombre = t.leerString();
            System.out.println("Introduce tu edad");
            int edad = t.leerInt();
            Usuario nuevo = new Usuario(nombre, edad);
            return nuevo;
        } catch (Exception e){throw new Exception("No se ha podido generar el usuario. Fallo en datos");}
    }

 public void comprobarSiexiste() throws Exception {
        try {
            File nuevo = new File(VIDEOCLUB);
            if (!nuevo.exists()) {
                nuevo.createNewFile();
            }
        } catch (Exception e){throw new  Exception("No se ha podido realizar la comprobación corerectamente");}
 }
    public static void main(String[] args) throws Exception {
        Videoclub manolo=new Videoclub();
        manolo.programaEntero();


    }
}