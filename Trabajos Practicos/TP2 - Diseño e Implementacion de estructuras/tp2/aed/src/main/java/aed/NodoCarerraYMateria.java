package aed;

import aed.SistemaSIU.TrieMaterias;

// Inavriante de representacion de NodoCarreraYMateria:

// - trieMateria es un TrieMaterias
// - nombreMateria es un String

// - nombreMateria es una clave valida en trieMateria 
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
