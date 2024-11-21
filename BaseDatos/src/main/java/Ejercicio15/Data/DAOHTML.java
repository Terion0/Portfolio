package Ejercicio15.Data;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DAOHTML {
    final private String ARCHIVO = "Alumnos.html";

    public String getARCHIVO() {
        return ARCHIVO;
    }

    public boolean existeArchivo() {
        File f = new File(ARCHIVO);
        return f.exists();
    }

    public boolean generarArchivo() {
        boolean generado = false;
        try {
            File f = new File(ARCHIVO);
            generado = f.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al generarArchivo");
            return false;
        }
        return generado;
    }

    public void escribirArchivo(String html) {
        File f = new File(ARCHIVO);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(html);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void irAPagina() {
        try {
            if (Desktop.isDesktopSupported()) {
                File f = new File(ARCHIVO);
                Desktop.getDesktop().browse(f.toURI());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
