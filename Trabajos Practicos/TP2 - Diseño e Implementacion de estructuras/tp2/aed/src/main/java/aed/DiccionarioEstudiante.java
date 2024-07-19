package aed;
// Invariante de Representacion de TrieEstudiante:

// - los valores de todos las claves son enteros >= 0

public class DiccionarioEstudiante extends Trie<Integer> {

    enum CargoDocente {
        AY2,
        AY1,
        JTP,
        PROF
    }

    // Constructor
    public DiccionarioEstudiante() {

    }

    // Método para inscribir y sumar 1 al valor existente de la clave
    public void inscribir(String clave) {
        Integer valorActual = this.buscar(clave);
        if (valorActual != null) {
            this.insertar(clave, valorActual + 1);
        } else {
            this.insertar(clave, 1);
        }
    }

    // Método para desinscribir y restar 1 al valor existente de la clave
    public void desinscribir(String clave) {
        Integer valorActual = this.buscar(clave);
        if (valorActual != 0) {
            this.insertar(clave, valorActual - 1);
        } else {
            this.insertar(clave, 0);
        }
    }
}
