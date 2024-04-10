# Repaso de Logica proposicional

verificacion de programas -> logica de primer orden

## Porque estudiar logica

- usar logica en especificaciones
- usar logica en nuestros programas
- lenguajes para modelar situaciones
- poder razonar y argumentar
- hacerlo formalmente
- entender sobre la computacion y sus raices

## Logica proposicional (PROP) - sintaxis

Simbolos:

$$ \neg, \vee, \wedge, \rightarrow, \leftrightarrow , (, )$$

Variables propocisionales (infinitas):

$$ p, q, r, ... $$

Formulas

1. cualquer variable proposicional es una formula
2. si $\phi$ es una formula, $(\neg \phi)$ es una formula
3. si $\phi$ y $\psi$ son formulas, $(\phi \wedge \psi)$ es una formula
4. si $\phi$ y $\psi$ son formulas, $(\phi \vee \psi)$ es una formula
5. si $\phi$ y $\psi$ son formulas, $(\phi \rightarrow \psi)$ es una formula
6. si $\phi$ y $\psi$ son formulas, $(\phi \leftrightarrow \psi)$ es una formula

#### Nota al pie

(las formulas son un ejemplo de conjunto inductivo)

vienen provistos de - Esquema de prueba para probar propiedades sobre ellos (induccion estructural) - Esquema de recursion para definir funciones sobre el conjunto (recursion estructural)

## Semantica Clasica

Consiste en asignarle **valores de verdad** a las formulas
El conjunto de valores de verdad es **{T, F}**
Dos enfoques para darle semantica a las formulas de PROP

1. Tablas de verdad
2. Valuaciones

Son equivalentes

### Tablas de verdad

Conociendo el valor de las variables proposicionales de una formula, conocemos el valor de verdad de la formula

| $\phi$ | $(\neg\phi)$ |
| ------ | ------------ |
| **T**  | **F**        |
| **F**  | **T**        |

| $\phi$ | $\psi$ | $(\phi \wedge \psi)$ |
| ------ | ------ | -------------------- |
| **T**  | **T**  | **T**                |
| **T**  | **F**  | **F**                |
| **F**  | **T**  | **F**                |
| **F**  | **F**  | **F**                |

| $\phi$ | $\psi$ | $(\phi \vee \psi)$ |
| ------ | ------ | ------------------ |
| **T**  | **T**  | **T**              |
| **T**  | **F**  | **T**              |
| **F**  | **T**  | **T**              |
| **F**  | **F**  | **F**              |

| $\phi$ | $\psi$ | $(\phi \rightarrow \psi)$ |
| ------ | ------ | ------------------------- |
| **T**  | **T**  | **T**                     |
| **T**  | **F**  | **F**                     |
| **F**  | **T**  | **T**                     |
| **F**  | **F**  | **T**                     |

| $\phi$ | $\psi$ | $(\phi \leftrightarrow \psi)$ |
| ------ | ------ | ----------------------------- |
| **T**  | **T**  | **T**                         |
| **T**  | **F**  | **F**                         |
| **F**  | **T**  | **F**                         |
| **F**  | **F**  | **T**                         |

### Ejemplo: tabla de verdad para $((p \wedge q)\rightarrow r)$

| $p$   | $q$   | $r$   | $(p \wedge q)$ | $((p \wedge q) \rightarrow r)$ |
| ----- | ----- | ----- | -------------- | ------------------------------ |
| **T** | **T** | **T** | **T**          | **T**                          |
| **T** | **T** | **F** | **T**          | **F**                          |
| **T** | **F** | **T** | **F**          | **T**                          |
| **T** | **F** | **F** | **F**          | **T**                          |
| **F** | **T** | **T** | **F**          | **T**                          |
| **F** | **T** | **F** | **F**          | **T**                          |
| **F** | **F** | **T** | **F**          | **T**                          |
| **F** | **F** | **F** | **F**          | **T**                          |

### Ejemplo

Escribir la siguente frase como una formula de logica proposicional

"Si Juan esta cursando y no conoce a nadie entonces Juan todavia no tiene grupo"

- Solucion 1:

