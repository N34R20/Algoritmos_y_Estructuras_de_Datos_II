package aed;

import java.util.ArrayList;

// Invariante de Representacion de TrieCarreras:

// - Es un Trie
// - Almacena TrieMaterias como valores

public class DiccionarioCarreras extends Trie<DiccionarioMaterias> {

    public class TrieNodoCarrera {
        char valor;
        ArrayList<TrieNodoCarrera> hijos;
        boolean esFinPalabra;
        DiccionarioMaterias dictMaterias;

        public TrieNodoCarrera(char valor) {
            this.valor = valor;
            this.dictMaterias = new DiccionarioMaterias();
            this.hijos = new ArrayList<TrieNodoCarrera>(256);
            this.esFinPalabra = false;
        }

        public TrieNodoCarrera getChild(char c) {
            TrieNodoCarrera hijo = hijos.get((int) c);
            return hijo;
        }

        public TrieNodoCarrera addChild(char c) {
            TrieNodoCarrera hijo = new TrieNodoCarrera(c);
            hijos.set((int) c, hijo);
            return hijo;
        }

        public DiccionarioMaterias getDictMaterias() {
            return dictMaterias;
        }

    }

    private final TrieNodoCarrera raiz;

    public DiccionarioCarreras() {
        raiz = new TrieNodoCarrera('\0');
    }

    public void insertar(String carrera, String nombreMateria, Materia materia) {
        TrieNodoCarrera actual = raiz;
        for (char c : carrera.toCharArray()) {
            TrieNodoCarrera hijo = actual.getChild(c);
            if (hijo == null) {
                hijo = actual.addChild(c);
            }
            actual = hijo;
        }
        actual.esFinPalabra = true;
        actual.getDictMaterias().insertar(nombreMateria, materia);
    }

    public Materia buscar(String carrera, String nombreMateria) {

        TrieNodoCarrera actual = raiz;
        for (char c : carrera.toCharArray()) {
            actual = actual.getChild(c);
            if (actual == null) {
                return null;
            }
        }

        return actual.getDictMaterias().buscar(nombreMateria);
    }

    public DiccionarioMaterias getTrieMateriaForCarrera(String carrera) {

        TrieNodoCarrera actual = raiz;
        for (char c : carrera.toCharArray()) {
            actual = actual.getChild(c);
            if (actual == null) {
                return null;
            }
        }

        DiccionarioMaterias dictMaterias = actual.getDictMaterias();
        return dictMaterias;
    }

    // metodo para obtener una lista de Strings con todas las carerras del sistema
    public String[] getCarrerasEnOrdenLexicografico() {
        // creamos un ArrayList vacio que guardara el resultado final
        ListaEnlazada<String> conjCarreras = new ListaEnlazada<>();

        // usamos la funcion recursiva obtenerCarrera sobre la raiz, un String vacio ""
        // y la lista vacia resultado que va a terminar cuando no haya mas caminos por
        // recorrer
        obtenerCarreras(raiz, "", conjCarreras);

        // por ultimo convertimos resultado en un Array de Strings y lo devolvemos
        String[] resultado = new String[conjCarreras.longitud()];
        Iterador<String> it = conjCarreras.iterador();

        for (int i = 0; it.haySiguiente() == true; i++) {
            // Código a ejecutar en cada iteración
            String siguiente = it.siguiente();
            resultado[i] = siguiente;

        }

        return resultado;
    }

    // funcion recursiva para obtener una lista con los nombres de las carerras que
    // com caso base para agregar una palabra a la lista considera que
    // nodo.esFinPalabra sea true y de no serlo va yendo a traves de los hijos en
    // ordenloxigrafico hasta agotar todos los caminos posibles
    private void obtenerCarreras(TrieNodoCarrera nodo, String prefijo, ListaEnlazada<String> resultado) {
        if (nodo.esFinPalabra) {
            resultado.agregarAtras(prefijo);
        }

        for (TrieNodoCarrera hijo : nodo.hijos) {
            obtenerCarreras(hijo, prefijo + hijo.valor, resultado);
        }
    }

    public String[] getMateriasEnOrdenLexicografico(String carrera) {
        // creamos un ArrayList vacio que guardara el resultado final
        ListaEnlazada<String> conjMaterias = new ListaEnlazada<>();

        Trie<Materia> TrieMateria = getTrieMateriaForCarrera(carrera);
        Trie<Materia>.TrieNode raizMaterias = TrieMateria.getRoot();

        obtenerMaterias(raizMaterias, "", conjMaterias);

        String[] resultado = new String[conjMaterias.longitud()];
        Iterador<String> it = conjMaterias.iterador();

        for (int i = 0; it.haySiguiente() == true; i++) {
            // Código a ejecutar en cada iteración
            String siguiente = it.siguiente();
            resultado[i] = siguiente;

        }

        return resultado;
    }

    private void obtenerMaterias(Trie<Materia>.TrieNode nodo, String prefijo, ListaEnlazada<String> resultado) {
        if (nodo.esFinPalabra) {
            resultado.agregarAtras(prefijo);
        }

        for (Trie<Materia>.TrieNode hijo : nodo.hijos) {
            obtenerMaterias(hijo, prefijo + hijo.valor, resultado);
        }
    }

}