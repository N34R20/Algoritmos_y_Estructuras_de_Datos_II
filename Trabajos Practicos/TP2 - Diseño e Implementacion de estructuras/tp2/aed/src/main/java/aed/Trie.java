package aed;

import java.util.ArrayList;
import java.util.Collections;

// Clase Trie<T> generica donde puede almacenar cualquier valor, posteriormente las clases que hacen al sistema son extensiones de este Trie<T>

// Invariante de Representacion:

// - Existe un nodo del Trie que es raiz y este no tiene padre ni almacena nigun valor
// - Cada nodo tiene un hijo, este es un nodo tambien
// - Si un nodo tiene valor true respecto a esFinPalabra
// existe una secuencia unica de nodos que representan 
// el valor del nodo actual
// - Cada nodo tiene o valor(caracter) o significado(dato), pero no niguno
// puede tener ambos.   

public class Trie<T> {

    public class TrieNode {
        char valor;
        TrieNode padre;
        ArrayList<TrieNode> hijos;
        boolean esFinPalabra;
        T data;
        int cantidadHijos;

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
            // valor ya no tiene mucho sentido
            this.valor = valor;
            this.hijos = new ArrayList<TrieNode>(Collections.nCopies(256, (TrieNode) null));
            this.esFinPalabra = false;
            this.data = null;
            this.padre = padre;
            this.cantidadHijos = 0;

        }

        // recorre la lista de hijos de un determinado nodo que esta acotada por la
        // cantidad caracteres ASCI hasta encontrar el que le pedimos
        // en el peor caso no lo encuentra y devuelve null
        public TrieNode getChild(char c) {
            TrieNode hijo = hijos.get((int) c);
            return hijo;
        }

        public TrieNode addChild(char c) {
            // Verificar si ya existe un hijo con el valor 'c'
            if (hijos.get((int) c) != null) {
                // Si ya existe, retornar ese nodo en lugar de crear uno nuevo
                return hijos.get((int) c);
            }

            TrieNode nuevoHijo = new TrieNode(c, this);
            hijos.set((int) c, nuevoHijo);
            this.cantidadHijos += 1;
            return nuevoHijo;
        }

        public TrieNode getFather() {
            return this.padre;
        }

        public void killChild(char valorHijo) {
            if ((hijos.get((int) valorHijo) != null)) {
                hijos.set((int) valorHijo, null);
                this.cantidadHijos--;
            }
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            this.data = newData;
        }
    }

    private final TrieNode raiz;

    public Trie() {
        // Nodo raiz vacio, es el unico que no tiene padre
        raiz = new TrieNode('\0', null);
    }

    // empezas desde la raiz
    // y agregas caracter por caracter hasta ir al ultimo nodo
    // donde asocias los datos T y declaras que termina la palabra con esFinPalabra
    // = true
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
        // actual.data = data;
        actual.setData(data);
    }

    // Desde la raiz vas caracter por caracter del input palabra
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

        if (actual.cantidadHijos == 1) {
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
            while (padre.cantidadHijos == 1 && padre.data == null) {

                // el padre mata a un hijo especifico a lo Cronos
                padre.killChild(caracteres[clave.length() - i]);
                i++;
            }
            // fuera del loop estarias parado en la ultimo nodo que hay que eliminar
            // y vamos al padre por ultima vez para eliminarlo ya fuera del ciclo.
            padre.killChild(caracteres[clave.length() - i]);
        }

    }

    public String[] getClavesEnOrdenLexicografico() {
        // creamos un ArrayList vacio que guardara el resultado final
        ListaEnlazada<String> conjClaves = new ListaEnlazada<>();

        obtenerClaves(raiz, "", conjClaves);

        String[] resultado = new String[conjClaves.longitud()];
        Iterador<String> it = conjClaves.iterador();

        for (int i = 0; it.haySiguiente() == true; i++) {
            // Código a ejecutar en cada iteración
            String siguiente = it.siguiente();
            resultado[i] = siguiente;

        }

        return resultado;
    }

    private void obtenerClaves(Trie<T>.TrieNode nodo, String prefijo, ListaEnlazada<String> resultado) {
        if (nodo.esFinPalabra) {
            resultado.agregarAtras(prefijo);
        }

        for (Trie<T>.TrieNode hijo : nodo.hijos) {
            if (hijo != null) {
                obtenerClaves(hijo, prefijo + hijo.valor, resultado);
            }
        }
    }

    // devuelve la raiz del Trie
    public TrieNode getRoot() {
        return raiz;
    }

}
