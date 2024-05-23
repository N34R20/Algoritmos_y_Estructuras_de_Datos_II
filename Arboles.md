# Arboles

Estructura de grafos

con un nodo principal y que para llegar a una hoja existe un unico camino -> se deduce que no tiene ciclos

Arbol
val: T
izq: Nodo
der: Nodo

tiene un nodo que tambien es de tipo arbol o NULL

### Como recorremos un arbol binario?

funcion recursiva

a la izquierda hay un arbol y a la derecha tambien

```
contar(n: NodoArbolBinario<T>): int

# cual seria el caso base -> que no tenga hijos

# if (n.izq == null && n.der == null)
if (n == null)
    return 0

else
    return 1 + contar(n.izq) + contar(n.der)
```

```
proc ContarAB(ab : ArbolBinario): Z
    asegura (contar(ab.raiz))

```

ejercicio:

- altura(in ab: ArbolBinario<T>): int
- esta(in ab: ArbolBinario<T>, int t: T): bool

```
altura(ab: ArbolBinario)

if (ab.raiz = null)
    return 0

else
    return 1 + (max(altura(ab.izq), altura(ab.der)))
```

```
esta(ab: ArbolBinario, t: int)

if ab.raiz == t:
    return True

else
    esta(ab.izq) || esta(ab.der)

```
