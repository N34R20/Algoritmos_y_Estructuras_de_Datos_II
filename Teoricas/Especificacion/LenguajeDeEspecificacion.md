# Lenguaje de especiﬁcacion

## Definicion (Especificacion) de un problema

proc nombre(parametros): salida {

requiere { P }

asegura { Q }

}

- P y Q son predicados, denominados la **precondicion** y la **postcondicion** del **procedimiento**.

- nombre: nombre que le damos a un problema

  - sera resuelto por una funcion con ese mismo nombre

- parametros: lista de parametros separada por comas, donde cada parametro contiene:

  - Tipo de pasaje (entrada, salida o entrada/salida)
  - Nombre del parametro
  - Tipo de datos del parametro

- salida: Opcional. Tipo de dato de la salida

### Ejemplos

proc $raizCuadrada$(in $x :\R$): $\R$ {

requiere {x > 0}

asegura {$result * result = x \wedge result > 0$}

}

proc $sumar$(in $x :\Z$, in $y :\Z$): $\Z$ {

requiere {$True$}

asegura {$result = x + y$}

}

proc $restar$(in $x :\Z$, in $y :\Z$): $\Z$ {

requiere {$True$}

asegura {$result = x - y$}

}

proc $cualquieraMayor$(in $x :\Z$): $\Z$ {

requiere {$True$}

asegura {$result > x$}

}

## El contrato

- **Contrato**: El programador escribe un programa P tal que si el usuario suministra datos que hacen verdadera la precondicion, entonces P termina en una cantidad ﬁnita de pasos retornando un valor que hace verdadera la postcondicion

- El programa P es **correcto** para la especificacion dada por la precondicion y la postcondicion exactamente cuando se cumple el contrato

- Si el usuario no cumple con la precondicion y P se cuelga o no cumple la postcondicion...
  - el usuario tiene derecho a quejarse?
  - Se cumple el contrato?

## Interpretando una especificacion

proc $raizCuadrada$(in $x :\R$): $\R$ {

requiere {$x \geq 0$}

asegura {$result * result = x \wedge result \geq 0$}

}

- Que significa esta especificacion?

- Se especifica que si el programa $raizCuadrada$ se comienza a ejecutar en un estado que cumple $x \geq 0$, entonces el programa **termina** y el estado final cumple $result * result = x$ y $result \geq 0$.

## Pasaje de paramteros

- Parametros de entrada (**in**): Si se invoca el procedimiento con el argumento **c** para un parametro de este tipo, entonces se copia el valor **c** antes de iniciar la ejecucion.

- Parametros de salida (**out**): Al finalizar la ejecucion del procedimiento se copia el valor al parametro pasado. No se inicializa, y no se puede hablar de estos parametros en la precondicion.

- Parametros de entrada-salida (**inout**): Es un parametro que es a la vez de entrada (se copia el avlor del argumento al inicio), como de salida (se copia el valor de la variable al argumento). El efecto final es que la ejecucion del procedimiento **modifica** el valor del parametro.

- Todos lo parametros con atributo **in** (incluos **inout**) estan inicializados

## Argumentos que se modifican (inout)

#### Problema: Incrementar en 1 el argumento de entrada

- Alternativa sin modificar la entrada (usual)

- Alternativa que modifica la entrada: usamos el **mismo** argumento para la entrada y para la salida.

- La expresion **old(a)** representa el valor inicial de la variable _a_, la usamos en la postcondicion para relacionar el valor de salida de _a_ con us valor inicial.

## Sobre-especificacion

- Consiste en dar una **postcondicion mas restrictiva** que lo que se necesita.

- Limita los posibles algoritmos que resuelven el problema, porque impone mas condiciones para la salida, o amplia los datos de entrada.

- Ejemplo

  proc $distinto$(in $x :\Z$): $\Z$ {

  requiere {$True$}

  asegura {$result = x + 1$}

  }

- .. en lugar de:

  proc $distinto$(in $x :\Z$): $\Z$ {

  requiere {$True$}

  asegura {$result \neq x$}

  }

## Sub-especificacion

- Constiste en dar una **precondicion mas restrictiva** que lo realmente necesario, o bien una **postcondicion mas debil** que la que se podria dar.

- Deja afuera datos de entrada o ignora condiciones necesarias para la salida (permite soluciones no deseadas).

- Ejemplo

  proc $distinto$(in $x :\Z$): $\Z$ {

  requiere {$x > 0$}

  asegura {$result \neq x$}

  }

- .. en lugar de:

  proc $distinto$(in $x :\Z$): $\Z$ {

  requiere {$True$}

  asegura {$result \neq x$}

  }

## Tipos de datos

- un **tipo de datos** es un **conjunto de valores** (el conjunto base del tipo) provisto de una serie de **operaciones** que involucran a esos valores.

- Para hablar de un elemento de un tipo $T$ en nuestro lenguaje, escribimos un **termino** o **expresion**

  - Variable de tipo T (ejemplos: x, y, z, etc)
  - Constante de tipo T (ejemplos: 1, -1, $\frac{1}{5}$, 'a', etc)
  - Funcion (operacion) aplicada a otros terminos (del tipo T o de otro tipo)

- Todos los tipos tienen un elemnto distinguido: $\$ o Indef

## Tipos de datos de nuestro lenguaje de especificacion

- Basicos

  -
  -
  -
  -

- Enumerados

- Uplas

- Secuencias

- Conjuntos

## Tipos $\Z$ (numeros enteros)

- Su **conjunto base** son los numeros enteros.

- Constantes:

- Operaciones aitmeticas:

- Formulas que compraran terminos de tipo $\Z$:

## Tipos $\R$ (numeros reales)

- Su **conjunto base** son los numeros reales.

- Constantes:

- Operaciones aitmeticas:

- Formulas que compraran terminos de tipo $\Z$:

## Tipos $Bool$ (valor de verdad)

- Su **conjunto base** es $\B$ = {**true,false**}.

- Conectivos logicos: !, &&, ||, con la semantica bi-valuada estandar.

- Formulas que comparan terminos de tipo Bool:

  -
  -

## Tipos Char (caracteres)

- Sus elementos son las letras, digitos y simbolos.

- Constantes:

- Funcion ord, que enumera los caracteres, con las siguientes propiedades:

  -
  -
  -

- funcion char, de modo tal que si c es cualquier char entonces char(ord(c)) = c

- Las comparaciones entre caracteres son comparaciones entre sus ordenes, de modo tal que a < b es equivalente a ord(a) < ord(b)

## Tipos enumerados

- Cantidad finita de elementos.
  Cada uno, denotado por una constante.

enum _Nombre_ { constantes }

- Nombre (del tipo): tiene que ser nuevo.

- constantes:

- Convencion: todo en mayusculas.

- ord(a) de la posicion del elemento en la definicion (empezando de 0)

- Inversa: se usa el nombre del tipo funciona como inversa de ord.

## Ejemplo de tipo enumerado

## Tipos upla (o tupla)

-

-

## Funciones y predicados auxiliares

## Expresiones condicionales

## Definir funciones auxiliares versus especificar problemas

## Especificar problemas
