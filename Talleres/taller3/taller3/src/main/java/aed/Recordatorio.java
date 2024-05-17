package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha.dia(), fecha.mes());
        this.horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return new Horario(horario.hora(), horario.minutos());
    }

    public Fecha fecha() {
        return new Fecha(fecha.dia(), fecha.mes());
    }

    public String mensaje() {
        return new String(mensaje);
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha + " " + horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro instanceof Recordatorio) {
            // Convertir el objeto a tipo Fecha
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            // Comparar día y mes
            return this.mensaje == otroRecordatorio.mensaje
                    && otroRecordatorio.fecha.equals(this.fecha)
                    && otroRecordatorio.horario.equals(this.horario);
        }
        // Si el objeto no es de tipo Fecha, no puede ser igual
        return false;
    }

}
