# Complejidad

Para resolver problemas, tenemos que diseñar algoritmos y estructuras de datos que: - funcionen correctamente - modelen bien el problema - los algoritmos terminen y produzcan el resutlado correcto - sean eficientes en terminos del consumo de recursos

- Esa medida de eficiencia nos permitira elegir entre
  - distintos algoritmos algortimos para resolver el mismo problema
  - distintas formas de implementar un TAD

## Analisis de la Complejidad de Algoritmos

Cuales son los recursos que se consumen?

- tiempo de ejecucion
- Espacio (memoria)
- Cantidad de procesadores (algoritmos paralelos)
- Utilizacion de la red de comunicaciones (algoritmos paralelos)

Otros criterios:

- Claridad de la solucion
- Facilidad de codificacion

Dependiendo de como balanceamos la importancia de cada uno de los criterios, podremos decir que un algoritmo es mejor que otro.

Nos vamos a ocupar solamente de los primero criterios: eficiencia en tiempo y espacio

El analisis de la complejidad de un algoritmo se puede hacer de forma:

### Empirica o experimental

    - Medir el tiempo de ejecucion para un determinada entrada y en una computadora correcta.
    - Usando un cronometro, o analizando el consumo de recursos de la computadora (tiempo de CPU)
    - Medidas del tipo: 3GB; 1,5 segundos.

### Teorica

    - Medida teorica del comportamiento de un algoritmo

### Ventaja del enfoque teorico:

- El analisis se puede hacer **a priori**, aun antes de escribir una linea de codigo
- Vale **para todas las instancias** del problema.
- Es **independiente del lenguaje de programacion** utilizado para codificarlo
- Es independiente de la maquina en la que se ejecuta
- Es independiente de la pericia del programador

## Analisis Teorico

Basado en un "modelo de maquina" o "modelo de computo" consensuado

- En funcion del tamaño del input
- Para distintos tipos de inputs
- Analisis asintotico

Modelo de computo

Definimos una maquina "ideal" que vamos a usar para definir los conceptos de tiempo y espacio

**Medida del tiempo**: numero de pasos o instrucciones que se ejecutan en esa maquina "ideal" para determinado input

**Medida del espacio**: numero de posiciones de memoria en esa maquina ideal que se utilizan para determinado input

## Ejemplo

## Operaciones Elementales

## Calculo de Operaciones elementales

## Tamaño de la entrada

Por que compliejidad en funcion del **tamaño de la entrada**?

- queremos una complejidad relativa, no absoluta
- Es una medida general de lo que podemos encontrar al ejecutar (queremos predecir, no nos interesa tanto cuanto tarda para una instancia particular sino para clases de instancias)
- Mas abstracta que pensarlo en funcion de cada input

- **T(n)**: complejidad temporal (o en tiempo) para una entrada de tamaño _n_
- **S(n)**: complejidad espacial para una entrada de tamaño _n_

## Analisis del caso peor, medio o mejor.

Distintas instancias, aunque tengan el mismo tamaño, pueden hacer que el algoritmo se comporte de maneras muy diferentes, y por lo tanto, tomar **distinto tiempo**, y/o requerir **distinta cantidad de memoria**

Por eso estudiamos tres casos para un mismo algoritmo:

- El caso **peor**
- El caso **mejor**
- El caso **medio**

### Analisis del caso _peor_

Sea $t(l)$ el timepo de ejecucion de un algoritmo sobre una instacia _l_

$$T_{peor}(n) = max_{instancias l, |l| = n} \{t(l)\}$$

Intuitivamente, $T_{peor}(n)$ es el timepo de ejecucion del algoritmo sobre la instancia que implica **mayor tiempo de ejecucion** (entre los inputs de tamaño _n_)

- Da garantias sobre las prestaciones del algoritmo

### Analisis del caso _mejor_

$$T_{mejor}(n) = min_{instancias l, |l| = n} \{t(l)\}$$

Intuitivamente, $T_{mejor}(n)$ es el timepo de ejecucion del algoritmo sobre la instancia que implica **menor tiempo de ejecucion** (entre los inputs de tamaño _n_)

- No da mucha informacion

### Analisis del caso _medio_

Intuitivamente, $T_{prom}(n)$ corresponde al tiempo "**promedio**" de ejecucion, al tiempo "**esperado**" sobre instancias "tipicas"

