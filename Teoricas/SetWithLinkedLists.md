# SetUsingLinkedList

## Memoria Dinamica

- El espacio que va a requerir un programa para su ejecucion, puede ser conocido de antemano, o no.

- La Memoria Dinamica es el mecanismo a traves del cual los lenguajes imperativos nos proveen de primitivas para almacenar informacion cuando no sabemos de antemano cuanto espacio necesitamos, o incluso cuando lo sabemos pero la cota superior es muy grande (y por lo tanto la gestion estatica de la memoria no resulta)

- Parte de una organizacion de la memoria dividida en dos partes:
  - El stack (pila) de **memoria estatica**, y
  - El "heap" (monton) para la **memoria dinamica**

## Memoria Estatica: el stack

- Cada vez que se entra a ejecutar una rutina (incluyendo el _main_), se asigna un "frame" o bloque, que contiene la memoria estatica que pide el procedimiento, incluyo espacio para los parametros formales, que son cargados con los valores con los que se invoco (algunos de ellos, potencialmente referencias).

- Cuando finaliza la ejecucion de la rutina, su "frame" se desapila y esa memoria se libera automaticamente. Los detalles son transparentes al programador.

## Memoria Dinamica: el heap

- El "Heap" (monton), es un espacio de memoria para almacenar objetos (estruturas y arreglos) a los que se accede por medio de referencias (o punteros)

- Estos elementos pueden contener, ademas de tipos basicos, referencias a otros elementos en el heap

- La memoria que es parte del Heap puede ser requerida de diversas maneras (por ejemplo, a traves de la primitiva New y el tipo del dato que se quiere)

- Para dejar de utilizar la memoria dinamica, se procede segun tres paradigmas principales

## Memoria Dinamica: devolucion

Tres paradigmas principales:

- Gestionada por programador ("a la C"): la gestion, incluyendo la liberacion, es responsabilidad de le programador. Eficiente pero potencialmente "unsafe" o con "leaks".

- Gestinada x Gargabe Collector ("a la Java"): Hay "aliasing" pero la liberacion es por medio del GC. Menos eficiente pero "safe", y no necesita gestion de eliminacion por parte de le programador

- Mecanismo de Ownership ("a la Rust"): el concepto de ownership y salida de scope implica liberacion de memoria. Requiere seguir ciertas disciplinas de programacion (pero menos carga para el programador). Es mas eficiente (que Java) y safe (que C y Java)

Vamos a seguir el paradigma de gestion de Java

primitivas que vamos a usar:

- **New(Tipo)** crea un nuevo lugar en el Heap de tipo **Tipo** (para nosotros tipicamente es un aetsructura o un arreglo de algo) y devuelve una referencia al mismo para que esta se guarde en algun otro lugar (campo, slot, parametro de salida, variable auxiliar, etc.) **NewArray<>(length)** es un caso particular.

- hay una constante de tipo referencia sitinguida **null** que no denota nigun elemento del heap

- Si una referencia es distinta a **null** es valido acceder al elemento y manipularlo segun el tipo correspondiente

-

-

## Definicion de tipos

## Representacion sobre listas encadenadas

Nodo = Struct <dato: \N, pxmo: Nodo>

SetUsingLinkedList (a.k.a. SLL)
Modulo SLL implementa Set {
head: Nodo

El modulo introduce un tipo SLL que es un struc que tiene un campo head. Ademas, un modulo introduce la implementacion de las operaciones del TAD y documenta el invariante de representacion y la funcion de abstraccion

## Invariante de Represenatcion

## Funcion de Abstraccion
