package aed;

// Invariante de Representacion de TrieCarreras:

// Los valores que almacenan son instancias validas de DiccionarioMateria
// cumple el invariante de Trie

public class DiccionarioCarreras extends Trie<DiccionarioMaterias> {

    // Constructor
    public DiccionarioCarreras() {

    }

    public void insertar(String carrera, String nombreMateria, Materia materia) {
        TrieNode actual = this.getRoot();
        for (char c : carrera.toCharArray()) {
            TrieNode hijo = actual.getChild(c);
            if (hijo == null) {
                hijo = actual.addChild(c);
            }
            actual = hijo;
        }
        actual.esFinPalabra = true;
        if (actual.data != null) {
            actual.data.insertar(nombreMateria, materia);
        } else {
            actual.data = new DiccionarioMaterias();
            actual.data.insertar(nombreMateria, materia);
        }
    }
}