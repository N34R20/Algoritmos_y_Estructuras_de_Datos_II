# Trabajo Practico: Diseño e implementacion de estructuras

### Variables:

- $C$: conjunto de carreras de grado
- $M$: conjunto de materias
- $E$: cantidad total de estudiantes
- $M_c$: conjunto de materias de la carrera de grado _c_
- $N_m$: conjunto de nombres de la materia _m_
- $E_m$: cantidad de estudiantes inscriptos en la materia _m_

**Importante** tener en comentarios del codigo el invariante de representacion de cada clase implemnetada

## Operaciones a implementar

1. _nuevoSistema_ (): **SistemaSIU**

   - $O(\sum_{c\in C}|c| * |M_c| + \sum_{m\in M} \sum_{n\in N_m} |n| + E)$

para cumplir la comlejidad de este metodo vamos a utilizar una estructura del tipo Trie donde salgan de cada nodo, en orden lexofgrafico, todas las carreras, y de ellos todas las materias
estas materias estaran relacionadas con otras estructuras, para relacionar datos y cumplir complejidades pedidas en proximos metodos.

2. _inscribir_ (_inout_ **SistemaSIU**)

   - $O(|c|+|m|)$

para cumplir esta complejidad pensamos que una de las esrtructuras que esta relacionada a marterias sea un Trie de alumnos (LU, length acotado O(1)) que a su vez tenga un array que en cada index tenga los datos que yo quiero saber sobre ese alumno, por ejemplo la cantidad de materias a la que esta inscripto, inascribirlo a una materia seria sumar 1 a ese dato.
A su vez habra otra estructura anidada donde tendre datos de la materia, en este caso lo que me interesa es los alumnos que estan inscriptos a esa mateira, pues debemos agregar al alumno a ese listado

sumar a la cantidad de alumnos en materias en 1

3. _inscriptos_ (): $\N$

   - $O(|c|+|m|)$

4. _agregarDocente_ (_inout_ **SistemaSIU**)

   - $O(|c|+|m|)$

5. _plantelDocente_ (): **seq<$\N$>**

   - $O(|c|+|m|)$

6. _excedeCupo?_ (): **bool**

   - $O(|c|+|m|)$

7. _carreras_ (): **seq<$bool$>**

   - $O(\sum_{c \in C} |c|)$

8. _materias_ (): **seq<$string$>**

   - $O(|c| + \sum_{m_c \in M_c} |m_c|)$

9. _materiasInscriptas_ (): $\N$

   - $O(1)$

10. _cerrarMateria_ (_inout_ **SistemaSIU**)
    - $O(|c| + |m| + \sum_{n \in N_m} |n| + E_m)$

Estructuras a emplear:

1. necesitamos que la complejidad del metodo _materiasInscriptas_ sea $O(1)$, para eso con contruir un trie donde las LU (libreta Universitaria) son los nodos que se concetan entre si para identificar a una unica libreta terminen en un valor que sea rapido de indexar tmb, como por ejemplo un array y sino simplemente el numero de las materias a las que el estudiante esta inscripto

Hay que justificar que O(1) = O(7) siendo 7 el largo de todas las LU, un largo fijo para todas las libretas

2. Se nos ocurrio una estructura de trie que parta de la carrera y vaya a la materia asi las complejidades de los metodos del 2-6 son $O(|c|+|m|)$ de forma que tengas que recorrer todos los nodos del string correspondiente a carrera y de la materia, (piden que esten ordenado lexograficamente, al hacer el trie ya se arman respetando el orden) y dependeiendo lo que pide el metodo que al final de recorrer los nodos carrera - materia llegue a una estructura donde lo que pide sea $O(1)$, cosa de que no afecte a la complejidad total del metodo ya que $O(f) + O(g) = O(max\{f,g\})$

justificar bien

3. Para que al cambiar los datos de una materia en particular y cambiar a su vez todas las materias que son equivalentes, se nos ocurrio crear varios array de largo = a la cantidad de carreras en el SIU, cosa de que cada posicion corresponda a una carrera (ordenada lexograficamente) y indexar en esa posicion corresponda al nombre de la materia que tiene en dicha carrera

[Atmosfera, Biologia, Computacion, .....]

[Analisis_1, Matematica_1, Analisis_2, ....., null, ...]

Si la carrera no tiene tal materia la posicion correspondiente esta vacia (null)

Se podria tener tmb un array de arrays, cosa de poder indexar por materia y por carrera

4. Para calcular el cupo de cada materia vamos a tener un array que represente la cantidad de docente por su calidad d=[profesor, JTP, A1, A2] y tmb tenemos un array por la cantidad de alumnos que se estima por cada docente c=[300, 250, 30, 20] de forma que para calcular la cota de cupo se usaria el minimo de este conjunto: $min:=\{d[0].c[0];d[1].c[1];d[2].c[2];d[3].c[3]\}$

for (InfoMateria : InfoMaterias [])

InfoMateria = [(Strin carrera, String nombreMateria)(Strin carrera2, String nombreMateria2)(Strin carrera3, String nombreMateria3) .... ]

            cantInscriptos plantelDocente conjuntoAlumnos nodosYNombres

Materia = < 0, {0,0,0,0}, {}, {} >

o -> c1 -> m1 -> Materia
-> c2 -> m2 -> Materia
.
.
.
-> cn -> mn -> Materia

(c1, m7)

(nodoAlTrieDeCarrera, nombreMateria, nombreCarrera)

ParNOmbreCarrera.Carrera == nomrbeCarerra
entra por el trie

o ->
