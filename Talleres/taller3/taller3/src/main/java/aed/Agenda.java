package aed;

public class Agenda {

    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios arreglo;

    public Agenda(Fecha fechaActual) {
        this.fecha = new Fecha(fechaActual.dia(), fechaActual.mes());
        this.arreglo = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        arreglo.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(fecha.toString() + "\n");
        result.append("=====\n");
        for (int i = 0; i < arreglo.longitud(); i++) {
            if (arreglo.obtener(i).fecha().equals(fecha)) {
                result.append(arreglo.obtener(i).toString()).append("\n");

            }
        }

        return result.toString();
    }

    public void incrementarDia() {
        fecha.incrementarDia();

    }

    public Fecha fechaActual() {
        return fecha = new Fecha(fecha.dia(), fecha.mes());
    }

}
