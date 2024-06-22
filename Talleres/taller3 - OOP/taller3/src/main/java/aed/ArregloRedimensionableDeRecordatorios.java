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
        this.arreglo = Arrays.copyOf(vector.arreglo, vector.arreglo.length);
        this.longitud = vector.longitud;
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
        arreglo = Arrays.copyOf(arreglo, arreglo.length - 1);
        longitud--;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        arreglo[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        copia.arreglo = Arrays.copyOf(this.arreglo, this.arreglo.length);
        copia.longitud = this.longitud;
        return copia;
    }

}
