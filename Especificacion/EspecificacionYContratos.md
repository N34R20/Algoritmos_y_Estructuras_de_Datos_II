# Especificacion y Contratos

## Especificacion de problemas

- Una especificacion es un contrato que define que se debe resolver y que propiedades debe tener la solucion

- La especificacio de un problema incluye un conjunto de parametros: datos de entrada cuyos valroes seran conocidos recien al ejecutar el programa

- Ademas de cumplir un rol "contractual", la especificacion del problema es unsumo para las actividades de ..

1. testing
2. verificacion formal de correcion
3. derivacion formal (construir un programa a partir de la especificaion)

## Parametros y tipos de datos

- La especificacion de un problema incluye un conjunto de parametros.
- Cada parametro tiene un **tipo de datos**
  - Tipo de datos: Conjunto de valores provisto de ciertas operaciones para trabajar con estos valores.

## Contratos

- Una especificaion es un contrato entre el programador de una funciony el usuario de esa funcion.

## Partes de una especificacion (contratos)

1. **Encabezado**
2. **Precondicion** o clausula "requiere"
   - Condicion sobre los argumentos, que el programador da por cierta.
   - Especifica lo que **requiere** la funcion para hacer su tarea
3. **Postcondicion** o clausula "asegura"
   - Condicion sobre el resultado, que debe ser cumplida por el programador siempre y cuando el usuario haya cumplido la precondicion
   - Especifica lo que la funcion **asegura** que se va acumplir despues de llamarla (se se cumplia la precondicion).

## Por que escribir la especificaicon del problema?

Algoritmo

Programa
