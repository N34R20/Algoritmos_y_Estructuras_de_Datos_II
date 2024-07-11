package aed;

// Invariante de representacion de NodoCarreraYMateria:

// - nombreMateria es una clave valida en trieMateria

public class NodoCarreraYMateria {
    DiccionarioMaterias dictMateria;
    String nombreMateria;

    public NodoCarreraYMateria(DiccionarioMaterias dictMateria, String nombreMateria) {
        this.dictMateria = dictMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public DiccionarioMaterias raizCarrera() {
        return this.dictMateria;
    }
}
