# Heaps y Tries

## Que es un Heap?

Es un arbol binario con dos propiedades:

- **Casi completo**. Todos los niveles, a excepcion del utlimo, estan completos. El ultimo se completa de izquierda a derecha hasta que se llene.

- **Ordenado**. Todo nodo tiene un valor mayor o igual (**MaxHeap**) o menor o igual (**MinHeap**) que sus nodos hijos. No existe relacion entre nodos no emparentados

## Operaciones

- _ConsultarMax_ con costo O(1)

- _DesencolarMax_ con costo O(log(n))

- _Encolar_ con costo O(log(n))

## Como se mantiene?

## Como puedo construir un Heap?

**Algoritmo de Floyd**. A partir de un arreglo de enteros cualquiera podemos transformarlo en un heap o _heapificralo_ en costo O(n)

## Uso de los Heaps

Es la implementacion mas comun para las **colas de prioridad**

Ejemplos:

- **Cola de un hospital** La gente llega en cualqueir orden pero los tenemos que atender segun la gravedad de su cuadro clinico

- **Procesos en un SO** Cada proceso tiene su prioridad, en los tiempos ociosos la CPU ejecuta el proceso de mayor prioridad.

- **Estructuras Auxiliares** En diferentes algoritmos

## Que es un Heap?

- **Arboles n-arios** Donde n seria el tamaño del alfabeto mas uno (por el simbolo reservado $)

- Normalmente se utilizan para guardar grandes conjuntos de palabras o secuencias de elementos con un alfabeto reducido

- Cada nodo representa un caracter o componente de los elementos guardados

- Se marca con **$** la finalizacion de la palabra o elemento

Cada nodo puede implementarse con **arreglos o listas enlazadas**

**Que represnta cada espacio?**: Cada elemento de mi alfabeto. deberia tener una referencia al subtrie que comienza con las letras recorridas (**prefijo**)

## Operaciones

La principal diferencia es que la **complejidad** va a depender del **tamaño de las palabras** y no de cuantos elemntos tenga ya agregados

- _Agregar_ con costo $O(|e|)$

- _Borrar_ con costo $O(|e|)$

- _Pertenece_ con costo $O(|e|)$
