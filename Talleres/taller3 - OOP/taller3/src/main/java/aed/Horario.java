package aed;

public class Horario {

    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return hora + ":" + minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro instanceof Horario) {
            // Convertir el objeto a tipo Fecha
            Horario otroHorario = (Horario) otro;
            // Comparar día y mes
            return this.hora == otroHorario.hora && this.minutos == otroHorario.minutos;
        }
        // Si el objeto no es de tipo Fecha, no puede ser igual
        return false;
    }

}
