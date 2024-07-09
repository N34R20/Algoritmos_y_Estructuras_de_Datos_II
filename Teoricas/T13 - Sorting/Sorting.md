# Ordenamiento (Sorting)

- Ordenar: arreglo[$\alpha$] -> arreglo[$\alpha$], donde $\alpha$ es un tipo tal que esta definida la relacion < $\alpha$

- Postcondicion $\forall i, j (i<j \rightarrow a[i] \leq a[j])$

- Uno de los problemas mas clasicos, utiles y estudiado de la informatica

- Variante: ordenamineto en memoria secundaria (por ejemplo archivos muy grandes que no caben en RAM)

# Selection Sort

### Algoritmo:

- repetir para las posiciones sucesivas $i$ del arreglo: - Seleccionar el minimo elemento que se encuentra entre la posicion actual y el final - ubicarlo en la posicion $i$, intercambiandolo con el ocupante original de esa posicion

### Invariante:

- Los elementos entre la posicion 0 y la posicion $i$ son los $i+1$ elementos mas pequeños del arreglo original,

- Los elementos entre la posicion 0 y la posicion $i$ se encuentran ordenados,

- El arreglo es una permutacion del arreglo original (o sea los elemntos entre las posiciones $i+1$ y $n-1$ son los $n-i-1$ elementos mas grandes del arreglo original)

# Insertion Sort

### Algoritmo:

- Repetir para las posiciones sucesivas $i$ del arreglo: - Insertar el i-esimo elemento en la posicion que le corresponde del arreglo 0..i

### Invariante:

- Los elemntos entre la posicion 0 y la posicion $i$ son los elementos que ocupaban las posiciones 0 a $i$ del arreglo original,

- Los elementos ordenados entre la posicion 0 y la posicion $i$ se encuentran ordenados,

- El arreglo es una permutacion del arreglo original (o sea que los elementos de las posiciones $i+1$ hasta $n-1$ son lo que ocupaban esas posiciones en el arreglo original)

# Merge Sort

- Ejemplo de la metodologia "Divide & Conquer"

- La metodologia consiste en

  - Dividir un problema en problemas similares .. pero mas chicos
  - resolver los problemas menores
  - Combinar las soluciones de los problemas menores para obtener la solucion del problema

- El metodo tiene sentido siempre y cuando la division y la combinacion no sean excesivamente caras.

### Algoritmo:

- Si $n<2$ entonces el arreglo ya esta ordenado

- En caso contrario:

  - Dividir el arreglo en dos partes iguales (o sea por la mitad!)

  - Ordenar recursivamente (o sea a traves del mismo algoritmo) ambas mitades

  - "Fundir" ambas mitades (ya ordenadas) en un unico arreglo

### Invariante:

# Estabilidad

Un algoritmos de ordenamiento es estable si dos registros $i$ y $j$ con claves iguales mantienen su orden relativo una vez ordenado el arreglo. Es decir:

### Algoritmo:

### Invariante:

# Quick Sort

- Idea parecida a D&C

- Muy estudiado, analizado y utilizado en la practica

- Supongamos que conocemos el elemento mediano del arreglo

### Algoritmo:

- Separar el arreglo en dos mitades: los elementos menores que el mediano por un lado y los mayores por el otro.

- Ordenar las dos mitades

- Listo

### Invariante:

# Complejidad de los algortimos de ordenamiento

# Arboles de Decision
