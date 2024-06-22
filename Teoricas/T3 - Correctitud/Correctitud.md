# Correctitud

## Transformacion de estados

Llamamos **estado** de un programa a los valores de todas sus variables en un punto de ejecucion:

1. Antes de ejecutar la primera instruccion
2. entre dos instrucciones
3. despues de ejecutar la ultima instruccion

Podemos considerar la **ejecucion** de un programa como una **sucesion de estados**

La asignacion es la intruccion que permite pasar de un estado al siguiente en esta sucesion de estados

Las estructuras de control se limitan a especificar el flujo de ejecucion (es decir, el orden de ejecucion de las asignaciones)

## Afirmacion sobre estados

- Sea el siguiente programa que se ejecuta con estado inicial {True}

```
{True}
int x = 0;
{x = 0}
x = x + 3;
{x = 3}
x = x \* 2;
{x = 6}
```

- Finaliza siempre el programa? Si, porque no hay ciclos
- Cual es el estado final al finalizar su ejecucion? {x = 6}

## Correccion de un programa

- **Definicion:** Decimos que un programa S es **correcto respecto de una especificaicon** dada por una precondicion P y una postcondicion Q, si siempre que el programa comienza en un estado que cumple P. el programa **termina su ejecucion**, y en el esatdo final **se cumple** Q.

- **Notacion:** Cuando S es correcto respecto de la especificacion (P,Q), lo denotamos con la siguiente **tripla de Hoare**:

$$ \{P\} S \{Q\}$$

## Intercambiando los valores de dos variables enteras

## Alternativas

## Demostrando que un programa es correcto

- Sabemos razonar sobre la correcion de nuestros programas, anotando el codigo con predicados que representan los estados.

- Nos interesa formalizar estos razonamientos, para estar seguros de que no cometimos errores en la demostracion.

- Una forma de conseguirlo es la siguiente: A partir de la tripla de Horae $\{P\} S \{Q\}$, obterner una formula logica $\alpha$ tal que

  $\alpha$ es verdadera si y solo si $\{P\} S \{Q\}$ es verdadera.

- Entre otras cosas, esto nos permite automatizar la demostracion con un **verificador automatico** (!)

## Un lenguaje imperativo simplificado

Para facilitar nuestro trabajo, definamos un lenguaje imperativo mas sencillo que Java al que llamaremos **SmallLang**

SmallLang unicamente soporta las siguientes instrucciones:

1. Nada: Instruccion **skip** que no hace nada
2. Asignacion: Instruccion **x := E**

- Ademas soporta las siguientes estructuras de control

1. **Secuencia**: S1; S2 es un programa, si S1 y S2 son dos programas.
2. **Condicional**: if B then S1 else S2 endif es un programa, si B es una expresion logica y S1 y S2 son dos programas.
3. **Ciclo**: while B do S enwhile es un programa, si B es una expresion logica y S es un programa.

## La precondicion mas debil

- **Definicion:** La **precondicion mas debil** de un programa S respecto de una postcondicion Q es el predicado P mas debil posible tal que $\{P\} S \{Q\}$

- **Notaion:** wp(S,Q)

- **Teorema:** Una tripla de Hoare $\{P\} S \{Q\}$ es valida si y solo si:

$$P \rightarrow_L wp(S,Q)$$

- Si para demostrar la validez de $\{P\} S \{Q\}$ nos alcanza con probar la formula
  $$P \rightarrow_L wp(S,Q)$$

- Entonces lo que necesitamos un mecanismo para obtener la wp de (S,Q)

- Afortunadamente, existe un conjunto de **axiomas** que podemos usar para obtener la wp

- Antes de empezar a ver los axiomas, definamos primero dos predicados: $def(E)$ y $Q_{E}^x$

## Predicado def(E)

- **Definicion**: Dada una expreison E, llamamos def(E) a las condiciones necesarias para que E este **definida**. Por ejemplo:

1. $def(x+y) \equiv def(x) \land def(y)$
2. $def(x/y) \equiv def(x) \land (def(y) \land_L y \neq 0)$
3. $def(\sqrt x) \equiv def(x) \land_L x \geq 0$
4. $def(a[i] + 3) \equiv (def(a) \land def(i)) \land_L 0 \leq i < |a|$

- Suponemos $def(x) \equiv True$ para todas las variables, para simplificar la notacion.

- Con esta hipotesis extra:

1. $def(x+y) \equiv True$
2. $def(x/y) \equiv y \neq 0$
3. $def(\sqrt x) \equiv  x \geq 0$
4. $def(a[i] + 3) \equiv 0 \leq i < |a|$

## Predicado $Q_{E}^x$

- **Definicion**: Dado un predicado Q, el predicado $Q_{E}^x$ se obtiene reemplazando en Q todas las apariciones **libres** de la variable x por E.

1. $Q \equiv 0 \leq i < j < n \land_L a[i] \leq x < a[j]$

   $Q_{k}^{i} \equiv 0 \leq k < j < n \land_L a[k] \leq x < a[j]$

   $Q_{i+1}^{i} \equiv 0 \leq i +1 < j < n \land_L a[i+1] \leq x < a[j]$

2. $Q \equiv 0 \leq i < n \land_L (\forall j: \Z) (a[j] = x)$

   $Q_{k}^{j} \equiv 0 \leq i < n \land_L (\forall j: \Z) (a[j] = x)$

## Axiomas

### Axioma 1: asignacion

- $ wp(x := E, Q) \equiv def(E) \land*L$ $Q*{E}^{x} $

- Ejemplo:

  {??}

  x:= x + 1

  {Q: x \geq}

### Axioma 2

### Axioma 3

## Asignacion a elementos de una secuencia

## Propiedades

## Corolario de la monotonia
