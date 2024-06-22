package aed;

import java.util.ArrayList;

import aed.SistemaSIU.CargoDocente;

// Inavriante de representacion de Materia:

// - cantidadInscriptos >= 0
// - |plantelDocente| = 4 y para todo i natural,
// si i esta en rango entonces planetlDocente[i] >=0
// - cantidadInscriptos = |conjuntoAlumnos|
// - Cada elemento de conjuntoAlumnos es una 
// clave valida (existente) en la instancia de TrieEstudiante
// - |nombres| = |nombresYNodos|

public class Materia {

    private int cantidadInscriptos;
    private int[] plantelDocente;
    private ArrayList<String> conjuntoAlumnos;
    private ArrayList<ParCarreraMateria> nombres;
    private ArrayList<NodoCarerraYMateria> nombresYNodos;

    public Materia(int cantidadInscriptos, int[] plantelDocente) {
        this.cantidadInscriptos = cantidadInscriptos;
        this.plantelDocente = plantelDocente;
        this.conjuntoAlumnos = new ArrayList<String>();
        this.nombres = new ArrayList<ParCarreraMateria>();
        this.nombresYNodos = new ArrayList<NodoCarerraYMateria>();

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

    public ArrayList<String> getConjuntoAlumnos() {
        return conjuntoAlumnos;
    }

    public void addConjuntoAlumnos(String alumno) {
        this.conjuntoAlumnos.add(alumno);
        setCantidadInscriptos(this.cantidadInscriptos + 1);
    }

    public ArrayList<ParCarreraMateria> getParCarreraMaterias() {
        return nombres;
    }

    public void addParCarreraMateria(ParCarreraMateria pcm) {
        this.nombres.add(pcm);
    }

    public ArrayList<NodoCarerraYMateria> getNombresYNodos() {
        return nombresYNodos;
    }

    public void addNombresYNodos(NodoCarerraYMateria ncym) {
        this.nombresYNodos.add(ncym);
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