package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        T valor;
        Nodo sig;
        Nodo prev;

        Nodo(T v) {
            valor = v;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        nuevo.sig = primero;
        primero = nuevo;
        nuevo.prev = ultimo;
        ultimo = nuevo;
        longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = nuevo;
        }
    }

    public T obtener(int i) {
        return ListaEnlazada[i];
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo prev = primero;
        for (int j = 0; j < i; j++) {
            prev = actual;
            actual = actual.sig;
        }
        if (i == 0) {
            primero = actual.sig;
        } else {
            prev.sig = actual.sig;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.sig;
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public boolean hayAnterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T anterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
