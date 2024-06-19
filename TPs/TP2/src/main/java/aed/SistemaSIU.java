package aed;

import java.util.ArrayList;

public class SistemaSIU {

    LU libretas;
    TrieCarrera carreras;

    enum CargoDocente {
        AY2,
        AY1,
        JTP,
        PROF
    }

    public class LU extends Trie<Integer> {
        // Constructor
        public LU() {

        }

        // Método para inscribir y sumar 1 al valor existente de la clave
        public void inscribir(String clave) {
            Integer valorActual = this.buscar(clave);
            if (valorActual != 0) {
                this.insertar(clave, valorActual + 1);
            } else {
                this.insertar(clave, 1);
            }
        }
    }

    public class TrieNodoCarrera {
        char valor;
        ArrayList<TrieNodoCarrera> hijos;
        boolean esFinPalabra;
        Trie<Materia> trieMaterias;

        public TrieNodoCarrera(char valor) {
            this.valor = valor;
            this.trieMaterias = new Trie<>();
            this.hijos = new ArrayList<>();
            this.esFinPalabra = false;
        }

        public TrieNodoCarrera getChild(char c) {
            for (TrieNodoCarrera hijo : hijos) {
                if (hijo.valor == c) {
                    return hijo;
                }
            }
            return null;
        }

        public TrieNodoCarrera addChild(char c) {
            TrieNodoCarrera hijo = new TrieNodoCarrera(c);
            hijos.add(hijo);
            return hijo;
        }

        public Trie<Materia> getTrieMaterias() {
            return trieMaterias;
        }

    }

    private class TrieCarrera {

        private final TrieNodoCarrera raiz;

        public TrieCarrera() {
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
            actual.trieMaterias.insertar(nombreMateria, materia);
        }

        public Materia buscar(String carrera, String nombreMateria) {
            TrieNodoCarrera actual = raiz;
            for (char c : carrera.toCharArray()) {
                actual = actual.getChild(c);
                if (actual == null) {
                    return null;
                }
            }

            return actual.getTrieMaterias().buscar(nombreMateria);
        }

        public String[] getCarrerasEnOrdenLexicografico() {
            ArrayList<String> resultado = new ArrayList<>();
            obtenerCarreras(raiz, "", resultado);
            return resultado.toArray(new String[0]);
        }

        private void obtenerCarreras(TrieNodoCarrera nodo, String prefijo, ArrayList<String> resultado) {
            if (nodo.esFinPalabra) {
                resultado.add(prefijo);
            }
            nodo.hijos.sort((n1, n2) -> Character.compare(n1.valor, n2.valor));
            for (TrieNodoCarrera hijo : nodo.hijos) {
                obtenerCarreras(hijo, prefijo + hijo.valor, resultado);
            }
        }
    }

    /*
     * Complejidad de SistemaSIU:
     */
    public SistemaSIU(InfoMateria[] infoMaterias, String[] libretasUniversitarias) {

        this.carreras = new TrieCarrera();

        for (InfoMateria infoM : infoMaterias) {
            ParCarreraMateria[] retrievedArray = infoM.getParesCarreraMateria();

            int[] plantelDocente = { 0, 0, 0, 0 };
            Materia materia = new Materia(0, plantelDocente);

            for (ParCarreraMateria pcm : retrievedArray) {
                String nombreMateria = pcm.getNombreMateria();
                String nombreCarrera = pcm.getCarrera();
                carreras.insertar(nombreCarrera, nombreMateria, materia);

            }
        }

        this.libretas = new LU();
        for (String libreta : libretasUniversitarias) {
            libretas.insertar(libreta, 0);
        }
    }

    /*
     * Complejidad de inscribir:
     */
    public void inscribir(String estudiante, String carrera, String nombreMateria) {
        libretas.inscribir(estudiante);
        Materia materia = carreras.buscar(carrera, nombreMateria);
        materia.addConjuntoAlumnos(estudiante);

    }

    /*
     * Complejidad de agregarDocente:
     */
    public void agregarDocente(CargoDocente cargo, String carrera, String nombreMateria) {

        Materia materia = carreras.buscar(carrera, nombreMateria);
        materia.incrementarCargo(cargo);
    }

    /*
     * Complejidad de plantelDocente:
     */
    public int[] plantelDocente(String nombreMateria, String carrera) {
        Materia materia = carreras.buscar(carrera, nombreMateria);
        return materia.getPlantelDocente();

    }

    /*
     * Complejidad de cerrarMateria:
     */
    public void cerrarMateria(String nombreMateria, String carrera) {
        // Buscar la materia en el trie
        Materia materia = carreras.buscar(carrera, nombreMateria);

        // Si la materia no existe, salir
        if (materia == null) {
            System.out.println("La materia '" + nombreMateria + "' no existe en la carrera '" + carrera + "'");
            return;
        }

        // Iterar sobre todas las materias en el trie y desligar la referencia a la
        // materia cerrada
        desligarMateria(carreras.raiz, materia);
    }

    // Método recursivo para desligar la referencia a la materia cerrada en todo el
    // trie
    private void desligarMateria(TrieNodoCarrera nodo, Materia materia) {
        // Recorrer los hijos del nodo actual
        for (TrieNodoCarrera hijo : nodo.hijos) {
            if (hijo != null) {
                // Desligar la referencia a la materia si coincide con la que queremos cerrar
                if (hijo.trieMaterias.buscar(materia.nombre) == materia) {
                    hijo.trieMaterias.insertar(materia.nombre, null);
                }
                // Llamar recursivamente para los hijos de este nodo
                desligarMateria(hijo, materia);
            }
        }
    }

    /*
     * Complejidad de inscriptos:
     */
    public int inscriptos(String nombreMateria, String carrera) {
        Materia materia = carreras.buscar(carrera, nombreMateria);
        return materia.getCantidadInscriptos();
    }

    /*
     * Complejidad de excedeCupo:
     */
    public boolean excedeCupo(String nombreMateria, String carrera) {
        Materia materia = carreras.buscar(carrera, nombreMateria);
        int[] plantel = materia.getPlantelDocente();
        int cantInscriptos = materia.getCantidadInscriptos();
        boolean res = false;

        if (plantel[0] * 250 < cantInscriptos
                || plantel[1] * 100 < cantInscriptos
                || plantel[2] * 20 < cantInscriptos
                || plantel[3] * 30 < cantInscriptos) {
            res = true;
        }
        return res;
    }

    /*
     * Complejidad de carreras:
     */
    public String[] carreras() {
        return carreras.getCarrerasEnOrdenLexicografico();
    }

    /*
     * Complejidad de materias:
     */
    public String[] materias(String carrera) {
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    /*
     * Complejidad de materiasInscriptas:
     */
    public int materiasInscriptas(String estudiante) {
        return libretas.buscar(estudiante);
    }
}
