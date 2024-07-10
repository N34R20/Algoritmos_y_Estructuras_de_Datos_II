package aed;

// Invariante de ListaDoblementeEnlazada

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo previo;

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
        Nodo nuevoNodo = new Nodo(elem);
        if (primero == null && ultimo == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;

        } else {
            primero.previo = nuevoNodo;
            nuevoNodo.siguiente = primero;

        }
        primero = nuevoNodo;
        longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (primero == null && ultimo == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;

        } else {
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.previo = ultimo;

        }
        ultimo = nuevoNodo;
        longitud++;
    }

    private Nodo NodoIesimo(int i) {
        Nodo actual = primero;

        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public T obtener(int i) {

        Nodo actual = NodoIesimo(i);
        return actual.valor;
    }

    public void eliminar(int i) {
        if (primero == null && ultimo == null) {
            /* es qeuivalente a no hacer nada o skip */;
        } else {
            Nodo actual = NodoIesimo(i);
            if (actual.previo == null) {
                primero = actual.siguiente;
            } else {
                actual.previo.siguiente = actual.siguiente;
            }
            if (actual.siguiente == null) {
                ultimo = actual.previo;
            } else {
                actual.siguiente.previo = actual.previo;
            }
            longitud--;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        if (primero == null && ultimo == null) {
            /* es qeuivalente a no hacer nada o skip */;
        } else {
            Nodo nodoConNuevoValor = NodoIesimo(indice);
            nodoConNuevoValor.valor = elem;
        }
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> listaCopia = new ListaEnlazada<>();

        Nodo actual = this.primero;
        while (actual != null) {
            listaCopia.agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
        return listaCopia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Nodo actual = this.primero;
        for (int i = 0; i < this.longitud(); i++) {

            if (actual.siguiente != null) {
                result.append(this.obtener(i).toString()).append(", ");
                actual = actual.siguiente;
            } else {
                result.append(this.obtener(i).toString());
            }
        }
        result.append("]");
        return result.toString();
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados
        private int i;
        private Nodo actualNodo;

        public ListaIterador() {
            this.i = 0;
            this.actualNodo = primero;
        }

        public boolean haySiguiente() {
            boolean res = false;
            if (i < longitud) {
                res = true;
            }
            return res;
        }

        public boolean hayAnterior() {
            boolean res = false;
            if (i > 0) {
                res = true;
            }
            return res;
        }

        public T siguiente() {
            T valor = actualNodo.valor;
            actualNodo = actualNodo.siguiente;
            i++;
            return valor;
        }

        public T anterior() {
            if (i < longitud) {
                actualNodo = actualNodo.previo;
                T valor = actualNodo.valor;
                i--;
                return valor;
            } else {
                T valor = ultimo.valor;
                i--;
                return valor;

            }

        }
    }

    public Iterador<T> iterador() {
        Iterador<T> it = new ListaIterador();
        return it;
    }

}
