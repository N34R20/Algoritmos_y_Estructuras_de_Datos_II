# Programacion Orientada a Objetos en Java

## Cualidades del software

Fundamentales:

- Correcto con respecto a una especificacion
- Eficiente
- Reutilizable
- Extensible / modificable
- Usable
- Legible
- Predecible
- ...

El **diseño** consiste en organizar el programa de tal manera que cumpla con las cualidades requeridas, en algun contexto de uso.

TAD (Tipo Abstracto de Datos)

- Que es?

- Es un tipo de datos porque define un conjunto de valores y las operaciones que se peuden realizar sobre ellos.

- Es abstracto ya que para utilizarlos, no se necesita conocer los detalles de la representacion interna ni como estan implementadas sus operaciones.

- Describe el "que" y no el "como"

- Son una forma de modularizar a nivel de los datos

- Y para que sirven? -> **Para modelar la realidad!**

### Ejemplo: buscaminas

```
TAD Juego {
        obs tablero: Tablero
        obs jugadas: seq<Pos>

        proc nuevoJuego(in t: Tablero): Juego
        asegura res.tablero == t

        proc jugar()
        requiere !j.perdio() && !j.gano()
        requiere !(p in j.jugadas)
        asegura p in j.jugadas

    pred perdio(j: Juego)
        ...
    pred gano(j: Juego)
        ...

}
```

A el juego Buscaminas

Y vamos a utilizar a nuestro amigo **Java** al rescate

### que utilizaremos?

Vamos a utilizar una pequeña parte de Programacion Orientada a Objetos (POO), utilizaremos clases de "Java"

La programación orientada a objetos (POO, en español); es un paradigma de programación que partedel concepto de .objetosçomo base, los cuales contienen información en forma de campos (a veces también referidos como atributos o propiedades) y código en forma de métodos.

Los objetos son capaces de interactuar y modificar los valores contenidos en sus campos o atributos (estado) a través de sus métodos (comportamiento).

Algunas características clave de la programación orientada a objetos son herencia, cohesión, abstracción, polimorfismo, acoplamiento y encapsulamiento

### Definiendo clases

Vamos a definir una clase en avrias etapas:

1. Vamos a declarar los _metodos publicos_
2. Vamos a declarar los _atributos privados_ de la clase
3. Vamos a implementar los metodos publicos
4. En particular, el _constructor_ de la clase (o los constructores)

- Se puede programar con clases pero no modularmente

### Ejemplo

Modelar un contador de puntos del juego de truco para dos jugadores

Necesitamos:

- Conocer el puntaje de ambos jugadores
- Sabir si un jugador esta en las buenas
- Poder sumar puntos a cada jugador

Este comportamineto podemos expresarlo a traves de una interfaz

```Java
public class Truco {

    public void sumarPunto(int jugador){
        /* TODO */
    }
    public int puntaje(int jugador){
        /* TODO */
    }
    public boolean enLasBuenas(int jugador){
        /* TODO */
    }
}
```

Si tuvieramos esta clase en Java, sabriamos como usarla?

-
-
-

```
TAD Truco{
    obs tantos(jugador: nat): nat

    proc nuevaPartida(): Truco
    asegura res.tantos(0) == 0 && res.tantos(1) == 0

    proc sumarPuntos()
    requiere
    asegura
    asegura

    proc puntaje() : nat
    requiere
    asegura

    proc estaEnLasBuenas() : bool
    requiere
    asegura
}
```

### Clases e instancias

```Java

```

class Truco es la clase.
t1 y t2 son instancias de la clase

Para que el comportamiento de la clase pueda llevarse a cabo, hay que implementarla
La **implementacion** esta dada por:

- La **representacion interna**: un conjunto de variable que detemrina el estado interno de la instancia

- Un conjunto de **algoritmos** que implementan cada una de las operaciones de la inerfaz, consultando y modificando las variables de la represenatcion interna.

### Declaracion de atributos privados

```Java
class Truco{
    /*...*/
    private int _puntaje0;
    private int _puntaje1;
    private boolean _buenas0;
    private boolean _buenas1;
};
```

### Comportamientos

Como definimos para las instancias?
A traves de **metodos**:

```Java
public void sumarPunto(){
    if(jugador == 1) {
        _puntaje1++;
        if (_puntaje1 == 16) {
            _puntaje1 = 0;
            _buenas1 = true;
    } else {
        _puntaje2++;
        if (_puntaje2 == 16) {
            _puntaje2 = 0;
            _buenas2 = true;
        }
    }
}
```

### Constructor

## Memoria

Todo el contenido de las variables ocupa “espacio“ en la “memoria”.
Hay tres regiones principales (a nivel sistema operativo)

#### Global (estatica) -> en el ejecutable

#### Contexto local -> en la pila (_stack_)

#### Dinamica (manual) -> en el _heap_

### Aliasing

## Interfaces comunes

Hay metodos que tienen una implementacion por defecto en todos los objetos de Java, pero se puede sobre-escribir.

### Metodo toString

### Metodo equals
