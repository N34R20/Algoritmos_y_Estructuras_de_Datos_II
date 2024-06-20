package aed;

import java.util.ArrayList;

public class Trie<T> {

    private final TrieNode raiz;

    public Trie() {
        raiz = new TrieNode('\0', null); // Nodo raiz vacio
    }

    public void insertar(String palabra, T data) {
        TrieNode actual = raiz;
        for (char c : palabra.toCharArray()) {
            TrieNode hijo = actual.getChild(c);
            if (hijo == null) {
                hijo = actual.addChild(c);
            }
            actual = hijo;
        }
        actual.esFinPalabra = true;
        actual.data = data;
    }

    public T buscar(String palabra) {
        TrieNode actual = raiz;
        for (char c : palabra.toCharArray()) {
            actual = actual.getChild(c);
            if (actual == null) {
                return null;
            }
        }
        return actual.esFinPalabra ? actual.data : null;
    }

    public void borrar(String clave) {
        borrar(clave);
    }

    private boolean borrar(String clave) {
        TrieNode actual = getRoot();
        for (char c : clave.toCharArray()) {
            actual = actual.getChild(c);
            // if (actual == null) {
            // return null;
            // }
        }
        TrieNode padre = actual.getFather();

    }

    public TrieNode getRoot() {
        return raiz;
    }

    public class TrieNode {
        char valor;
        TrieNode padre;
        ArrayList<TrieNode> hijos;
        boolean esFinPalabra;
        T data;

        public TrieNode(char valor, TrieNode padre) {
            this.valor = valor;
            this.hijos = new ArrayList<TrieNode>();
            this.esFinPalabra = false;
            this.data = null;
            this.padre = padre;
        }

        public TrieNode getChild(char c) {
            for (TrieNode hijo : hijos) {
                if (hijo.valor == c) {
                    return hijo;
                }
            }
            return null;
        }

        public TrieNode addChild(char c) {
            TrieNode hijo = new TrieNode(c, this);
            hijos.add(hijo);
            return hijo;
        }

        public TrieNode getFather() {
            return this.padre;
        }
    }

}
