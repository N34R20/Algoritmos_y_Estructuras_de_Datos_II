package aed;

import java.util.ArrayList;

import aed.SistemaSIU.CargoDocente;

// Invariante de representacion de Materia:

// - cantidadInscriptos >= 0
// - |plantelDocente| = 4 y para todo i natural,
// si i esta en rango entonces planetlDocente[i] >=0
// - cantidadInscriptos = |conjuntoAlumnos|
// - Cada elemento de conjuntoAlumnos es una 
// clave valida (existente) en la instancia de DiccionarioEstudiante 
// Los punteros que aparecen en conjPunterosYClavesMateria apuntan a un Diccionario que es un valor de una instancia valida DiccionarioCarrera
// - |conjPunterosYClavesMateria| <= cantidad de claves en DiccionarioCarreras

public class Materia {

    private int cantidadInscriptos;
    private int[] plantelDocente;
    private ListaEnlazada<String> conjuntoAlumnos;
    private ArrayList<ReferenciaADiccionarioYClave> conjPunterosYClavesMateria;

    public Materia(int cantidadInscriptos, int[] plantelDocente) {
        this.cantidadInscriptos = cantidadInscriptos;
        this.plantelDocente = plantelDocente;
        this.conjuntoAlumnos = new ListaEnlazada<String>();
        // Cambiar por trie
        this.conjPunterosYClavesMateria = new ArrayList<ReferenciaADiccionarioYClave>();

    }

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(int cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public int[] getPlantelDocente() {
        return plantelDocente;
    }

    public void setPlantelDocente(int[] plantelDocente) {
        this.plantelDocente = plantelDocente;
    }

    public ListaEnlazada<String> getConjuntoAlumnos() {
        return conjuntoAlumnos;
    }

    public void addConjuntoAlumnos(String alumno) {
        this.conjuntoAlumnos.agregarAtras(alumno);
        setCantidadInscriptos(this.cantidadInscriptos + 1);
    }

    public ArrayList<ReferenciaADiccionarioYClave> getNombresYNodos() {
        return conjPunterosYClavesMateria;
    }

    public void addNombresYNodos(ReferenciaADiccionarioYClave ncym) {
        this.conjPunterosYClavesMateria.add(ncym);
    }

    public void incrementarCargo(CargoDocente cargo) {
        // Verificar el tipo de cargo y sumar uno a la posición correspondiente en el
        // array
        switch (cargo) {
            case PROF:
                this.plantelDocente[0]++;
                break;
            case JTP:
                this.plantelDocente[1]++;
                break;
            case AY1:
                this.plantelDocente[2]++;
                break;
            case AY2:
                this.plantelDocente[3]++;
                break;

            default:
                System.out.println("Cargo no válido");
        }
    }
}