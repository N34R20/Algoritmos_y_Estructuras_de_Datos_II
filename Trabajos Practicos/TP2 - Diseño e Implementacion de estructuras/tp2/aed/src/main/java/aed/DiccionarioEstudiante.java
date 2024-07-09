package aed;

public class DiccionarioEstudiante extends Trie<Integer> {

    enum CargoDocente {
        AY2,
        AY1,
        JTP,
        PROF
    }

    // Invariante de Representacion de TrieEstudiante:

    // - Es un Trie
    // - Acceso a claves en O(1), pues para toda clave su largo nunca es mayor a 7
    // osea que esta acotada.
    // - los valores de tods las claves son enteros >= 0

    // Constructor
    public DiccionarioEstudiante() {

    }

    // Método para inscribir y sumar 1 al valor existente de la clave
    public void inscribir(String clave) {
        Integer valorActual = this.buscar(clave);
        if (valorActual != 0) {
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
