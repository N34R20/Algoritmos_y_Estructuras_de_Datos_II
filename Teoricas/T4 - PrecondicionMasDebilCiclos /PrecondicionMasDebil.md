# Precondicion mas debil de ciclos

## Tripla de Horae

$$\{P\} S \{Q\}$$

dada una tripla de Horae es **valida** si:

1. El programa S comienza en un estado que cumple P
2. Termina luego de un numero finito de pasos
3. Y termina en un estado que cumple Q

## Lenguaje SmallLang

Definimos un lenguaje imperativo basado en **variables** y las instrucciones:

1. **Nada**: Instruccion **skip** no hace nada.
2. **Asignacion**: Instruccion **x:=E**

Ademas tenemos las siguientes estructuras de control:

1. **Secuencia**: **S1; S2** es un programa, si **S1** y **S2** son dos programas

2. **Condicional**: **if B then S1 else S2 endif** es un programa, si B es una expresion logica y S1 y S2 son dos programas

3. **Ciclo**: while B d S endwhile es un programa, si B es una expresion logica y S un programa

## Precondicion mas debil

- Definicion: la precondicion mas debil de un programa S respecto de una postcondicion Q es el predicado P mas debil posible tal que $\{P\} S \{Q\}$

- Notacion: wp(S,Q)

- Teorema: decimo que $\{P\} S \{Q\}$ es valida si $$P \rightarrow_L wp(S,Q)$$

## Axiomas wp

- Axioma 1: $$wp(x := E, Q) \equiv def(E) \land_L Q_E^{x}$$
- Axioma 2: $$wp(skip, Q) \equiv Q$$
- Axioma 3: $$wp(S1; S2, Q) \equiv wp(S1, wp(S2,Q))$$
- Axioma 4: $$wp(if B then S1 else S2 endif, Q) \equiv def(B) \land_l (B \land wp(S1, Q)) \lor (\neg B \land wp(S2, Q))$$

- Observacion: $$wp(b[i]:=E, Q) \equiv wp(b:=setAt(b, i, E), Q)$$

## Ciclos

- Sintaxis de un ciclo:

```
while (guarda B) {
    cuerpo del ciclo S
}
```

Se repite el cuerpo del ciclo S mientras la **guarda** B se cumpla, cero o mas veces. Cada repeticion se llama una **iteracion**

La ejecucion del ciclo termina si no se cumple la guarda al comienso de su ejecucion o bien luego de ejecutar una iteracion

Si cuando el ciclo termina, el estaod resultante es el estado posterior a la ultima instruccion del cuerpo del ciclo

## Precondicion mas debil de un ciclo

- Supongamos que tenemos el ciclo **while B do S endwhile**

- **Definicion:** Definimos $H_k(Q)$ como el predicado que define el conjunto de estados a partir de los cuales la ejecucion del ciclo termina en **exactamente** k iteraciones, satisfaciendo Q:

$$H_0(Q) \equiv def(B) \land \neg B \land Q,$$

$$H_{k+1}(Q) \equiv def(B) \land \neg B \land wp(S, H_k(Q))$$

para $k\geq 0.$

- **Propiedad:** Si el ciclo realiza a lo sumo k iteraciones, entonces

$$wp(while B do S endwhile, Q) \equiv V_{i=0}^{k} H_i(Q)$$

### Ejemplo

- **Intuitivamente**: wp(while B do S endwhile, Q) tiene que ser una formula logica capaz de capturar todos los estados tales que, luego de ejecutar el ciclo una cantidad arbitraria de veces, vale Q.

- **Axioma 5**:
  wp(while B do S endwhile, Q) $\equiv (\exists_{i\geq 0})(H_i (Q))$

- Trataremos de usar el Axioma 5

_wp(while B do S endwhile, Q)_

$$\equiv (\exists_{i\geq 0})(H_i (Q))$$

$$\equiv H_0 (Q) \lor H_1 (Q) \lor H_2 (Q) ...$$

$$\equiv \lor_{i=0}^{\infin} (H_i (Q))$$

