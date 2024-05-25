# Lista Enlazada

una de las estructuras de datos fundamentales, y puede ser usada para implementar otras estructuras de datos. Consiste en una **secuencia de nodos**, en los que se guardan campos de datos arbitrarios y una o dos referencias, enlaces o punteros al nodo anterior o posterior. El principal beneficio de las listas enlazadas respecto a los vectores convencionales es que el orden de los elementos enlazados puede ser diferente al orden de almacenamiento en la memoria o el disco, permitiendo que el orden de recorrido de la lista sea diferente al de almacenamiento.

Una lista enlazada es un tipo de dato autorreferenciado porque contienen un puntero o enlace (en inglés link, del mismo significado) a otro dato del mismo tipo. Las listas enlazadas permiten inserciones y eliminación de nodos en cualquier punto de la lista en tiempo constante (suponiendo que dicho punto está previamente identificado o localizado), pero no permiten un acceso aleatorio. Existen diferentes tipos de listas enlazadas: listas enlazadas simples, listas doblemente enlazadas, listas enlazadas circulares y listas enlazadas doblemente circulares.

## Tipos (o Variantes)

Lista Simplemente enlazada

- complejidad temporal de busqueda $O(n)$

Lista Doblemente enlazada

- complejidad temporal de busqueda $O(\frac{n}{2})$

- como sera el invariante de representacion?
- como sera la funcion de abstraccion?

## Ejemplo de algoritmo

```
longitud(in l: ListaEnlazada<T>) : int

if (l.primero == null)
    return 0
else
    var ret = 1
    var actual = l.primero

    while (actual.siguiente != null)
        actual = actual.siguiente
        ret = ret + 1
    endwhile
endif

return ret

```

aliassing:= cuando dos variables apuntan al mismo elemento

### Implementacion en Java

```Java
class NodoDoble{
    int informacion;
    NodoDoble siguiente, anterior;

    public NodoDoble(int info){
        informacion=info;
        siguiente=null;
        anterior=null;
    }
}

class ListaDoblementeEnlazada{
    NodoDoble inicio, fin;

    public ListaDoblementeEnlazada(){
        inicio=fin=null;
    }

    void estaVacia(){
        if(inicio == null && fin == null)
            return true;
        return false;
    }

    void insertarEnfrente(int dato){
        NodoSimple nodito=new NodoSimple(dato);
        if(estaVacia()==true){
            inicio=nodito;
            fin=nodito;
        }
        else{
            nodito.siguiente=inicio;
            inicio.anterior=nodito;
        }
        inicio=nodito;
    }

    void insertarAtras(int dato){
        NodoSimple nodito=new NodoSimple(dato);
        if(estaVacia()==true){
            inicio=nodito;
            fin=nodito;
        }
        else{
            fin.siguiente=nodito;
            nodito.anterior=fin;
        }
        fin=nodito;
    }

    void eliminarEnfrente(){
        if(estaVacia()==true){
            System.out.println("Lista vacía, no se puede eliminar");
        }
        else if(inicio == fin){
            inicio=null;
            fin=null;
        }
        else{
            NodoSimple auxiliar=inicio;
            System.out.println("El dato que fue eliminado es: "+inicio.informacion);
            inicio=inicio.siguiente;
            auxiliar.anterior=null;
            auxiliar.siguiente=null;
            inicio.anterior=null;
        }
    }

    void eliminarAtras(){
        if(estaVacia() == true){
            System.out.println("Lista vacía, no se puede eliminar");
        }
        else if(inicio == fin){
            inicio=null;
            fin=null;
        }
        else{
            NodoSimple auxiliar=fin;
            System.out.println("El dato que fue eliminado es: "+fin.informacion);
            fin=fin.anterior;
            fin.siguiente=null;
            auxiliar.anterior=null;
            auxiliar.siguiente=null;
        }
    }

    void imprimirListaIzqDer(){//Impresion de inicio a fin
        if(estaVacia() == true){
            System.out.println("Lista vacía");
        }
        else if(inicio == fin){
           System.out.println(inicio.informacion);
        }
        else{
            NodoSimple auxiliar=inicio;
            while(auxiliar != null){
                System.out.println(auxiliar.informacion+" ");
                auxiliar=auxiliar.siguiente;
            }
        }
    }

    void imprimirListaDerIzq(){//Impresion de fin a inicio
        if(estaVacia() == true){
            System.out.println("Lista vacía");
        }
        else if(inicio == fin){
           System.out.println(inicio.informacion);
        }
        else{
            NodoSimple auxiliar=fin;
            while(auxiliar != null){
                System.out.println(auxiliar.informacion+" ");
                auxiliar=auxiliar.anterior;
            }
        }
    }

    public static void main(String arrr[]){
        ListaDoblementeEnlazada listita = new ListaDoblementeEnlazada();
        listita.insertarEnfrente(19);
        listita.insertarAtras(28);
        listita.insertarEnfrente(11);
        listita.insertarAtras(51);
        listita.insertarAtras(9);
        listita.imprimirListaIzqDer();
        listita.eliminarAtras();
        listita.imprimirListaDerIzq();
    }
}

```
