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

2. _inscribir_ (_inout_ **SistemaSIU**)

   - $O(|c|+|m|)$

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