Se define como la esperanza matematica de la variable aleatoria definida por todas las posibilidades ejecuciones del algoritmo para un tamaño de la entrada dado, con probabilidades de que estas ocurran para esa entrada

- _P(l)_ probabilidad de que el input sea la instancia _l_
- $T_{prom}(n) = \sum_{instancias l, |l| = n} \{P(l) t(l)\}$

Por que comillas?

- Requiere conocer la distribucion estdistica del input: en muchos casos eso no es realista
- En muchos casos la matematica se complica, y se termina haciendo hipotesis simplificatorias poco realistas
- Podemos tener algoritmos para los cuales nigun input requiere tiempo medio (por ejemplo, un algoritmo que requiere o bien 1 o bien 100 pasos)

## Ejemplo: Busqueda

## Principio de invarianza

Dado un algoritmo y dos maquinas (o dos implementaciones) $M_1$ y $M_2$ que tardan $T_1(n)$ y $T_2(n)$ respectivamente sobre inputs de tamaño n,

$\exists$ una cte. real c>0 y un $n_0 \in N$ tales que $\forall n \geq n_0$ se verifica que:

$$ T_1(n) \leq c T_2(n) $$

**Explicacion**: dos ejecuciones distintas del mismo algoritmo solo difieren en cuanto a eficiencia en un fatcor constante para valores de la entrada suficientemente grandes.

**Consecuencia**: no necesitamos usar niguna unidad para medir el tiempo

## Analisis Asintotico

Los distintos algoritmos que resuelven un mismo problema pueden
tener grandes diferencias en su tiempo de ejecución, a veces, de
**órdenes de magnitud**

Interesa calcular, de forma aproximada, el orden de magnitud que
tiene el tiempo de ejecución de cada algoritmo.

Cuando el tamaño de los datos es pequeño no habrá diferencias
signiﬁcativas en el uso de distintos algoritmos.
Cuando el tamaño de los datos es grande, los costos de los diferentes
algoritmos sí pueden variar de manera signiﬁcativa

**El orden** (logaritmico, lineal, cuadratico, exponencial, etc.) de la funcion **$T(n)$**, que mide la complejidad temporal de un algoritmo, es el que expresa el comportamiento dominante cuadno el tamaño de la entrada es grande.

## Comportamiento Asintotico

comportamiento asintotico: comportamiento para valores de la entrada suficientemente grandes.

El objetivo del **estudio de la complejidad** algoritmica es determinar el **comportamiento asintotico** de un algoritmo

Medidas del comportamiento asintotico de la complejidad:

- $O$ (O grande) cota superior
- $\Omega$ (omega) cota inferior
- $\Theta$ (theta) orden exacto de la funcion

## Cota Superior - Notacion Big O

La notacion **O** (O, O grande, O mayuscula) sirve para representar el limite o cota superior del tiempo de ejecucion de un algoritmo

- La notacion $f \in O(g)$ expresa que la funcion f no crece mas rapido que alguna funcion proporcional a g

- A _g_ se le llama cota superiro de _f_

- Si para un algoritmo sabemos que $T_{peor} \in O(g)$, se puede asegurar qye para inputs de tamaño creciente, **en todos los casos** el timepo sera a lo sumo proporcional a la cota.

- Si para un algoritmo sabemos que $T_{prom} \in O(g)$, se puede asegurar que para inputs de tamaño creciente, **en promedio** el tiempo sera proporcional a la cota

Asumimos funciones reales no negativas con dominio en los naturales

f \in O(g) significa que _f_ no crece mas que _g_

$$
O(g) = \{f|\exists n_0,k> 0/ n\geq n_0 \rightarrow f(n) \leq k * g(n)\}
$$

Ejemplos:

$$
100n^2 + 300n + 1000 \in O(n^2)
$$

$$
100n^2 + 300n + 1000 \in O(n^3)
$$

### Propiedades de O

