package aed;

import java.util.ArrayList;
import java.util.Collections;

// Clase Trie<T> generica donde puede almacenar cualquier valor, posteriormente las clases que hacen al sistema son extensiones de este Trie<T>

// Invariante de Representacion:
// -----------------------------

// - Existe un nodo del Trie que es raiz y este no tiene padre ni almacena nigun valor
// - Cada nodo tiene un padre, este es un nodo tambien salvo la raiz
// - Si un nodo tiene valor true respecto a esFinPalabra existe una secuencia unica de nodos que representan el valor del nodo actual
// - Cada nodo tiene o esFinPalabra == true o tiene hijos. ( no es excluyente )  
// cantidadHijos >= 0 y es igual a la cantidad de posiciones no nulas del array hijos.

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
                this.cantidadHijos -= 1;
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

        if (actual.cantidadHijos > 0) {
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
            while (padre.cantidadHijos == 1 && padre.data == null && padre.getFather() != null) {

                // el padre mata a un hijo especifico a lo Cronos
                padre.killChild(caracteres[clave.length() - i]);
                padre.esFinPalabra = false;
                i++;
                padre = padre.getFather();
            }
            // fuera del loop estarias parado en la ultimo nodo que hay que eliminar
            // y vamos al padre por ultima vez para eliminarlo ya fuera del ciclo.
            padre.killChild(caracteres[clave.length() - i]);
            padre.esFinPalabra = false;

        }

    }

    public String[] getClavesEnOrdenLexicografico() {

        StringBuilder palabra = new StringBuilder(); // O(1)
        // usamos una ListaEnlazada para que sirva como Stack para cumplir los ordenes
        // pero no es propiamente un stack.
        // nos aprovechamos de que se puede agregar adelante y sacar el primer elemento
        // pero un Stack no podria agregarAtras no sacar un elemento i del conjunto.
        ListaEnlazada<String> stack = new ListaEnlazada<String>(); // O(1)
        ListaEnlazada<String> conjClaves = new ListaEnlazada<>(); // O(1)

        // la funcion recursiva recibe 4 inputs:
        // la raiz del Trie al que queremos recorrer.
        // un StringBuilder con el que formaremos las palabras, en principio vacio.
        // Una ListaEnlazada que funciona como stack para ir apilando los prefijos de
        // las palabras que comparten prefijo.
        // El conjunto Final de las claves del Diccionario que sera el output de la
        // funcion.

        obtenerClaves(raiz, palabra, stack, conjClaves);

        String[] resultado = new String[conjClaves.longitud()]; // O(1)
        Iterador<String> it = conjClaves.iterador(); // O(1)

        for (int i = 0; it.haySiguiente() == true; i++) { // O(|conjClaves|)

            String siguiente = it.siguiente(); // O(1)
            resultado[i] = siguiente; // O(1)

        }

        return resultado;
    }

    private void obtenerClaves(Trie<T>.TrieNode nodo, StringBuilder prefijo, ListaEnlazada<String> pila,
            ListaEnlazada<String> resultado) {

        // Si el nodo en el que estamos parados tiene >1 hijos significa que muchas
        // claves comparten el prefijo formado por el camino hasta ese nodo
        // como cantidad de hijos tenga, apilamos el prefijo en la pila
        if (nodo.cantidadHijos > 1) {
            for (int i = 1; i < nodo.cantidadHijos; i++) { // O(256) == O(1)
                pila.agregarAdelante(prefijo.toString()); // O(1)
            }
        }

        // Si el nodo es fin de palabra hay que agregrarla al resultado final
        if (nodo.esFinPalabra) {
            resultado.agregarAtras(prefijo.toString()); // O(1)

            // Si ademas no tiene hijos es que es el final de un camino, borramos el prefijo
            // que estabamos generando
            if (nodo.cantidadHijos == 0) {
                prefijo.setLength(0); // O(1)
            }
        }

        // recorremos al Trie de forma recursiva y entramos en los hijos si estos no son
        // nulos
        for (Trie<T>.TrieNode hijo : nodo.hijos) { // O(256) == O(1)
            if (hijo != null) {

                // si estamos en un nodo que tiene > 1 hijos y la pila no esta vacia y el
                // prefijo fue previamente eliminado
                // siginifica que tenemos que usar lo que hayamos apilado la ultima vez
                if (nodo.cantidadHijos > 1 && pila.longitud() != 0 && prefijo.isEmpty()) {
                    prefijo.append(pila.pop()); // O(1)
                }

                prefijo.append(hijo.valor); // O(1)

                obtenerClaves(hijo, prefijo, pila, resultado); // O(c)
            }
        }

    }

    // devuelve la raiz del Trie
    public TrieNode getRoot() {
        return raiz;
    }

}
