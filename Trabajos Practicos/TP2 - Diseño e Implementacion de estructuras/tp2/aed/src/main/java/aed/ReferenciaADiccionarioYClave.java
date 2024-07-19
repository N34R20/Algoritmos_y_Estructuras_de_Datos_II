package aed;

// Invariante de representacion de NodoCarreraYMateria:

// - dictMateria es un valor de DiccionarioCarrera
// - nombreMateria es una clave valida en dictMateria para cada par nombreMateria y dictMateria

public class ReferenciaADiccionarioYClave {
    DiccionarioMaterias dictMateria;
    String nombreMateria;

    public ReferenciaADiccionarioYClave(DiccionarioMaterias dictMateria, String nombreMateria) {
        this.dictMateria = dictMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public DiccionarioMaterias dictMateria() {
        return this.dictMateria;
    }
}
