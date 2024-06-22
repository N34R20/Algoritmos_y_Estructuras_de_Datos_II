# Diseño de TADs

TAD (tipo abstracto de datos)

Describe el **que** y no el como

Se manipula a traves de operaciones, que describiremos mediante un lenguaje de especificacion (logica) con pre y post condicion

## Diseño

- Un diseño de un TAD es una estructura de datos y una serie de algoritmos y una serie de algoritmos (en algun lengujae de programacion, real o simplificado) que nos indica _como_ se representa y como se codifica una posible implementacion del TAD

- Tendermos que elegir una **estructura** de representacion con tipos **de datos**

- Tendermos que escribir **algoritmos** para todas las operaciones

- Los algoritmos deberan respetar la especificacion del TAD

Puede haber muchos diseños para un TAD!

Mientras respeten la especificación, quien las use podrá elegir uno u otro diseño
sin cambiar sus programas (**modularidad**)

Ventajas del ocultamiento, la abstracción y el encapsulamiento:

- La implementación se puede cambiar y mejorar sin afectar su uso.
- Ayuda a modularizar.
- Facilita la comprensión.
- Favorece el reuso.
- Los módulos son más fáciles de entender.
- Y de programar.
- El sistema es más resistente a los cambios

## Ocultando Informacion

## TAD Punto

```
TAD Punto {

    obs x: float
    obs y: float

    proc nuevoPunto(in x: float, in y: float): Punto

    proc coordX(in p: Punto): float

    proc coordY(in p: Punto): float

    proc coordTheta(in p: Punto): float

    proc coordRho(in p: Punto): float

    proc mover()

    aux safearctan(): float

}

```

```

modulo PuntoImpl implementa Punto {
    var rho: float
    var theta: float
}

```

-> Notar que especificamos con cartesianas y di
