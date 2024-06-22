package aed;

import java.util.NoSuchElementException;
import java.util.Stack;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private T valor;
        Nodo Nodoizq;
        Nodo Nododer;
        Nodo Nodopadre;

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

    private T findMinRec(Nodo raiz) {
        if (raiz.Nodoizq == null) {
            return raiz.valor;
        } else {
            return findMinRec(raiz.Nodoizq);
        }
    }

    private T findMaxRec(Nodo raiz) {
        if (raiz.Nododer == null) {
            return raiz.valor;
        } else {
            return findMaxRec(raiz.Nododer);
        }
    }

    public T minimo() {
        return findMinRec(raiz);
    }

    public T maximo() {
        return findMaxRec(raiz);
    }

    private Nodo insertarRec(Nodo raiz, T valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }
        if (valor.compareTo(raiz.valor) < 0) {
            raiz.Nodoizq = insertarRec(raiz.Nodoizq, valor);

        } else if (valor.compareTo(raiz.valor) > 0) {
            raiz.Nododer = insertarRec(raiz.Nododer, valor);

        } else {
            cardinal--;
        }
        return raiz;
    }

    public void insertar(T elem) {
        raiz = insertarRec(raiz, elem);
        cardinal++;
    }

    private boolean searchRec(Nodo raiz, T valor) {
        boolean res = true;
        if (raiz == null) {
            res = false; // El valor no está en el árbol
        } else if (valor.compareTo(raiz.valor) == 0) {
            ; // Valor encontrado

        } else if (valor.compareTo(raiz.valor) < 0) {
            return searchRec(raiz.Nodoizq, valor);

        } else if (valor.compareTo(raiz.valor) > 0) {
            return searchRec(raiz.Nododer, valor);
        }
        return res;
    }

    public boolean pertenece(T elem) {
        return searchRec(raiz, elem);
    }

    private Nodo deleteRec(Nodo raiz, T valor) {
        if (raiz == null) {
            return raiz; // El árbol está vacío o no se encontró el valor
        }

        // Buscar el nodo a eliminar
        if (valor.compareTo(raiz.valor) < 0) {
            raiz.Nodoizq = deleteRec(raiz.Nodoizq, valor);

        } else if (valor.compareTo(raiz.valor) > 0) {
            raiz.Nododer = deleteRec(raiz.Nododer, valor);
        } else {
            // Caso 1: El nodo a eliminar es una hoja (no tiene hijos)
            if (raiz.Nodoizq == null && raiz.Nododer == null) {
                return null;
            }
            // Caso 2: El nodo a eliminar tiene un solo hijo
            else if (raiz.Nodoizq == null) {
                return raiz.Nododer;
            } else if (raiz.Nododer == null) {
                return raiz.Nodoizq;
            }
            // Caso 3: El nodo a eliminar tiene dos hijos
            else {
                // Encontrar el sucesor (el mínimo del subárbol derecho)
                raiz.valor = findMinRec(raiz.Nododer);
                // Eliminar el sucesor
                raiz.Nododer = deleteRec(raiz.Nododer, raiz.valor);
            }
        }
        return raiz;
    }

    public void eliminar(T elem) {
        raiz = deleteRec(raiz, elem);
        cardinal--;
    }

    private void toStringRec(Nodo raiz, StringBuilder sb) {
        if (raiz != null) {
            toStringRec(raiz.Nodoizq, sb);
            if (raiz.valor != maximo()) {
                sb.append(raiz.valor).append(",");
            } else {
                sb.append(raiz.valor);
            }
            toStringRec(raiz.Nododer, sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        toStringRec(raiz, sb);
        sb.append("}");
        return sb.toString();
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual = raiz;
        private Stack<Nodo> stack = new Stack<>();

        public ABB_Iterador() {
            // Poner todos los nodos de la rama izquierda en la pila
            while (_actual != null) {
                stack.push(_actual);
                _actual = _actual.Nodoizq;
            }
        }

        public boolean haySiguiente() {
            return !stack.isEmpty();
        }

        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException();
            }
            // Obtener el nodo más a la izquierda
            _actual = stack.pop();
            T res = _actual.valor;

            // Si hay un subárbol derecho, poner todos sus nodos de la rama izquierda en la
            // pila
            if (_actual.Nododer != null) {
                _actual = _actual.Nododer;
                while (_actual != null) {
                    stack.push(_actual);
                    _actual = _actual.Nodoizq;
                }
            }

            return res;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
