package aed;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private T valor;
        Nodo izqNodo;
        Nodo derNodo;

        // Crear Constructor del nodo
        Nodo(T v) {
            valor = v;
        }
    }

    public ABB() {
        raiz = null;
        this.cardinal = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T maximo() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void insertar(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (cardinal == 0) {
            raiz = nuevoNodo;
        }
        cardinal++;
    }

    public boolean pertenece(T elem) {
        boolean res = true;
        if (cardinal == 0) {
            res = false;
        } else if (raiz.valor != elem) {
            res = false;
        }
        return res;
    }

    public void eliminar(T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
