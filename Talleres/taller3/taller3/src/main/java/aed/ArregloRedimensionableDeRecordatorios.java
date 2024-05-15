package aed;

import java.util.Arrays;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private int longitud;
    private Recordatorio[] arreglo;

    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[0];
        this.longitud = 0;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAtras(Recordatorio i) {
        arreglo = Arrays.copyOf(arreglo, arreglo.length + 1);
        arreglo[longitud] = i;
        longitud++;
    }

    public Recordatorio obtener(int i) {
        return arreglo[i];
    }

    public void quitarAtras() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
