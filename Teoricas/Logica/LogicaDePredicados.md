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

- que dice el siguiente predicado?

- Todos los ennteros entre 1 y 10 son pares:
  $$ (\forall n: \Z)(1 \leq n \leq 10 \rightarrow n (mod 2)=0) $$

- Existe un entero entre 1 y 10 que es par:
  $$ (\exists n: \Z)(1 \leq n \leq 10 \land n (mod 2)=0) $$

- En general, si queremos decir que todos los enteros $x$ que cumplen $P(x)$ tambien cumplen $Q(x)$, decimos:
  $$ (\forall x: \Z)(P(x) \rightarrow Q(x)) $$

- Para decir que existe un entero que cumple $P(x)$ y que tambien cumple $Q(x)$, decimos:
  $$ (\exists x: \Z)(P(x) \land Q(x)) $$

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

Dado un lenguaje de primer orden , una **estructura para $\mathcal{L}$**, $\mathcal{M}$, es un par

$$ \mathcal{M} = (M,I)$$

donde

- M (**universo**) es un conjunto no vacio.
- I (**funcion de interpretacion**) asigna funciones y predicados sobre M a simbolos de $\mathcal{L}$ de la siguiente manera:

  1. Para toda constante $ c, I(c) \in M$
  2. Para todo $f$ de aridad $ n > 0, I(f): M^n \rightarrow M$
  3. Para todo predicado P de aridad $ n \geq 0 I(P) \subseteq M^n $
  4. $I(\doteq)$ es la relacion de identidad sobre M

## Asignacion

Sea $\mathcal{M}$ una estructura para $\mathcal{L}$. Una **asignacion** es una funcion $s:\mathcal{V} \rightarrow M $

Dado $s$ podemos definir $\^{s}$ que se puede aplicar a terminos para obtener el individuo del universo que denota

### Extension de una asignacion a terminos

$$ \^{s}(x) \overset{def}{=} s(x) $$

$$ \^{s}(x) \overset{def}{=} I(c) $$

$$ \^{s}(f(t_1, ..., t_n)) \overset{def}{=} I(f)(\^{s}(t_1), ..., \^{s}(t_n)) $$

Nota: a veces abusamos de la notacion y escribimos simplemente $s$ en lugar de $\^{s}$

## Satisfacibilidad

La relacion $s \models_\mathcal{M} \phi$ establece que la asignacion $s$ satisface la formula $\phi$ en la estructura $\mathcal{M}$

- Vamos a definir la relacion $s \models_\mathcal{M} \phi$ de manera formal usando induccion estructural en $\phi$

- Si $s$ es una asignacion y $a \in M$, usamos la notacion $s[x \leftarrow a]$ para denotar la asignacion que se comporta igual que $s$ salvo en el elemnto $x$, en cuyo caso retorna $a$

## Validez

- Una formula $\phi$ es **satisfacible en $\mathcal{M}$** si existe una asignacion $s$ tal que

$$s\models_{\mathcal{M}} \phi$$

- Una formula $\phi$ es **satisfacible** si existe un $\mathcal{M}$ tal que $\phi$ es satisfacible en $\mathcal{M}$. En caso contrario se dice que $\phi$ es **insatisfacible**

-

-

- **Nota:** $\phi$ es valida si $\neg \phi$ es insatisfacible

## Ejemplo de formulas validas

## Resumen de PRED

- Sintaxis

  - Lenguaje de primer orden $\mathcal{L}$
  - Terminos sobre $\mathcal{L}$ (denotan individuos)
  - Formulas sobre $\mathcal{L}$ (denotan valores de verdad)

- Semantica
  - Estructuras: universo + interpretacion de los simbolos de $\mathcal{L}$