1. Para cualquier funcion _f_ se tiene que $f \in O(f)$
2. $f \in O(g) \rightarrow O(f) \subset O(g)$
3. $O(f) = O(g) \leftrightarrow f \in O(g) \land g \in O(f)$
4. Si $f \in O(g) \land g \in O(h)  \rightarrow f \in O(h)$
5. Si $f \in O(g) \land f \in O(h)  \rightarrow f \in O(min(g,h))$
6. Regla de la suma : Si $f_1 \in O(g) \land f_2 \in O(h) \rightarrow f_1 + f_2 \in O(max(g,h))$
7. Regla del producto : Si $f_1 \in O(g) \land f_2 \in O(h) \rightarrow f_1 * f_2 \in O(g * h)$
8. si $\exists \lim_{n\rightarrow \infin} \frac{f(n)}{g(n)} = k$, segun los valores que tome k:

   i) Si $k \neq 0 \land k < \infin \rightarrow O(f) = O(g)$

   ii) Si $k = 0 \rightarrow f \in O(g) \equiv O(f) \subset O(g)$, pero sin embargo verifica que $g \notin O(f)$

### Funciones de comlejidad temporal comunes

- $O(1)$ **Complejidad constante**
  Es independiente de los datos de entrada

- $O(log n)$ **Complejidad logaritmica**
  Suele aparecer en determinados algoritmos con iteracion o recursion (p.e, busqueda binaria).

Todos los logaritmos, sea cual sea su base, son del mismo orden, pro lo que se representan en cualquier base

- $O(n)$ **Complejidad lineal**
  Suele aparecer en bucles simples cuando la complejidad de las operaciones internas es constante o en algunos algoritmos con recursion

- $O(n log n)$
  En algunos algoritmos "Divide & COnquer" (p.e. Mergesort)

- $O(n^2)$ **Complejidad cuadratica**
  Aparece en bucles o recursiones doblemente anidados

- $O(n^3)$ **Complejidad cubica**
  En bucles o recursiones triples

- $O(n^k)$ **Complejidad polinomica** ($k \geq 1$)

- $O(2^n)$ **Complejidad exponencial**
  Suele aparecer en subprograma recursivos que contengan dos o mas llamadas internas

Notacion: Si f \in O(g) vamos a abusar de la notacion y escribir a veces f = O(g) y decir cosas como "f es O de g" o "f es O grande de g" o "f es del orden de g"

## Cota Inferior - Notacion $\Omega$

La notacion $\Omega$ permite representar el limite o cota inferior del tiempo de ejecucion de un algortimo

La notacion $f \in \Omega(g)$ expresa la funcion _f_ que esta actoada inferiormente por alguna funcion proporcional a _g_.

- A _g_ se le llama cota inferior de _f_

Si para un algoritmo sabemos que $T_{peor} \in \Omega(g)$, se puede asegurar que para inputs de tamaño creciente, el tiempo sera, en el peor caso, al menos proporcional a la cota.

La notacion se usa tmabien para dar cotas inferiores para problemas. A veces se puede decir para un problema que **para cualquier algoritmo que lo resuelva**, $T_{peor} \in \Omega(g)$, lo que significa que cualquier algoritmo que lo resuelva tiene una complejidad, en el peor caso, proporcional a la cota

$f \in \Omega(g)$ significa que _f_ no crece mas que _g_

$$
\Omega(g) = \{f|\exists n_0,k> 0/ n\geq n_0 \rightarrow f(n) \geq k * g(n)\}
$$

Ejemplos:

$$
100n^2 + 300n + 1000 \in \Omega(n^2)
$$

$$
100n^2 + 300n + 1000 \in \Omega(n)
$$

### Cota Inferior

Obtener buenas cotas inferiores **ajustadas** es en general **dificil**, aunque siempre existe una cota inferior trivial para cualquier algoritmo: al menos hay que ller los datos y luego escribirlos, de forma que esa seria una primera cota inferior.

Por ejemplo, para ordeanr n numeros una cota inferiro seria $\Omega(n)$, y para multiplicar dos matrices de orden n seria $\Omega(n2)$;
sin embargo, los mejor algoritmos conocidos son de ordenes $O(n log n)$ y $O(n^{2.8})$ respectivamente.

### Propiedades de $\Omega$

