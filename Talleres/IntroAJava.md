# Intro a Java

Porque java se usa tanto?

OOP

manejador automatico de memoria

### familiarizandonos con la sintaxis

## Problema 1: fibonacci

hacer una funcion que calcule el numero de Fibonacci.
Recordar que $fib_o = 0, fib_1 = 1, fib_n = fib_{n-1} + fib_{n-2}$

- Las funciones pueden ser recursivas
- Como se escrbie una fun basica
- Estructura if, else if y else
- Tipo int
- Funcionamiento del return (tener cuidado)

```java
package aed

class Main {
    int fibonacci(int n) {
        int res;

        if (n == 0) {
            res = 0;
        } else if (n == 1) {
            res = 1;
        } else {
            res = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    return res;

#forma alternativa

    int fibonacciReturn(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        };
    }
}
```

declarar una variable y posteriormente asiganerle un valor

== comparacion

= asignacion

bloques de codigo como se agrupan
python : identacion
java: {}

despues de cada sentencia se pone un ; -> le dice al compilador aca termino una sentencia

## Problema 2: maximo

$$
proc maximo (in s: req<R>) : R {
    requiere {|s| > 0}
    asegura {res e s \wedge (\forall x: R)}(x e s \rightarrow x < res)
}
$$

```java

    double maximo (double[] xs) {
        double res = 0;

        for (double x : xs) {
            // Si encuentro un elemento mayor al que tenia guradado,
            // me lo guardo
            if (x > res) {
                res = x
            }
        }

    return res;
    }
```

- Estructura general del for
- Crear arreglos
-

## Problema 4: sumarArreglos

Problema: dadas dos secuencias de eneteros con el mismo tamaño, sumarlas.

proc sumarArreglos (in s1: seq<\Z>, in s2: seq<\Z>): seq<\Z> {
requiere {|s1| = |s2|}
asegura {|res| = |s1| \wedge_L (\forall i: \N) (i < |res| \rightarrow_L res[i] = s1[i] + s2[i])}
}

```java


    int[] sumarArreglos (int[] seq1, int[] seq2) {
        int[] res = new int[seq1.length];

        for (int i = 0; i < seq1.length; i++) {
            // revisar el error
            res[i] = seq1[i] + seq2[i];
        }

    return res;
    }
```

-

## Problema 4: iniciales

Problema: dado un String (), devolver otro String con la

```java

    String iniciales(String texto) {
        String res = "";
        for (int i = 0; i < texto.length(); i++) {
            if (i == 0 || (texto.charAt(i - 1) == ' ' && texto.charAt(i) != ' ' )) {
                res += texto.charAt(i);
            }
        }

    return res;
    }
```

or en java es un or luego , evaluacion lazy

- Funciones de String
- Operaciones con Booleanos

### Algunas funciones matematicas utiles

- Valor absoluto: Math.asb
- Raiz cuadrada: Math.sqrt
- Techo y piso: Math.ceil y Math.floor
- Maximo y minimo: Math.max y Math.min
