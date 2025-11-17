package com.ebac.modulo45;

import java.io.FileWriter;
import java.io.IOException;

public class ClaseExcepciones {
    public static void main(String[] args) throws IOException {
        crearArchivoDos("/Users/nesto/Documents/tmp/archivos/archivo.txt");
    }
//Excepciones checked
    public static void crearArchivo(String nombreArchivo){
        try{
            FileWriter fw = new FileWriter(nombreArchivo);
        }catch (IOException e){
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }finally{
            System.out.println("Bloque finally");
        }

    }

    public static void crearArchivoDos(String nombreArchivo) throws IOException {
        FileWriter fw2 = new FileWriter(nombreArchivo);
    }
}
