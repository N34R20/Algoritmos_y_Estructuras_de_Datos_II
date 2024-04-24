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

## Operaciones de un TAD

## TAD Conjunto

## TAD Punto
