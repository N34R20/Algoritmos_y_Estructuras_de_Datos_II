package aed;

import java.util.ArrayList;

// Invariante de SistemaSIU

public class SistemaSIU {

    DiccionarioEstudiante estudiantes;
    DiccionarioCarreras sistema;

    enum CargoDocente {
        AY2,
        AY1,
        JTP,
        PROF
    }
    // ======================
    // METODOS DE SISTEMA SIU
    // ======================

    /*
     * Complejidad de SistemaSIU:
     * O(\sum_{c\in C}|c| * |M_c| + \sum_{m\in M} \sum_{n\in N_m} |n| + E)
     * 
     * sum |c| * |M_c| indica que lo que nos cuesta ingresar a una carrera es |c|
     * (el largo de la carrera) y
     * vamos a hacerlo la cantidad de materias |M_c| que tiene una carerra.
     * 
     * Y por cada vez que entramos a una carerra vamos a recorrer el largo del
     * nombre de una materia la cantidad de veces que una misma materia tenga
     * nombres distintos
     * sum_{m\in M} \sum_{n\in N_m} |n|
     * 
     * El metodo SistemaSIU (constructor) inicializa un trie vacio y en orden de los
     * pares ParCarreraMateria que componen a la lista en tuplas InfoMateria de la
     * array InfoMaterias
     * va iterando sobre ellos creando una key en el trie sistema con .getCarrera()
     * y adentro
     * otro trieMaterias donde crea una key con getNombreMateria() para cada par en
     * la lista InfoMaterias
     * y para todo ParCarreraMaetria asocia el valor del trieMateria con un misma
     * instancia de la clase Materia con sus atributos incializados de manera
     * espcifica para que no contengan todavia niguna informacion
     * e instancio un NodoCarerraYMateria que guardara un puntero al trie de
     * TrieMateria para cada carrera especifica con el nombreMateria
     * 
     * Y por ultimo inicializo el TrieEstudiante estudiantes con las claves de la
     * lista libretasUniversitarias y inicializo sus valores a 0 dado que no estan
     * inscriptos todavia en niguna materia al crear el sistema
     * toma O(1) justificando el + E
     */
    public SistemaSIU(InfoMateria[] infoMaterias, String[] libretasUniversitarias) {

        this.sistema = new DiccionarioCarreras();

        for (InfoMateria infoM : infoMaterias) {
            ParCarreraMateria[] paresCarreraMateria = infoM.getParesCarreraMateria();

            int[] plantelDocente = { 0, 0, 0, 0 };
            Materia materia = new Materia(0, plantelDocente);

            for (ParCarreraMateria pcm : paresCarreraMateria) {

                String nombreMateria = pcm.getNombreMateria();
                String carrera = pcm.getCarrera();

                sistema.insertar(carrera, nombreMateria, materia);
                DiccionarioMaterias TrieMateria = sistema.buscar(carrera);
                NodoCarreraYMateria nycm = new NodoCarreraYMateria(TrieMateria, nombreMateria);
                materia.addNombresYNodos(nycm);

            }
        }

        this.estudiantes = new DiccionarioEstudiante();
        for (String libreta : libretasUniversitarias) {
            estudiantes.insertar(libreta, 0);
        }
    }

    /*
     * Complejidad de inscribir:
     * O(|c| + |m|)
     * 
     * Para inscribir tomamos el String estudiante que es la clave para acceder al
     * TrieEstudiante, que se recorre en O(1), y sumamos 1
     * aumentando el total de materias incscriptas
     * y luego con carrera y materia recorremos el trieCarrera con la clave carrera
     * en O(|c|) y
     * para llegar a el trieMateria al que recorremos con la clave materia en O(|m|)
     * para agregar al conjuntoAlumno de materia la libreta del estudiante
     */
    public void inscribir(String estudiante, String carrera, String nombreMateria) {
        estudiantes.inscribir(estudiante);
        Materia materia = sistema.buscar(carrera).buscar(nombreMateria);
        materia.addConjuntoAlumnos(estudiante);

    }