1. Para cualquier funcion _f_ se tiene que $f \in \Omega(f)$
2. $f \in \Omega(g) \rightarrow \Omega(f) \subset \Omega(g)$
3. $\Omega(f) = \Omega(g) \leftrightarrow f \in \Omega(g) \land g \in \Omega(f)$
4. Si $f \in \Omega(g) \land g \in \Omega(h)  \rightarrow f \in \Omega(h)$
5. Si $f \in \Omega(g) \land f \in \Omega(h)  \rightarrow f \in \Omega(max(g,h))$
6. Regla de la suma : Si $f_1 \in \Omega(g) \land f_2 \in \Omega(h) \rightarrow f_1 + f_2 \in \Omega(g+h)$
7. Regla del producto : Si $f_1 \in \Omega(g) \land f_2 \in \Omega(h) \rightarrow f_1 * f_2 \in \Omega(g * h)$
8. si $\exists \lim_{n\rightarrow \infin} \frac{f(n)}{g(n)} = k$, segun los valores que tome k:

   i) Si $k \neq 0 \land k < \infin \rightarrow \Omega(f) = \Omega(g)$

   ii) Si $k = 0 \rightarrow g \in \Omega(f) \equiv \Omega(g) \subset \Omega(f)$, pero sin embargo verifica que $g \notin \Omega(f)$

## Orden exacto - Notacion $\Theta$

- Como ultima cota asintotica, definiremos los conjuntos de funciones que crecen asintoticamente de la misma forma

$$ \Theta(f) = O(f) \cap \Omega(f) $$

- Intuitivamente, $t \in \Theta(f)$ indica que _t_ esta acotada por _f_ tanto superior como inferiormente.

$f \in \Theta(g)$ significa que _f_ crece (a partir de cierto momento) igual que _g_

$$
\Theta(g) = \{f|\exists n_0, k_1, k_2> 0/ n\geq n_0 \rightarrow k_1 * g(n) \leq f(n) \leq k_2 * g(n)\}
$$

### Propiedades de $\Theta$

1. Para cualquier funcion _f_ se tiene que $f \in \Theta(f)$

2. $f \in \Theta(g) \rightarrow \Theta(f) = \Theta(g)$

3. $\Theta(f) = \Theta(g) \leftrightarrow f \in \Theta(g) \land g \in \Theta(f)$

4. Si $f \in \Theta(g) \land g \in \Theta(h)  \rightarrow f \in \Theta(h)$

5. Si $f \in \Theta(g) \land f \in \Theta(h)  \rightarrow f \in \Theta(max(g,h))$

6. Regla de la suma : Si $f_1 \in \Theta(g) \land f_2 \in \Theta(h) \rightarrow f_1 + f_2 \in \Theta(max(g,h)) = \Theta(g+h)$

7. Regla del producto : Si $f_1 \in \Theta(g) \land f_2 \in \Theta(h) \rightarrow f_1 * f_2 \in \Theta(g * h)$

8. si $\exists \lim_{n\rightarrow \infin} \frac{f(n)}{g(n)} = k$, segun los valores que tome k:

   i) Si $k \neq 0 \land k < \infin \rightarrow \Theta(f) = \Theta(g)$

   ii) Si $k = 0 \rightarrow \Theta(f) \neq \Theta(g)$

## Observaciones

La utilizacion de las cotas asintoticas para comparar funciones de tiempo de ejecucion se basa en la hipotesis de que son suficientes para decidir el mejor algoritmo, prescindiendo las constantes de proporcionalidad

Sin embargo, esta hipotesis puede no ser cierte cuando el tamaño de la entrada es pequeño, o cuando las constantes involucradas son demasiado grandes, etc.

## Ultima sobre el tamaño de la entrada

Cual es la complejidad de multiplicar dos enteros?

- Depende de cual sea la medida del tamaño de entrada
- Podria considerarse que todos los enteros tienen tamaño O(1), pero eso no seria util para comparar este tipo de algoritmos

- En este caso, conviene pensar que la mediad es el **logaritmo del numero**

- Si por el contrario estuviesemos analizando algoritmos que ordenan arreglos de enteros, lo que importa no son los enteros en si, sino **cuantos** tengamos

- Entonces, para ese problema, la medida va a decir que todos los enteros miden lo mismo.

## Complejidad de algoritmos recursivos

Como calculamos la complejidad de los algoritmos recursivos?

- Dijimos: "El tiempo de ejecucion de las llamadas a procedimientos recursivos va a dar lugar a ecuaciones en recurrencia, que veremos posteriormente".

Igual podemos pensarlo: Hay que resolver ecuaciones de recurrencia, por ejemplo:

- $T(n) = n + T(n-1)$
