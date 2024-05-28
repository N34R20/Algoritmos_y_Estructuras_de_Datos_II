# Implementacion eficiente del tipo de dato _Conjunto_

```Java
interface Conjunto<T> {
    public int cardinal();
    public void insertar(T elem);
    public void eliminar(T elem);
    public boolean pertenece(T elem):
    public String toString();
    public T maximo();
    public T minimo();
}
```

## Complejidad de las estructuras implemnetadas hasta ahora:

|               | Arreglo redimensionable | Lista enlazada | Lista bi-enlazada |
| ------------- | ----------------------- | -------------- | ----------------- |
| **pertenece** | $O(log N)$              | $O(N)$         | $O(N)$            |
| **insertar**  | $O(N)$                  | $O(N)$         | $O(N)$            |
| **borrar**    | $O(N)$                  | $O(N)$         | $O(N)$            |
| **max/min**   | $O(1)$                  | $O(N)$/$O(1)$  | $O(N)$/$O(1)$     |

Podemos hacer algo mejor?

## Introduccion

Cual es la menor cantidad de preguntas Si/No que se necesitan para identificar un entero entre 0 y 15?

1. $x mod 16 \geq 8$
1. $x mod 8 \geq 4$
1. $x mod 4 \geq 2$
1. $x mod 2 \geq 1$

Necesitamos ($log_2 x$) preguntas (bits) para **representar** un numero $x$

Podemos usar esta propiedad para **implementar** un conjunto eficiente?

## Arboles binarios de busqueda (ABB)

invariante de representacion

un objeto es ABB $\leftrightarrow$ _es null_ o satisface las siguientes condiciones:

- Los valores del subarbol izquierdo son menores que el valor de la raiz.
- Los valores del subarbol derecho son mayores que el valor de la raiz.
- Los objetos izquierdos y derechos son ABBs.

## Implementacion (ABB.java)

El unico atributo indispensable es \_raiz. Pero podriamos usar otros (como \_cardianal o \_altura) para tener operaciones $O(1)$

```java
public class ABB<T> extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    // privite int _cardinal;
    // privite int _altura;
    public ABB() {
        _raiz = null;
        // _cardinal = 0;
        // _altura = 0;
    }
}

```

## Representacion de los nodos

```java

private class Nodo {
    // declaramos los atributos
    T valor;
    Nodo izq;
    Nodo der;
    Nodo arriba;

    // Definimos el constructor de Nodo (solo recibe un valor _v_ de tipo T)

    Nodo (T v) {
        valor = v;
        izq = null;
        der = null;
        arriba = null;
    }
}
```

## Iterador

Iterador<T>

```java
private class ABB_Iterador implements Iterador<T> {
    private Nodo _actual = this.minimo();

    public boolean haySiguiente() {
        /*...*/
    }

    public T siguiente() {
        /*...*/
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
```
