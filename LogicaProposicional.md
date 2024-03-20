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

Una valuacion satisface una proposicion $ \phi $ si v $\models \phi $ donde:

$v \models p $ si $ v(p) = T$

$v \models \neg \phi $ sii $ v\nvDash \phi $ (i.e. no $ v \models \phi)$

$v \models \vee \phi $ sii $ v \models \phi $ o $ v \models \phi$

$v \models \wedge \phi $ sii $ v \models \phi $ y $ v \models \phi$

$v \models \phi \rightarrow \psi$ sii $ v \nvDash \phi $ o $ \models \psi$

$v \models \phi \leftrightarrow \psi$ sii ($ v \models \phi $ sii $ c \models \psi$)

## Tautologias y satisfacibilidad

## Relacion entre tabals de verdad y valuaciones

## Semantica trivaluada

## Semantica trivaluada (secuencial)
