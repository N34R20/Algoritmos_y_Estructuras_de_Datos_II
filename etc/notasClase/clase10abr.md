Proc \_\_():

    Requiere {P}
    Asegura {Q}

SmalLang

Template:

proc $nombrePrograma$(in $x :\Z$): $\Z$ {

requiere {$P$}

asegura {$Q$}

}

proc $siete$(in $x :\Z$): $\Z$ {

requiere {$P$}

asegura {$res = 7$}

}

$S_0, res := 7$

$P = True$ (es la precondicion mas debil mas debil de todas)

Si logramos encontrar la precondicion mas debil para que el programa sea correcto $\rightarrow$ todas las precondiciones mas fuertes van a ser correctas

$P = n > 0$

otro programa

$S_1, res := 7 * \frac{n}{n}$

$P \neq 0$

$P > 0$

Encontrar la precondicion mas debil que haga valida la postcondicion.

$S_3, res := abs(n)$

$P$ = {$n = 7 \vee n = -1$}

$P > 0$

la veracidad de una implica a la otra

{$n = 7$} $\rightarrow$ {$n=7 \vee n=-7$}

3 axiomas para hacer los ejercicios de la guia

- $Ax_1$: $Asignacion$:

  - $wp(x:= E, Q) \equiv def(E)\wedge_L Q_E^x$

- $Ax_2$ $Skip$:

  - $wp(Skip, Q) \equiv Q$

- $Ax_3$ $Composicion$:
  - $wp(S_1, S_2, Q) \equiv wp(S_1, wp(S_2, Q))$
