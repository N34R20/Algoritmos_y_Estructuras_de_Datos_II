package aed;

import java.util.ArrayList;

public class Trie<T> {

    private final TrieNode raiz;

    public Trie() {
        // Nodo raiz vacio, es el unico que no tiene padre
        raiz = new TrieNode('\0', null);
    }

    // empezas desde la raiz
    // y agregas caracter por caracter hasta ir al ultimo nodo
    // donde asocias los datos T y declaras que termina la palabra
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

    // Desde la raiz vas caracter por caracter de la palabra y
    public T buscar(String palabra) {
        TrieNode actual = raiz;
        for (char c : palabra.toCharArray()) {
            actual = actual.getChild(c);
            if (actual == null) {
                return null;
            }
        }
        // estructura condicional para retornar actual.data
        // si actual.esFinPalabra = true
        // y sino retorna null
        return actual.esFinPalabra ? actual.data : null;
    }

    // en el peor caso de borrar llegas al final de la clave
    // y tenes que dar la misma cantidad de saltos para atras
    // porque es un diccionario de una unica clave

    public void borrar(String clave) {

        // Recorrer el TrieMaterias hasta llegar al final de la clave
        TrieNode actual = getRoot();
        for (char c : clave.toCharArray()) {
            actual = actual.getChild(c);
        }

        // chequeas el caso base: donde podes haber llegado a un nodo que es el final de
        // una palabra
        // pero ademas tiene hijos porque siguiendo los hijos es la clave de otro valor
        if (!actual.hijos.isEmpty()) {
            actual.data = null;
            actual.esFinPalabra = false;
        } else {
            // parado en el ultimo nodo volves al padre y
            // el input clave lo transformas en una lista de caracteres
            // luego setas un contador = 1
            TrieNode padre = actual.getFather();
            char[] caracteres = clave.toCharArray();
            int i = 1;

            // creas un loop que se mantiene
            // mientras el padre tiene un unico hijo osea
            // (mientras no haya una bifurcacion, cuando se distinguen las claves,
            // no es un nodo compartido con otra palabra)
            // y mientras el padre no tenga asociada una materia
            while (padre.hijos.size() == 1 && padre.data == null) {

                // el padre mata a un hijo especifico a lo Cronos
                padre.killChild(caracteres[clave.length() - i]);
                i++;
            }
            // fuera del loop estarias parado en la ultimo nodo que hay que eliminar
            // y vamos al padre por ultima vez para eliminarlo ya fuera del ciclo.
            padre.killChild(caracteres[clave.length() - i]);
        }

    }

    // devuelve la raiz del Trie
    public TrieNode getRoot() {
        return raiz;
    }

    public class TrieNode {
        char valor;
        TrieNode padre;
        ArrayList<TrieNode> hijos;
        boolean esFinPalabra;
        T data;

        // constructor:
        // ------------
        //
        // el valor de cada nodo, va a ser un caracter especifico
        // un atributo booleano que es true si es el ultimo nodo de una clave completa
        // la data que en principio esta vacio pero en caso de ser el final de la
        // palabra
        // se le agrega el dato que que sera el valor de la clave
        // y conserva un puntero hacia su nodo padre.
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

        public void killChild(char valorHijo) {
            for (int i = 0; i < hijos.size(); i++) {
                if (hijos.get(i).valor == valorHijo) {
                    hijos.remove(i);
                    return;
                }
            }
        }
    }

}
