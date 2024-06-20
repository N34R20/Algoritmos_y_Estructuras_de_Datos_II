package aed;

import aed.SistemaSIU.TrieMaterias;

public class NodoCarerraYMateria {
    TrieMaterias trieMateria;
    String nombreMateria;

    public NodoCarerraYMateria(TrieMaterias trieMateria, String nombreMateria) {
        this.trieMateria = trieMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public TrieMaterias raizCarrera() {
        return this.trieMateria;
    }
}
