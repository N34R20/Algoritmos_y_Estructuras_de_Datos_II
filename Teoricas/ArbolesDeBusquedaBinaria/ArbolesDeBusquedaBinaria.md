# Diseño de Conjuntos y Diccionarios

Definicion del TAD Conjunto

```
TAD Conjunto<T> {
    obs elems: conj<T>

proc conjVacio(): conjunto<T>
    asegura res.elems = {}

proc pertenece(in c: Conjunto<T>, in T e): bool
    asegura res = true <==> e in c.elems

proc agregar(inout c: Conjunto<T>, in e: T):
    asegura c.elems = old(c).elems + {e}

proc sacar(inout c: Conjunto<T>, in e: T):
    asegura c.elems = old(c).elems - {e}

proc unir(inout c: Conjunto<T>, in c': Conjunto<T>):
    asegura c.elems = old(c).elems + c'.elems

proc restar(nout c: Conjunto<T>, in c': Conjunto<T>):
    asegura c.elems = old(c).elems - c'.elems
}

```

Y del TAD Diccionaria

```
TAD Diccionario<K, V> {
    obs data: dict<K, V>

proc diccionarioVacio():
    asegura

proc esta():
    asegura

proc definir():
    asegura

proc obtener():
    requiere
    asegura

proc borrar():
    requiere
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

- Complejidad de las operaciones de las operaciones: depende de la implementacion, pero
  - Tiempo: alguna de las operaciones requiere $O(n)$ en el peor caso
  - Espacio: $O(n)$
  - se podra hacer mejor?

## Arboles/Arboles Binarios

Podemos definir el tipo conceptual (matematico) arbol\<T>.

Asi como con las secuencias, podemos definir arboles de cualquier tipo T

Se puede definir recursivamente como

- Nill es un arbol\<T>
- Una tupla que contiene un elemento de T y una secuencia de arboles\<T>, es un arbol\<T>.

Sobre arboles, usamos una terminologia variada:

- \<<_botanica_\>> : (raiz, hoja)
- \<<_genealogica_\>> : (padre, hijo, nieto, abuelo, hermano)
- \<<_fisica_\>> : (arriba, abajo)
- \<<_topologica_\>> : (nodo interno, nodo externo)

Hay un tipo particular de arboles, que son los arboles Binarios:
la secuencia de arboles tiene como maximo dos elementos:

![imagen 1](</etc/imgs/Captura%20de%20Pantalla%202024-05-28%20a%20la(s)%2018.05.48.png>)

El concepto matematico arbol tiene muchos usos, propiedades y funciones muy conocidas.
Por ejemplo, dado un arbol _a_, podemos habalr de _vacio?(a)_, raiz(a)_, altura(a)_, _elementos(a)_, _esta(e, a)_ y muchas mas.

Y para arboles binarios, tambien _izq(a)_ y _der(a)_

Esas funciones se pueden definir recursivamente

- _altura(nil) = 0_
- _altura(\<n,i,d\>) = 1 + max{altura(i)+altura(d)}_
- _elementos(nil) = []_
- _elementos(\<n,i,d\>) = [n] ++ elementos(i) ++ elementos(d)_

## Arboles Bianrios de Busqueda (ABB)

Que es un arbol bianrio de busqueda?

Es un arbol bianrio que satisface la siguiente propiedad:

- Para todo nodo, los valores de su subarbol **izquierdo** son **menores** que el valor del nodo y los valores del subarbol **derecho** son **mayores**

```
esABB(a): esArbolBin(a) && esABBN(a.raiz)
esABBN(r) : r = null || (∀x) x in elementos(r.izq) => x<=r.dato && (∀x) x in
elementos(r.der) => x>r.dato && esABBN(r.izq) && esABBN(r.der)
```

### Ejemplo:

## Invariante de Representacion

El invarinate de representacion de la representacion de Conjuntos con Arboles Binarios que son de Busqueda seria:

pred InvRepABB (e: AB)

    {esABB(e) = TRUE}

```
esABB(a): esArbolBin(a) && esABBN(a.raiz)
esABBN(r) : r = null || (∀x) x in elementos(r.izq) => x<=r.dato && (∀x) x in
elementos(r.der) => x>r.dato && esABBN(r.izq) && esABBN(r.der)
```

y la funcion de abstraccion?

FuncAbs(a: AB): Conjunto c | c.elems = {n:N | n in elementos(a.raiz)}

```
elementos(r) = if r = null then {} else {r.dato} U elementos(r.izq) U elementos(r.der)
```

## Algoritmos para ABB

- Vacio

- Busqueda

- Insercion

- Eliminar

## Vacio

```
impl vacio(): ABB {
    a = new ABB;
    a.raiz = null;
    return a
}
```

## Busqueda (search)

```
impl busqueda(a: ABB, k:int): bool {
    return busqueda(a.raiz, k) != null
}

impl busqueda(n: Nodo, k:int): nodo {
    if n == null || k = n.dato
        return n
    if k < n.dato then busqueda(n.izq, k)
    else busqueda(n.der, k)
}
```

**Complejidad**: $O(h)$, con _h_ la altura del arbol

## Busqueda Iterativa

```
busqueda(n: Nodo, k: int):
    while n! = null || k != n.dato
        if k < n.dato then n = n.izq
        else n = n.der
    return n;

```

Hipotesis de la recursion similar a la busqueda binaria:

- Si k\<n.dato, k menor que elemntos(n.der), buscar a la izquierda
- Si k\>n.dato, k mayor que elemntos(n.izq), buscar a la derecha

## Insertar

```

```

Costo de la insercion:

- Depende de la distancia del nodo a la raiz

En el peor caso: $O(n)$

En el caso promedio (suponiendo una distribucion uniforme de las claves): $O(log n)$

## Eliminar
