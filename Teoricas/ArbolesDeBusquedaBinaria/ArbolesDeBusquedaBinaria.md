# Diseño de Conjuntos y Diccionarios

Definicion del TAD Conjunto

```
TAD Conjunto<T> {
    obs elems: conj<T>

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura
}

```

Y del TAD Diccionaria

```
TAD Diccionario<K, V> {
    obs data: dict<K, V>

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura

proc ():
    asegura
}

```

### Conjuntos y Diccionarios?

Vamos a pensar implementaciones de esos diccionarios, pero de paso, otras variantes:

- Mas de un significado es posible
  - Listas de significados, Conjuntos de significados
  - que obtenemos al _obtener_? y que borramos al _borrar_?
- Diccionarios con un solo significado posible (o sea |K| = 1)
- Los conjuntos son un caso particular de los diccionarios
- Ademas, cualquier diccioanrio pueden ser pensados como si K fuera "punteros al significado"
- En conclusion, lo mas interesante es pensar como representar conjuntos

### Representacion de conjuntos y diccionrios a traves de arrays

Conjuntos y diccionarios pueden representarse a traves de arrays (con o sin repetidos, ordenaso o desordenados)

- Ya vimos varias de esas soluciones.

Intenten hacer Uds. mismos el ejercicio de escribir INV, ABS, y los algoritmos
