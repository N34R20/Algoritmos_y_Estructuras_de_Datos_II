# Correctitud en TADs

Repaso

- Un TAD define el **que**. Tiene estado y operaciones descriptas mediante pre y post condicion, en logica.

- Una implementacion define el **como**. Tiene un estado, invarainte de representacion, funcion (o predicado) de abstraccion y algoritmos para las operaciones

- Un TAD puede tener muchas implementaciones, segun los requerimientos y el contexto de uso (por ejemplo de eficiencia)

## Verificacion

Podemos demostrar que la implementacion de un TAD es correcta respecto de la especificacion del TAD? -> Si

Para toda operacion impF que implementa una operacion F del TAD y toda instancia _c_ de su representacion que cumple el invariante de representacion, debemos ver que el siguiente diagrama conmuta:

![imagen 1](/etc/imgs/Screenshot%202024-05-21%20at%2016.23.40.png)

Para cada operacion, hay que demostrar que:

1. Conserva el invariante
2. El algoritmo respeta la pre y la postcondicion del TAD

Vamos a tener que viajar entre los mundos de la implementacion y del TAD usando la funcion de abstraccion ...

Conservacion del invariante - Ejemplo

TAD punto / Operacion rotar

```
TAD Punto {

    obs x: float
    obs y: float

}
```

```
Impl PuntoImpl {
    var rho: float
    var theta: float

    pred InvRep(p': PuntoImpl) {
        0 <= p'.theta < 2 * pi
    }

    FuncAbs(p': PuntoImpl): Punto {
        Punto p | p.x = p'.rho * cos(p'.theta) &&
                  p.y = p'.rho * sin(p'.theta)
    }

    proc rotar() {
        p'.theta = p'.theta + d;
    }
}
```

InvRep(p')

Tenemos que demostrar que:

$InvRep(p') \rightarrow wp(codigo, InvRep(p'))$

wp(codigo, InvRep(p'))

p'.theta = p'.theta + d;

InvRep(p')
