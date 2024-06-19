package aed;

import java.util.ArrayList;

import aed.SistemaSIU.CargoDocente;

public class Materia {

    private int cantidadInscriptos;
    private int[] plantelDocente;
    private ArrayList<String> conjuntoAlumnos;
    private ArrayList<String> nombresMateria;

    public Materia(int cantidadInscriptos, int[] plantelDocente) {
        this.cantidadInscriptos = cantidadInscriptos;
        this.plantelDocente = plantelDocente;
        this.conjuntoAlumnos = new ArrayList<String>();
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

    public void incrementarCargo(CargoDocente cargo) {
        // Verificar el tipo de cargo y sumar uno a la posición correspondiente en el
        // array
        switch (cargo) {
            case AY2:
                this.plantelDocente[3]++;
                break;
            case AY1:
                this.plantelDocente[2]++;
                break;
            case JTP:
                this.plantelDocente[1]++;
                break;
            case PROF:
                this.plantelDocente[0]++;
                break;
            default:
                System.out.println("Cargo no válido");
        }
    }
}