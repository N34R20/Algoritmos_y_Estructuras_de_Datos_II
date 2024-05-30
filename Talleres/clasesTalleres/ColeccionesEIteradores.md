# Colecciones e Iteradores

## Colecciones

Una **coleccion** representa un grupo de objetos. Provee de una arquitectura para su almacenamiento

Conocemos los siguientes tipos de colecciones:

- Secuencia
- Conjunto
- Multiconjunto
- Diccionario
- Vector? -> El vector es una posible implementacion del TAD Secuencia

## Operaciones sobre colecciones

Preguntas tipicas sobre colecciones:

- Dado un elemento, esta en la coleccion?
  pertenece(x, conj)
  esta(dcit, x)

- Listar todos los elementos de una coleccion
- Encontrar el elemento mas chico de la coleccion
- etc

### Conjunto

Coleccion (finita) de elementos sin distinguir orden ni multiplicidad

```
TAD Conjunto<T> {

    obs elems: conj<T>

    proc :

}

```

### Conjunto (Java)

```Java

public interface Set<T> extends Collection<T>{
boolean contains(T elem); // Determina si el conjunto
// contiene a elem
boolean add(T elem); // Agrega a elem al conjunto
boolean remove(T elem); // Quita a elem del conjunto
int size(); // Devuelve el tama~no del conjunto
};
```

### Diccionario

Tabla que asocia _claves_ a _significados_

```
TAD Diccionario<K, V> {

    obs m: dict<K, V>

    proc :

}

```

### Diccionario (Java)

```Java

public interface Map<K, V> {
boolean containsKey(K clave); // Determina si el dicc
// contiene a clave
V get(K clave); // Obtiene el valor asociado a clave
V put(K clave, V valor); // Define el par clave-valor
};
```

## Tipos parametricos

```Java
public interface Set<T> extends Collection<T> {...}
public interface Map<K,V> {...}
```

¿Que tipos de datos son T, K y V?

Se llaman **tipos parametricos**: constituyen _variables de tipo_

- Es decir, T, K y V pueden tomar como valor cualquier tipo
- Nos permiten definir una interfaz _generica_, que pueden ser implementada por distintos tipos de datos
- No obstante, si nuestra implementacion requiere de un orden, entonces T debe ser _comparable_ (i.e., definir una relacion de orden total).
  - Esto se logra a traves de la interfaz _Comparable _<T\>, _sobrecargando_ el metodo _CompareTo(T otro)_

## Recorriendo colecciones

¿Como recorremos una coleccion?

```Java
import java.util.*;
class RecorriendoColecciones
{
public static void main(String[] arg)
{
List<String> seleccion = new Vector<String>();
seleccion.add("Messi");
seleccion.add("Di Marıa");
for (String jugador : seleccion)
System.out.println(jugador);
Map<Integer, String> seleccion = new HashMap<Integer, String>();
seleccion.put(10, "Messi");
seleccion.put(11, "Di Marıa");
for (Map.Entry<Integer, String> jugador : seleccion.entrySet())
System.out.println(jugador.getKey().toString() + " " +
jugador.getValue());,→
} // 10 Messi
// 11 Di Marıa
}
```

No obstante, la **estructura subyacente** a una coleccion puede estar implementada de muchas maneras distintas

- Esta estructura es **privada** y, por lo tanto, invisible para el usuario.
- Entonces... como podemos recorrer una coleccion sin conocer su estructura? -> iteradores

## Iteradores

Un **iterador** es una manera abstracta de recorrer coelcciones, independientemente de su estructura

### Informalmente

iterador = coleccion + dedo

Operaciones con iteradores:

- Esta posicionado sobre un elemento?
- Obtener el elemento actual
- Avanzar al siguiente elemento
- Retroceder al elemento anterior (Bidireccional)

## Iteradores en Java

Como corresponde, Java provee de una interfaz para iteradores:

```Java
public interface Iterator<E> {
boolean hasNext();
E next();
}

```

- _Obtener_ y _avanzar_ se combinan en el metodo next()
- Nosotros vamos a ser los responsables de implementarlo sobre nuestra estructura de datos

## Implementando el iterador de Vector

Supongamos la siguiente implementacion de la clase Vector:

```Java

public class Vector<T> implements List<T>{
private T[] elementos;
private int size;
...
public Iterator<T> iterator(){
return new Iterador();
}
...
}

```

Donde va a estar implementado Iterador?
Dentro de la clase! Por Que?

## Listas simplemente enlazadas

Una _lista simplemente_ enlazada es una estructura que sirve para representar una secuencia de elementos, distinta del vector.

```Java
public interface List<T> extends Collection<T> {...}
public class Vector<T> implements List<T> {...}
public class LinkedList<T> implements List<T> {...}

```

Cada elemento de la secuencia se representa mediante un _nodo_, que contiene un elemento y una referencia al siguiente nodo.

Asumiendo que tenemos una referencia al primer elemento (primero) y una variable _size_

Cual es su invariante de representacion?

1. Si la lista esta vacia, entonces primero es null y size vale 0
2. Si la lista no esta vacia, entonces primero apunta al primer nodo de la lista y size es la cantidad de nodos
3. Todos los nodos de la lista apuntan al siguiente, excepto el ultimo
4. El ultimo nodo apunta a nul

Sus principales caracteristicas son:

- Permiten un manejo mas fino del uso de memoria (no es necesario reservar memoria por adelantado)
- Permiten insertar al principio (y potencialemnte al final ) de forma eficiente
- Son eficientes para reacomodra elementos (util para ordenar)

Cual es la desvantaja?
Perdemos el _acceso aleatoria_ a los elementos

### Lista de Enteros

Implementemos la clase _ListaDeInts_, sobre una lista simplemente enlazada, con los siguientes metodos:

```Java

class ListaDeInts implements SecuenciaDeInts {
private ...
ListaDeInts();
ListaDeInts(ListaDeInts otro);
void agregarAtras(int elem);
void agregarAdelante(int elem);
void eliminar(int indice);
...
}

```

### Estructura y constructores

```Java
class ListaDeInts implements SecuenciaDeInts {
private Nodo primero;
private class Nodo {
int valor;
Nodo sig;
Nodo(int v) { valor = v; }
}
public ListaDeInts() {
primero = null;
}
public ListaDeInts(ListaDeInts otra) {
Nodo actual = otra.primero;
while (actual != null) {
agregarAtras(actual.valor);
actual = actual.sig;
}
}

```

### Agregando elementos

```Java
public void agregarAdelante(int elem) {
Nodo nuevo = new Nodo(elem);
nuevo.sig = primero;
primero = nuevo;
}
public void agregarAtras(int elem) {
Nodo nuevo = new Nodo(elem);
if (primero == null) {
primero = nuevo;
} else {
Nodo actual = primero;
while (actual.sig != null) {
actual = actual.sig;
}
actual.sig = nuevo;
}
}

```

### Eliminando un elemento

```Java
public void eliminar(int i) {
Nodo actual = primero;
Nodo prev = primero;
for (int j = 0; j < i; j++) {
prev = actual;
actual = actual.sig;
}
if (i == 0) {
primero = actual.sig;
} else {
prev.sig = actual.sig;
}
}

```
