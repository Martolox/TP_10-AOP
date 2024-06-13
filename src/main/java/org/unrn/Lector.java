package org.unrn;

import java.io.IOException;
import java.util.List;

public interface Lector {
    List<String[]> leerArchivo() throws IOException;
}
