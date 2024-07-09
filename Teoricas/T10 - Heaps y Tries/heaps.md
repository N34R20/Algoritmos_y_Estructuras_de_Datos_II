# Colas de Prioridad y heaps

- Numerosas aplicaciones

  - Sistemas operativos, algoritmos de scheduling, gestion de colas en cualquier ambiente, etc.

- La prioridad en general la expresamos con un entero, pero puede ser cualqueir otro tipo $\alpha$ con un orden $<_\alpha$ asociado.

- Correspondencia entre maxima prioridad y un valor maximo o minimo del valor el tipo $\alpha$

## TAD Colas de prioridad

TAD ColaPrioridad<T> {
obs s: seq<T>

proc ColaPrioridadVacia(): ColaPrioridad<T> {
asegura res.s = []
}

proc vacia(in c: ColaPrioridad<T>): bool {
asegura res = true <==> c.s = []
}

proc apilar(inout c: ColaPrioridad<T>, e: T): {
asegura c.s = old(c).s + [e]
}

proc desapilarMax(inout c: ColaPrioridad<T>): {

- requere c.s != []
- asegura esMax(old(c).s, res)
- asegura ($a$)
  }
  }
