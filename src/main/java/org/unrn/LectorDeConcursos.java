package org.unrn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorDeConcursos implements Lector {
    Scanner lector;

    public LectorDeConcursos(String ruta) {
        File concursos = new File(ruta);
        try {
            lector = new Scanner(concursos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Problemas al encontrar el archivo", e);
        }
    }

    @Override
    public List<String[]> leerArchivo() throws IOException {
        var lista = new ArrayList<String[]>();
        while (lector.hasNextLine()) {
            String[] strs = lector.nextLine().split(",");
            lista.add(strs);
        }
        return lista;
    }
}
