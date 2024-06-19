package aed;

import java.util.ArrayList;

public class Trie<T> {

    private final TrieNode<T> raiz;

    public Trie() {
        raiz = new TrieNode<>('\0'); // Nodo raiz vacio
    }

    public void insertar(String palabra, T data) {
        TrieNode<T> actual = raiz;
        for (char c : palabra.toCharArray()) {
            TrieNode<T> hijo = actual.getChild(c);
            if (hijo == null) {
                hijo = actual.addChild(c);
            }
            actual = hijo;
        }
        actual.esFinPalabra = true;
        actual.data = data;
    }

    public T buscar(String palabra) {
        TrieNode<T> actual = raiz;
        for (char c : palabra.toCharArray()) {
            actual = actual.getChild(c);
            if (actual == null) {
                return null;
            }
        }
        return actual.esFinPalabra ? actual.data : null;
    }

    public boolean empiezaCon(String prefijo) {
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public TrieNode<T> getRoot() {
        return raiz;
    }

    public class TrieNode<T> {
        char valor;
        ArrayList<TrieNode<T>> hijos;
        boolean esFinPalabra;
        T data;

        public TrieNode(char valor) {
            this.valor = valor;
            this.hijos = new ArrayList<>();
            this.esFinPalabra = false;
            this.data = null;
        }

        public TrieNode<T> getChild(char c) {
            for (TrieNode<T> hijo : hijos) {
                if (hijo.valor == c) {
                    return hijo;
                }
            }
            return null;
        }

        public TrieNode<T> addChild(char c) {
            TrieNode<T> hijo = new TrieNode<>(c);
            hijos.add(hijo);
            return hijo;
        }
    }

}