p = Juan esta cursando
q = Juano no conoce a nadie
r = Juan no tiene grupo

$$ (p \wedge q) \rightarrow r $$

- Solucion 1:

p = Juan esta cursando
q = Juano conoce a nadie
r = Juan tiene grupo

$$ (p \wedge \neg q) \rightarrow \neg r $$

## Valuaciones

Una valuacion es una funcion $v: \mathcal{V}\rightarrow {T, F}$ que asigna valores de verdad a las variables proposicionales

Una valuacion satisface una proposicion $\phi$ si v $\models \phi$ donde:

$v \models p$ si $v(p) = T$

$v \models \neg \phi$ sii $v\nvDash \phi$ (i.e. no $v \models \phi)$

$v \models \vee \phi$ sii $v \models \phi$ o $v \models \phi$

$v \models \wedge \phi$ sii $v \models \phi$ y $v \models \phi$

$v \models \phi \rightarrow \psi$ sii $v \nvDash \phi$ o $v \models \psi$

$v \models \phi \leftrightarrow \psi$ sii ($v \models \phi$ sii $v \models \psi$)

## Tautologias y satisfacibilidad

Dadas formulas $\phi$ y $\psi$

- $\phi$ es **logicamente equivalente** a $\psi$ cuando $v \models \phi$ sii $v \models \psi$

Una formula $\phi$ es

- una **tautologia** si $v \models \psi$ sii para toda valuacion v
- **satisfacible** si existe una valuacion v tal que $v \models \phi$
- **insatisfactible** si no es satisfactible

Un conjunto $S$ es

- **satisfacible** si existe una valuacion v tal que $\forall \phi \in S$, se tiene $v \models \phi$
- **insatisfactible** si no es satisfactible

### Ejemplos

**Tautologias**

- $p \rightarrow p$
- $\neg \neg p \rightarrow p$
- $(p \rightarrow q) \leftrightarrow (\neg q \rightarrow \neg p)$

**Formulas insatisfacibles**

- $(\neg p \vee q) \wedge (\neg p \vee \neg q) \wedge p$
- $(p \rightarrow q) \wedge p \wedge \neg q$

## Tautologias e insatisfacibilidad

#### Teorema

Una formula $\phi$ es una tautologia sii $\neg \phi$ es insatisfactible

#### Demostracion

$\rightarrow$ Si $\phi$ es tautologia, para toda valuacion $v$, $v \models \phi$. Entonces, $v \not\models \neg \phi$ (i.e. v no satisface $\neg \phi$)

$\leftarrow$ Si $\neg \phi$ es insatisfacible, para toda valuacion $v$, $v \not\models \neg \phi$. Luego $v \models \phi$

#### Observacion

Este resultado sugiere un metodo **indirecto** para probar que una formula $\phi$ es una tautologia, que es probar que $\neg\phi$ es **insatisfacible**

## Relacion entre tablas de verdad y valuaciones

## Semantica trivaluada

Supongamos que contamos con un simbolo relacional == que nos permite comparar numeros reales

- Valor de verdad de las siguientes formulas?

1==1
(1+1) == 2
0,5 == 2/4

y esta?
1/0 == 2

Pasos para determinar $e_1 == e_2$ es verdadero o falso

1. Obtener el numero real $r_1$ denotado por $e_1$
2. Obtener el numero real $r_2$ denotado por $e_2$
3. Comparar $r_1$ con $r_2$ para determinar si son iguales o no

Consideremos
$$1/0 == 2$$

- Trabado en paso 1
- Expersion 1/0 no denota **nigun** valor
- 1/0 == 2 no es ni verdadera ni falsa porque no contamos con los numeros a comparar
- Le damos un valore especial: $\bot$(**indefinido**)

## Semantica trivaluada (secuencial)

Se llama secuencial porque ...

- los terminos se evaluan de izquierda a derecha
- la evaluacion termina cuando se puede deducir el valor de verdad, aunque el resto este inefinido

Introducimos los operadores logicos $\wedge_L$ (y-luego, o _conditional and_, o **cand**), $\vee_L$ (o-luego o_conditional or, o **cor**)
