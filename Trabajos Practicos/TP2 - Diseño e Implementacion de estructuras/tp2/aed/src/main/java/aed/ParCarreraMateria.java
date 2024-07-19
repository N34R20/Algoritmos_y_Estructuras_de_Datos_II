package aed;

// Inavriante de ParCarreraMateria:

// carrera es una calve valida en la instancia de DiccionarioCarreras y 
// nombreMateria es una clave valida en la instancia del DiccionarioMaterias que es el valor que guarda carrera 
public class ParCarreraMateria {
    String carrera;
    String nombreMateria;

    public ParCarreraMateria(String carrera, String nombreMateria) {
        this.carrera = carrera;
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public String getCarrera() {
        return this.carrera;
    }
}
