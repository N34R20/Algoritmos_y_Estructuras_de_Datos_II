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

**Definicion**: Un predicado _l_ es un invariante de un ciclo si:

1. _l_ vale antes de comenzar el ciclo
2. si vale $l \land B$ al comenzar una iteracion arbitraria, entonces
   sigue valiendo _l_ al finalizar la ejecucion del cuerpo del ciclo.

- Un invariante describe un estado que se satisface cada vez que comienza la ejecucion del cuerpo
  de un ciclo y tambien se cumple cuando la ejecucion del cuerpo del ciclo concluye

- Ejemplo:

## Teorema del invariante

- Si existe un predicado _l_ tal que :

1. $P_C \rightarrow l$

1. $\{l\land B\} S \{l\}$

1. $l \land \neg B \rightarrow Q_C$

entonces el ciclo **while(B) S** es parcialmente correcto respecto de la especificacion ($P_C, Q_C$)

- Este teorema es la herramienta principal para ragumentar la correccion de ciclos.

### Ejemplo
