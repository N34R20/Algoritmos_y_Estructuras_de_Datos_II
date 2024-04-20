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

## Predicado def(E)

## Predicado $Q_{E}^x$

## Axiomas

### Axioma 1

### Axioma 2

### Axioma 3

## Asigancion a elementos de una secuencia

## Propiedades

## Corolario de la monotonia
