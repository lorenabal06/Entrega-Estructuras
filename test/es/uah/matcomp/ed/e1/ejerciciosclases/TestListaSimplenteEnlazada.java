package es.uah.matcomp.ed.e1.ejerciciosclases;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class TestListaSimplementeEnlazada {

    private Lista<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaSimplementeEnlazada<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
    }

    @Test
    void testAdd() {
        assertEquals(3, lista.getNumElementos());
        assertTrue(lista.add(40));
        assertEquals(4, lista.getNumElementos());
    }

    @Test
    void testDeleteExistingElement() {
        assertTrue(lista.delete(20));
        assertEquals(2, lista.getNumElementos());
        assertNull(buscarElemento(20));
    }

    @Test
    void testDeleteNonExistingElement() {
        assertFalse(lista.delete(50));
        assertEquals(3, lista.getNumElementos());
    }

    @Test
    void testIterador() {
        Iterador<Integer> iterador = lista.getIterador();
        List<Integer> resultado = new ArrayList<>();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(10, 20, 30), resultado);
    }

    @Test
    void testEliminarConIterador() {
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            if (iterador.next() == 20) {
                iterador.delete();
            }
        }
        assertEquals(2, lista.getNumElementos());
        assertNull(buscarElemento(20));
    }

    @Test
    void testEliminarPrimerElemento() {
        Iterador<Integer> iterador = lista.getIterador();
        if (iterador.hasNext()) {
            iterador.next();
            iterador.delete();
        }

        List<Integer> resultado = new ArrayList<>();
        iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(20, 30), resultado);
    }

    @Test
    void testListaVacia() {
        lista = new ListaSimplementeEnlazada<>();
        assertEquals(0, lista.getNumElementos());
        assertFalse(lista.delete(10));
        Iterador<Integer> iterador = lista.getIterador();
        assertFalse(iterador.hasNext());
    }

    private Integer buscarElemento(int valor) {
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            if (iterador.next().equals(valor)) {
                return valor;
            }
        }
        return null;
    }
}
