# Logica de Predicados

## Predicados

Considerar la frase

_Todo estudiante es mas joven que algun profesor_

En PROP lo representariamos con una variable proposicional p

- Se pierde informacion sobre la estructura logica de la frase
  - ser estudiante
  - ser profesor
  - ser mas joven que

## Individuos, predicados, variables y cuantificadores

_Todo estudiante es mas joven que algun profesor_

$$
\forall x (E(x) \rightarrow (\exists y (P(y) \wedge J(x,y))))
$$

- Individuos (entidad distinta e indivisible):

  - Estudiantes y profesores
  - Denotados por las variables x e y

- Predicados (predican sobre individuos)

  - E(x): x es estudiante
  - P(x): x es profesor
  - J(x,y): x es mas joven que y

- Cuantificadores
  - $\forall$: Para todo
  - $\exists$: Existe (para algun)

## Funciones

_Toda persona es menor que su madre biologica_

- G(x): x es persona

- M(y,x): y es la madre de x

$$
\forall x . \forall y. (G(x) \wedge M(y,x)  \rightarrow J(x,y))
$$

Funciones:

- Permiten representar objetos de manera mas directa
- En lugar de escribir M(y,x) podemos denotar a y con m(x)

$$
\forall x . (G(x) \rightarrow J(x,m(x)))
$$

Otro ejemplo: _Andrea y Pedro tienen la misma abuela materna_

$$
m(m(andrea)) = m(m(pedro))
$$

## Terminos y formulas

La logica de predicados habla sobre dos clases de cosas:

- Individuos: Personas, numeros, colores, bolitas, grafos, arboles, etc

  - Las expresiones que denotan individuos se llaman **terminos**
  - Ej: las variables
  - Ej: Constantes como _andrea_ y expresiones como _m(andrea)_

- Valores de verdad
  - Las expresiones que denotan valores de verdad se llaman **formulas**
  - Ej: J(x,y)

## Cuantificadores

- $(\forall x)P(x)$: Formula logica. Afirma que **todos** los elementos cumplen la propiedad P.
  - #### se lee "para todo x se cumple P(x)"
- $(\exists x)P(x)$: Formula logica. Afirma que **al menos un** elemento cumple la propiedad P.
  - #### se lee "existe al menos un x cumple P(x)"

## Cuantificadores tipados

_Syntax sugar_ para nuestro lenguaje de especificacion vamos a aplicar cuantificadores a elementos de un tipo de datos.

- $(\forall x: T)P(x)$: Formula logica. Afirma que **todos** los elementos de tipo T cumplen la propiedad P.
  - #### se lee "para todo x de tipo T se cumple P(x)"
- $(\exists x: T)P(x)$: Formula logica. Afirma que **al menos un** elemento de tipo T cumple la propiedad P.
  - #### se lee "existe al menos un x de tipo T que cumple P(x)"

## Ejemplos

-

$$ $$

## Algunas reglas de deduccion

- La **negacion** de un cuantificador universal es un cuantificador existencial, y viceversa

$$ \neg (\forall n)P(n) \leftrightarrow (\exists n)\neg P(n) $$
$$ \neg (\exists n)P(n) \leftrightarrow (\forall n)\neg P(n) $$

- Un cuantificador universal **generaliza la conjuncion**:

$$(\forall n: \Z)(P(n)) \leftrightarrow P(1) \wedge P(2) \wedge P(3) \wedge ...$$

- Un cuantificador existencial **generaliza la disyuncion**:

$$(\exists n: \Z)(P(n)) \leftrightarrow P(1) \vee P(2) \vee P(3) \vee ...$$

# Sintaxis de PRED

## Lenguaje de primer orden

Un **lenguaje de primer orden** (LPO) $L$ consiste en:

1. Un conjunto $F$ de **simbolos de funcion** cada uno con aridad (Aridad=Numero de argumentos que toman)
   $ n > 0: f_0, f_1, ..., f_k $
2. Un conjunto numerable $C$ de **constantes** $c_0,c_1,...$
3. Un conjunto $P$ de **simbolos de predicado** cada uno con aridad $ n >= 0: P_0,P_1,...,P_m, $

Ejemplo: Lenguaje de primer orden para la aritmetica
Simbolos de funcion: S,+,\*; Constantes: 0, Simbolos de predicado: =, <.

## Terminos de primer orden

Sea $ V =$ {$x_0, x_1, ...$} un conjunto numerable de variables y $L$ un LPO. El conjunto de **L-terminos** se define inductivamente como:

1. Toda constante de $L$ y toda variable es un $L$-termino
2. Si $t_1,...,t_n \isin L$-terminos y _f_ es un simbolo de funcion de aridad _n_, entonces $f(t_1,...,t_n) \isin L$-terminos

En notacion abreviada:

$$ t :::= c |x| f(t,...,t)$$

## Formulas atomicas

Sea $ V =$ {$x_0, x_1, ...$} un conjunto numerable de variables y $L$ un LPO. El conjunto de **L-formulas atomicas** se define inductivamente como:

1. Todo simbolo de predicado de aridad 0 es una $L$-formula atomica
2. Si $t_1,...,t_n \isin L$-terminos y P es un simbolo de predicado de aridad n, entonces $P(t_1,...,t_n)$ es un $L$-formula atomica.
   Por ejemplo: si $t_1,t_2 \isin L$-terminos, entonces $t_1 = t_2$ es una $L$-formula atomica.

## Formulas de primer orden

Sea $ V =$ {$x_0, x_1, ...$} un conjunto numerable de variables y $L$ un LPO. El conjunto de **L-formulas** se define inductivamente como:

1. Toda L-formula atomica es un L-formula
2. si $\phi,\psi \isin L$-formulas, entonces

   $(\phi \wedge \psi),(\phi \wedge \psi),(\phi \rightarrow \psi),(\phi \leftrightarrow \psi) y (\neg \phi)$ son L-formulas

3. Para toda variable $x_i$ y cualquier $L$-formula $\phi, (\forall x_i. \phi)$ y $(\exists x_i . \phi)$ son L-formulas

## Variables libres y ligadas

- Una ocurrencia de x en $\phi$ es ligada si x ocurre en un subtermino de la forma $\forall x. \psi$ o $\exists x. \psi$
- Una ocurrencia es libre si no es ligada.
- Una variable es libre (ligada) en una formula si ocurre libre (ligada) en la formula

Ejemplo:
$$P(x) \wedge \forall x.(R(x,y) \rightarrow \exists z.P(z))$$

- y es libre
- z es ligada
- x es libre y ligada

- Usamos $FV(\phi)$ y $BV(\phi)$ para referirnos al conjunto de las variables libre y ligadas de $\phi$, respectivamente (Free y Bounded)
- $FV(\phi)$ y $BV(\phi)$ se pueden definir por induccion estructural en $\phi$

Ejemplo:
Si $\phi = \forall x. (R(x,y) \rightarrow P(X))$, entonces $FV(\phi)$ = {y} y $BV(\phi)$ = {x}

# Semantica de PRED

## Estructura de primer orden

## Asignacion

## Satisfacibilidad

## Validez

## Ejemplo de formulas validas

## Resumen de PRED