    /*
     * Complejidad de inscriptos:
     * O(|c| + |m|)
     * cantidadInscriptos es un atributo que es parte de Materia entonces acceder a
     * el es O(1) una vez llegado a la Materia
     * que cuesta el largo de carerra y el largo de materia
     */
    public int inscriptos(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera).buscar(nombreMateria);
        return materia.getCantidadInscriptos();
    }

    /*
     * Complejidad de agregarDocente:
     * O(|c| + |m|)
     * PlantelDocente es un array que es atributo de Materia entonces acceder a una
     * posicion especifica y sumar 1 es O(1) una vez
     * llegado a la Materia que cuesta el largo de carerra y el largo de materia
     */
    public void agregarDocente(CargoDocente cargo, String carrera, String nombreMateria) {

        Materia materia = sistema.buscar(carrera).buscar(nombreMateria);
        materia.incrementarCargo(cargo);
    }

    /*
     * Complejidad de plantelDocente:
     * O(|c| + |m|)
     * Muy parecido a la complejidad del metodo anterior pero no hace falta cambiar
     * nada dentro del array solo devulverlo
     * lo cual la clase maetria tiene un metodo especifico getPlantelDocente() que
     * accede en O(1)
     */
    public int[] plantelDocente(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera).buscar(nombreMateria);
        return materia.getPlantelDocente();

    }

    /*
     * Complejidad de excedeCupo:
     * O(|c| + |m|)
     * Tambien el largo de carrera y materia es lo que cuesta recorrer los tries y
     * una vez accedido a plantel docente con el metodo getPlantelDocente() y
     * getCantidadInscriptos() (ambos O(1)) evaluo una condicion que compara cada
     * valor de los indices de plantelDocente con cantInscriptos y todo
     * plantelDocente es un array acotado (todo tienen largo = 4)
     * termina siendo O(1) porque no tiene en cuenta el tamaño de la entrada.
     * 
     */
    public boolean excedeCupo(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera).buscar(nombreMateria);
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
     * O(sum |c|)
     * 
     * Para devolver un vector de Strings que contenga a todas las Carreras
     * ordenadas lexograficamente creamos un ArrayList vacio
     * para almacenar todas las carreras y vamos desde la raiz
     * yendo por los hijos ordenada y recursivamente formando la palabra que luego
     * añadimos al Array vacio y hacemos eso hasta que no haya mas caminos por
     * recorrer lo que nos toma en el peor caso la sumatoria del largo de las
     * carreras O(sum |c|)
     * 
     */
    public String[] carreras() {
        return sistema.getClavesEnOrdenLexicografico();
    }

    /*
     * Complejidad de materias:
     * O(|c| + sum |m_c|)
     * 
     * Para devolver un vector de Strings que contenga a todas las Materias
     * ordenadas lexograficamente de una carrera primero creamos un ArrayList vacio
     * para almacenar todas las materias, luego entramos al TrieCarrera sistema con
     * la clave carrera (O(|c|)) y una vez parados en el trieMateria vamos desde la
     * raiz
     * yendo por los hijos ordenada y recursivamente formando la palabra que luego
     * añadimos al Array vacio y hacemos eso hasta que no haya mas caminos por
     * recorrer lo que nos toma en el peor caso la sumatoria del largo de las
     * materias en dicha carrera O(sum |m_c|)
     * 
     * 
     */
    public String[] materias(String carrera) {
        DiccionarioMaterias materias = sistema.buscar(carrera);
        return materias.getClavesEnOrdenLexicografico();
    }

    /*
     * Complejidad de materiasInscriptas:
     * O(1)
     * 
     * para obtener la cantidad de materias que esta inscripto estudiante basta con
     * recorrer el TrieEstudiante con la clave estudiante, y sabemos que el largo de
     * estudiante esta acotado, osea nunca va a ser mayor que 7 caracteres por lo
     * tanto la complejidad es de O(1)
     */
    public int materiasInscriptas(String estudiante) {
        return estudiantes.buscar(estudiante);
    }

    /*
     * Complejidad de cerrarMateria:
     * O(|c| + |m| + sum |n| + E_m)
     * 
     * Para cerrar una materia, hay que cerrar la misma materia en todas las
     * carreras donde tiene distinto nombre, el metodo primero llega a Materia
     * usando carrera y nomrbemateria como claves eso explica que la complejidad
     * dependa de |c| + |m|
     * 
     * Luego una vez en Materia iteramos sobre el atributo conjuntoAlumnos de
     * Materia y accedemos con cada elemento en el trieEstudiante restandole uno al
     * valor de cada uno
     * y todas estas opraciones ocurren en 0(1) por lo que detallamos anteriormente,
     * en definitiva desinscribir a todos los alumnos de una materia especifica
     * cuesta la cantidad de alumnos inscriptos a dicha materia (osea E_m)
     * 
     * ahora todavia en Materia iteramos sobre el ArrayList nombresYNodos que
     * contiene a todos los distintos nombres de la materia y punteros al
     * trieMateria donde esa materia es clave, entonces volvemos a recorrer ya en el
     * Trie especifico con la clave de cada nombreMateria y hacemos que el ultimo
     * nodo que representa el fin de la palabra no apunte mas a Materia sino que
     * apunte a null y cambio el valor del nodo esFinPalabra por false indicando que
     * el camino que temrina con ese nodo ya no representa a una clave
     * Y luego si el nodo no tiene hijos y tampoco es el final de una palabra (osea
     * es una clave distinta) voy yendo de hijo a padre y eliminado al nodo actual
     * parandome en su padre hasta que tenga mas de un hijo o en el peor caso que
     * me pare en la raiz por eso esta complejidad toma a lo sumo el doble del largo
     * del nombre de la materia (osea en el peor caso que recorra toda la clave y
     * elimine la clave en su totalidad de atras para adelante) O(2n) = O(n)
     * 
     * 
     */
    public void cerrarMateria(String nombreMateria, String carrera) {
        Materia materia = sistema.buscar(carrera).buscar(nombreMateria);
        ListaEnlazada<String> conjuntoDeAlumnos = materia.getConjuntoAlumnos();

        ArrayList<NodoCarreraYMateria> nombresYNodosMateria = materia.getNombresYNodos();

        //
        Iterador<String> it = conjuntoDeAlumnos.iterador();

        while (it.haySiguiente() == true) {
            // Código a ejecutar en cada iteración
            String alumno = it.siguiente();
            estudiantes.desinscribir(alumno);

        }

        for (NodoCarreraYMateria nycm : nombresYNodosMateria) {
            nycm.raizCarrera().borrar(nycm.getNombreMateria());
        }
    }

}