**ES UNA FORMULA INFINITA!**

Por lo tanto, no podemos usar mecanicamente el **Axioma 5** para demostrar la correccion de un ciclo con una cantidad no
acotada **a priori** de iteraciones :(

## Invariante de un ciclo

**Definicion**: Un predicado _I_ es un invariante de un ciclo si:

1. _l_ vale antes de comenzar el ciclo
2. si vale $I \land B$ al comenzar una iteracion arbitraria, entonces
   sigue valiendo _I_ al finalizar la ejecucion del cuerpo del ciclo.

- Un invariante describe un estado que se satisface cada vez que comienza la ejecucion del cuerpo
  de un ciclo y tambien se cumple cuando la ejecucion del cuerpo del ciclo concluye

- Ejemplo:

## Teorema del invariante

- Si existe un predicado _I_ tal que :

1. $P_C \rightarrow I$

1. $\{I\land B\} S \{I\}$

1. $I \land \neg B \rightarrow Q_C$

entonces el ciclo **while(B) S** es parcialmente correcto respecto de la especificacion ($P_C, Q_C$),
Osea, la siguiente tripla de Horae es valida:

$\{P_C\}$ **while B do S endwhile** $\{Q_C\}$

- Las condiciones 1-3 garantizan la **correccion parcial** del ciclo
  (la hipotesis de terminacion es necesaria para garantizar correccion)

- Este teorema es la herramienta principal para ragumentar la correccion de ciclos.

### Ejemplo

## Teorema de terminacion de un ciclo

- **Teorema**: Sea $\mathbb{V}$ el producto cartesiano de los dominios de las variables del programa y sea _I_ un
  invariante del ciclo **while B do S endwhile**. Si existe una funcion $f_v : \mathbb{V} \rightarrow \mathbb{Z}$ tal que

1. $\{I \land B \land v_0 = f_v\} S \{f_v < v_0\}$
2. $I \land f_v \leq 0 \rightarrow \neg B$

... entonces la ejecucion del ciclo **while B do S endwhile** termina siempre.

- La funcion $f_v$ se llama **funcion variante** del ciclo.

- El teorema de terminacion nos permite demostrar que un ciclo termina (i.e. no se cuelga)

### Ejemplo: Suma de indices

### Ejemplo: Chequeo de paridad

## Teorema de correccion de un ciclo

- **Teorema** Sean un predicado _I_ y una funcion $f_v : \mathbb{V} \rightarrow \mathbb{Z}$
  (donde $\mathbb{V}$ es el producto cartesiano de los dominios de las variables del programa),
  y supongamos que $I \rightarrow def(B)$. Si

1. $P_C \rightarrow I$
2. $\{I\land B\} S \{I\}$
3. $I \land \neg B \rightarrow Q_C$
4. $\{I \land B \land v_0 = f_v\} S \{f_v < v_0\}$
5. $I \land f_v \leq 0 \rightarrow \neg B$

... entonces la siguiente tripla de Hora es valida:

$\{P_C\}$ **while B do S endwhile** $\{Q_C\}$

Por definicion, si probamos que $\{P_C\}$ **while B do S endwhile** $\{Q_C\}$

... entonces probamos que:

$P_C \rightarrow$ wp(**while B do S endwhile**, $Q_C$)

CUIDADO

Programas con ciclos

- En general, no se puede definir un **mecanismo efectivo** para obtener una formula cerrada que represente
  la precondicion mas debil de un ciclo

- Entonces, como hacemos para probar la correccion y terminacion de un programa que
  **incluye** ciclos intercalados con otras instrucciones?

## Guia para demostrar programas con ciclos

Que tenemos que hacer para probar que $\{Pre\}$ S1; while ... S3 $\{Post\}$ es valida?

1. $Pre \rightarrow_L wp(S1,P_C)$
2. $P_C \rightarrow_L wp(while.., Q_C)$
3. $Q_C \rightarrow_L wp(S3, Post)$

Por monotonia, esto nos permite demostrar que $Pre \rightarrow_L wp(S1; while ... ; S3, Post)$ es verdadera.
