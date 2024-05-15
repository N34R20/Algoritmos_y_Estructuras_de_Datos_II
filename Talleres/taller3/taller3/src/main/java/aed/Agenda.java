package aed;

public class Agenda {

    private Fecha fecha;

    public Agenda(Fecha fechaActual) {
        this.fecha = new Fecha(fechaActual.dia(), fechaActual.mes());
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public void incrementarDia() {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public Fecha fechaActual() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
