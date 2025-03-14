package es.uah.matcomp.ed.e1.ejerciciosclases;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class TestListaDoblementeEnlazada {

    private ListaDoblementeEnlazada<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaDoblementeEnlazada<>();
        lista.add(5);
        lista.add(15);
        lista.add(25);
    }

    @Test
    void testAdd() {
        assertEquals(3, lista.getNumElementos());
        lista.add(35);
        assertEquals(4, lista.getNumElementos());
    }

    @Test
    void testDeleteExistingElement() {
        assertTrue(lista.delete(15)); // Elimina el nodo intermedio
        assertEquals(2, lista.getNumElementos());

        List<Integer> resultado = obtenerLista();
        assertEquals(List.of(5, 25), resultado);
    }

    @Test
    void testDeleteFirstElement() {
        assertTrue(lista.delete(5)); // Elimina el primer nodo
        assertEquals(2, lista.getNumElementos());

        List<Integer> resultado = obtenerLista();
        assertEquals(List.of(15, 25), resultado);
    }

    @Test
    void testDeleteLastElement() {
        assertTrue(lista.delete(25)); // Elimina el último nodo
        assertEquals(2, lista.getNumElementos());

        List<Integer> resultado = obtenerLista();
        assertEquals(List.of(5, 15), resultado);
    }

    @Test
    void testDeleteNonExistingElement() {
        assertFalse(lista.delete(50)); // Elemento que no existe
        assertEquals(3, lista.getNumElementos());
    }

    @Test
    void testIterador() {
        List<Integer> resultado = obtenerLista();
        assertEquals(List.of(5, 15, 25), resultado);
    }

    @Test
    void testIteradorDoble() {
        IteradorDoble<Integer> iterador = (IteradorDoble<Integer>) lista.getIterador();
        List<Integer> resultado = new ArrayList<>();

        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(5, 15, 25), resultado);

        // Ahora iteramos en sentido inverso
        List<Integer> resultadoReverso = new ArrayList<>();
        while (iterador.hasPrevious()) {
            resultadoReverso.add(iterador.previous());
        }
        assertEquals(List.of(25, 15, 5), resultadoReverso);
    }

    @Test
    void testListaVacia() {
        lista = new ListaDoblementeEnlazada<>();
        assertEquals(0, lista.getNumElementos());
        assertFalse(lista.delete(5)); // No se puede eliminar de una lista vacía

        Iterador<Integer> iterador = lista.getIterador();
        assertFalse(iterador.hasNext()); // No hay elementos para iterar
    }

    private List<Integer> obtenerLista() {
        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        return resultado;
    }
}
