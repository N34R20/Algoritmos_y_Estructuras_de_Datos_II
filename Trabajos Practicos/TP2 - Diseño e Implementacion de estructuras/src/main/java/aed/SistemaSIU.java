package aed;

import java.util.ArrayList;

public class SistemaSIU {

    LU estudiantes;
    TrieCarrera sistema;

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

        // Método para desinscribir y restar 1 al valor existente de la clave
        public void desinscribir(String clave) {
            Integer valorActual = this.buscar(clave);
            if (valorActual != 0) {
                this.insertar(clave, valorActual - 1);
            } else {
                this.insertar(clave, 0);
            }
        }
    }

    public class TrieMaterias extends Trie<Materia> {
        // Constructor
        public TrieMaterias() {

        }

    }

    private class TrieCarrera extends Trie<TrieMaterias> {

        public class TrieNodoCarrera {
            char valor;
            ArrayList<TrieNodoCarrera> hijos;
            boolean esFinPalabra;
            TrieMaterias trieMaterias;

            public TrieNodoCarrera(char valor) {
                this.valor = valor;
                this.trieMaterias = new TrieMaterias();
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

            public TrieMaterias getTrieMaterias() {
                return trieMaterias;
            }

        }

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
            actual.getTrieMaterias().insertar(nombreMateria, materia);
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

        public TrieMaterias getTrieMateriaForCarrera(String carrera) {

            TrieNodoCarrera actual = raiz;
            for (char c : carrera.toCharArray()) {
                actual = actual.getChild(c);
                if (actual == null) {
                    return null;
                }
            }

            TrieMaterias trieMaterias = actual.getTrieMaterias();
            return trieMaterias;
        }

        public String[] getCarrerasEnOrdenLexicografico() {
            // creamos un ArrayList vacio que guardara el resultado final
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

        public String[] getMateriasEnOrdenLexicografico(String carrera) {
            // creamos un ArrayList vacio que guardara el resultado final
            ArrayList<String> resultado = new ArrayList<>();

            Trie<Materia> TrieMateria = getTrieMateriaForCarrera(carrera);
            Trie<Materia>.TrieNode raizMaterias = TrieMateria.getRoot();

            obtenerMaterias(raizMaterias, "", resultado);
            return resultado.toArray(new String[0]);
        }

        private void obtenerMaterias(Trie<Materia>.TrieNode nodo, String prefijo, ArrayList<String> resultado) {
            if (nodo.esFinPalabra) {
                resultado.add(prefijo);
            }
            nodo.hijos.sort((n1, n2) -> Character.compare(n1.valor, n2.valor));
            for (Trie<Materia>.TrieNode hijo : nodo.hijos) {
                obtenerMaterias(hijo, prefijo + hijo.valor, resultado);
            }
        }

    }

    /*
     * Complejidad de SistemaSIU:
     * $O(\sum_{c\in C}|c| * |M_c| + \sum_{m\in M} \sum_{n\in N_m} |n| + E)$
     * 
     */
    public SistemaSIU(InfoMateria[] infoMaterias, String[] libretasUniversitarias) {

        this.sistema = new TrieCarrera();

        for (InfoMateria infoM : infoMaterias) {
            ParCarreraMateria[] paresCarreraMateria = infoM.getParesCarreraMateria();

            int[] plantelDocente = { 0, 0, 0, 0 };
            Materia materia = new Materia(0, plantelDocente);

            for (ParCarreraMateria pcm : paresCarreraMateria) {
                String nombreMateria = pcm.getNombreMateria();
                String carrera = pcm.getCarrera();
                sistema.insertar(carrera, nombreMateria, materia);

                TrieMaterias TrieMateria = sistema.getTrieMateriaForCarrera(carrera);

                NodoCarerraYMateria nycm = new NodoCarerraYMateria(TrieMateria, nombreMateria);
                materia.addNombresYNodos(nycm);

            }
        }

        this.estudiantes = new LU();
        for (String libreta : libretasUniversitarias) {
            estudiantes.insertar(libreta, 0);
        }
    }

    /*
     * Complejidad de inscribir:
     */
    public void inscribir(String estudiante, String carrera, String nombreMateria) {
        estudiantes.inscribir(estudiante);
        Materia materia = sistema.buscar(carrera, nombreMateria);
        materia.addConjuntoAlumnos(estudiante);

    }

    /*
     * Complejidad de agregarDocente:
     */
    public void agregarDocente(CargoDocente cargo, String carrera, String nombreMateria) {

        Materia materia = sistema.buscar(carrera, nombreMateria);
        materia.incrementarCargo(cargo);
    }

    /*
     * Complejidad de plantelDocente:
     */
    public int[] plantelDocente(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera, nombreMateria);
        return materia.getPlantelDocente();

    }

    /*
     * Complejidad de cerrarMateria:
     */
    public void cerrarMateria(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera, nombreMateria);
        ArrayList<String> conjuntoDeAlumnos = materia.getConjuntoAlumnos();

        ArrayList<NodoCarerraYMateria> nombresYNodosMateria = materia.getNombresYNodos();

        //
        for (String alumno : conjuntoDeAlumnos) {
            estudiantes.desinscribir(alumno);
        }

        for (NodoCarerraYMateria nycm : nombresYNodosMateria) {
            nycm.raizCarrera().borrar(nycm.getNombreMateria());
        }
    }

    /*
     * Complejidad de inscriptos:
     */
    public int inscriptos(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera, nombreMateria);
        return materia.getCantidadInscriptos();
    }

    /*
     * Complejidad de excedeCupo:
     */
    public boolean excedeCupo(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera, nombreMateria);
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
        return sistema.getCarrerasEnOrdenLexicografico();
    }

    /*
     * Complejidad de materias:
     */
    public String[] materias(String carrera) {
        return sistema.getMateriasEnOrdenLexicografico(carrera);
    }

    /*
     * Complejidad de materiasInscriptas:
     */
    public int materiasInscriptas(String estudiante) {
        return estudiantes.buscar(estudiante);
    }
}
