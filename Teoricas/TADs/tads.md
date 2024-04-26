# TAD (Tipo Abstracto de Datos)

### Que es un TAD?

- Es un **tipo de datos** porque define un conjunto de valroes y las **operaciones** que se pueden realizar sobre ellos
- Es **abstracto** ya que para utilizarlos, no se necesita conocer los detalles de la representacion interna ni como estan implementadas sus operaciones.
- No conocemos la "forma" de los valores, los TADs solo describen el "que" y no el "como".
- Son una forma de **modularizar** a nivel de los datos.

### Ejemplo de TAD

- El TAD _conjunto_ es una abstraccion de un conjunto matematico, que "contiene" "cosas" (todas del mismo tipo), sus "elementos"

- Hay operaciones para agregar y sacar elemntos y para ver si algo esta o no (pertenece). Se puede saber cuantos elementos tiene.

- El conjunto no tiene en cuenta repetidos: si en un conjunto de numeros agregamos el 1, el 5 y otra vez el 1, la cantidad de elemntos sera 2.

### Otro ejemplo

- El TAD punto 2D es una abstraccion de un punto en el plano cartesiano

- Se puede describir a partir de sus coordenadas cartesianas $(x,y)$ o polares $(\rho, \theta)$

- Tiene operaciones para moverlo, rotarlo sobre el eje o alejarlo del centro, etc.

## Observadores

- El estado de una **instancia** de un TAD lo describimos a traves de **variables** o **funciones de esatdo** llamadas _observadores_.

- Podemos usar todos los tipos de datos del lenguaje de especificacion (int, real, seq\<T\>, conj\<T\>, etc.)

- En un instante de tiempo, el estado de una instancia del TAD estara dado por le estado de todos sus obervadores

### Ejemplo

TAD punto 2D

- El estado del TAD punto 2D puede ser dado por:

  - variables de estado para las coordenadas cartesianas

        - obs x: real
        - obs y: real

  - o, variables de estado para coordenadas polares

        - obs rho: real
        - obs theta: real

  - Pero no ambas!

- Podiramos tener un solo observador (por ejemplo, una sola coordenada)?
  - No nos serviria, porque no se peude describir un punto del plano mediante una sola coordenada. No nos alcanza.

## Observadores

- El conjunto de observadores tiene que ser _completo_. Tenemos que poder observar todas las caracteristicas _que nos interesan_ de las instancias

- A partir de los observadores se tiene que poder distinguir si dos instancias son distintas

- Todas las operaciones tienen que poder ser descriptas a partir de los observadores

## Observadores - Otro ejemplo

TAD Conjunto

- El estado del TAD Conjunto puede ser:

  - una variable del tipo conj\<T\> (el conjunto de nusetro lenguaje de especificacion)

        - obs elems: conj<T>

(Formalmente, las variables de estado pueden considerarse tambien funciones como obs elems(c: Conjunto\<T\>): conj\<T\>)

- O, una funcion que, dado un elemento, indique se esta o no presente en el conjunto y otra que nos indique la cantidad de elementos

      - obs esta(e: T): bool

- OJO. Si usamos funciones como observadores, estas son funciones auxiliares de nuestro lengujae de especificacion, y por lo tanto

  - no pueden tener efectos colaterales ni modificar parametros
  - pueden usar tipos de nuestro lenguaje de especificacion
  - puedes usar otros TADs

- Igualdad **observacional**: decimos que dos instancias son iguales si todos sus observadores son iguales

  - Es una forma _por defecto_ de determinar que dos elementos de un TAD son iguales, pero podemos definir tambien nuestra propia operacion de igualdad.

## Operaciones de un TAD

- Las operaciones del TAD indican que se puede hacer con una instancia de un TAD

- Las especificaciones con nuestro lenguaje de especificacion

- Para indicar que hacen, usamos precondiciones y postcondicioens (requiere y asegura)

```
    proc agregar(inout c: conjunto<T>, in e: T)
        requiere ...
        asegura ...
```

- Para eso hablaremos del estado del TAD(o sea, del valore de sus observadores) antes y despues de aplicar la operacion.

## TAD Conjunto

```
TAD Conjunto<T> {
    obs elems: conj<T>

    proc agregar(inout c: conjunto<T>, in e: T)
        asegura c.elems == old(c).elems U {e}
}
```

```
TAD Conjunto<T> {
    obs esta(e: T): bool

    proc agregar(inout c: conjunto<T>, in e: T)
        asegura c.esta(e) == true
        asegura (forall e': T) e' != e ==> (old(c).esta(e') = c.esta(e'))
}
```

- **ATENCION**: para evitar la subespecificacion, tenemos que describir el estado **completo** al salir de la funcion... Es decir, **cuanto valen TODOS los observadores**. (Pensar ejemplos de porque sucede esto ...)

- **ATENCION**: Los observadores son solo para especificar. No son operaciones que se peudan usar en el codigo, en la implementacion.

- Si queremos usarlas en el codigo tenemos que especificarlas tambien como operaciones ...

```
TAD Conjunto<T> {
    obs elems: conj<T>

    proc conjVacio(): Conjunto<T>
        asegura res.elems = {}

    proc agregar(inout c: conjunto<T>, in e: T)
        asegura c.elems == old(c).elems U {e}

    proc sacar(inout c: conjunto<T>, in e: T)
        asegura c.elems = old(c).elems - {e}
}
```

## TAD Punto

```
TAD Punto{
    obs x: float
    obs y: float

    proc nuevoPunto(): Punto
        asegura

    proc coordX(): float
        asegura

    proc coordY(): float
        asegura

    proc coordTheta(): float
        asegura

    proc coordRho(): float
        asegura

    aux safearctan(): float
        asegura

    proc mover():
        asegura
}
```
