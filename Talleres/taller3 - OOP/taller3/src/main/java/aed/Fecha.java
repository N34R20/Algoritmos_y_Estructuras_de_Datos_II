package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
        /* this.dia */
    }

    public Fecha(Fecha fecha) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes;
    }

    @Override
    public boolean equals(Object otra) {
        /*
         * La anotación @Override en Java es una directiva para el compilador
         * que indica que el método anotado debe sobrescribir un método en una
         * superclase.
         * Esto es útil para mejorar la claridad del código y prevenir errores,
         * ya que si el método anotado no está realmente sobrescribiendo un método de la
         * superclase, el compilador mostrará un error.
         * 
         * En el contexto de la programación orientada a objetos,
         * la anotación @Override se usa comúnmente para asegurarse de que un método
         * de una subclase esté realmente reemplazando (o sobrescribiendo) un método de
         * la superclase.
         * Si el método no está sobrescribiendo un método de la superclase,
         * el compilador mostrará un error, lo que puede ser útil para detectar errores
         * de sintaxis o de lógica en el código.
         * 
         * En la implementación del método equals,
         * 
         * @Override se utiliza para indicar explícitamente que estamos sobrescribiendo
         * el método equals de la clase Object. Esto es útil para asegurarnos de que
         * estamos utilizando la anulación de métodos de manera correcta y coherente con
         * las convenciones del lenguaje Java.
         */

        // Verificar si el objeto pasado como parámetro es de tipo Fecha
        if (otra instanceof Fecha) {
            // Convertir el objeto a tipo Fecha
            Fecha otraFecha = (Fecha) otra;
            // Comparar día y mes
            return this.dia == otraFecha.dia && this.mes == otraFecha.mes;
        }
        // Si el objeto no es de tipo Fecha, no puede ser igual
        return false;
    }

    public void incrementarDia() {

        if (dia == 31 && mes == 12) {

            dia = 1;
            mes = 1;
        }

        else if (dia == diasEnMes(mes) && mes != 12) {
            dia = 1;
            mes = mes + 1;
        }

        else {
            dia = dia + 1;
        }
        ;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
