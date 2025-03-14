package es.uah.matcomp.ed.e1.ejerciciosclases.ListaBasica;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class TestLista {

    private Lista<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaBasica<>(); // Se usa ListaBasica como implementación de Lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
    }

    @Test
    void testAdd() {
        assertEquals(3, lista.getNumElementos()); // La lista tiene 3 elementos
        assertTrue(lista.add(4)); // Añade un nuevo elemento
        assertEquals(4, lista.getNumElementos()); // Ahora hay 4 elementos
    }

    @Test
    void testDeleteExistingElement() {
        assertTrue(lista.delete(2)); // Borra el número 2
        assertEquals(2, lista.getNumElementos()); // La lista debe reducirse a 2 elementos
        assertNull(buscarElemento(2)); // Verifica que el elemento 2 ya no está
    }

    @Test
    void testDeleteNonExistingElement() {
        assertFalse(lista.delete(5)); // El número 5 no está en la lista, debe devolver false
        assertEquals(3, lista.getNumElementos()); // La lista sigue teniendo 3 elementos
    }

    @Test
    void testIterador() {
        Iterador<Integer> iterador = lista.getIterador();
        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        assertFalse(iterador.hasNext()); // No hay más elementos
    }

    @Test
    void testEliminarConIterador() {
        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            if (iterador.next() == 2) {
                iterador.delete(); // Elimina el 2 usando el iterador
            }
        }
        assertEquals(2, lista.getNumElementos());
        assertNull(buscarElemento(2)); // Verifica que el elemento 2 ha sido eliminado
    }

    @Test
    void testEliminarPrimerElemento() {
        Iterador<Integer> iterador = lista.getIterador();
        if (iterador.hasNext()) {
            iterador.next();
            iterador.delete(); // Elimina el primer elemento (1)
        }

        List<Integer> resultado = new ArrayList<>();
        iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(2, 3), resultado);
    }

    @Test
    void testListaVacia() {
        lista = new ListaBasica<>(); // Nueva lista vacía
        assertEquals(0, lista.getNumElementos());
        assertFalse(lista.delete(1)); // No se puede eliminar porque no hay elementos
        Iterador<Integer> iterador = lista.getIterador();
        assertFalse(iterador.hasNext()); // No debería haber elementos en la iteración
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
