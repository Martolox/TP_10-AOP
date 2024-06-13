package org.unrn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmisorDeRegistros implements Emisor {
    BufferedWriter emisor;

    public EmisorDeRegistros(String rutaInsciptos) {
        try {
            emisor = new BufferedWriter(new FileWriter(rutaInsciptos));
        } catch (Exception e) {
            throw new RuntimeException("Problema al crear el BufferedWriter", e);
        }
    }

    @Override
    public void escribirArchivo(String texto) {
        try {
            emisor.write(texto);
            emisor.close();
        } catch (IOException e) {
            throw new RuntimeException("Problema al escribir en archivo", e);
        }

    }
}
