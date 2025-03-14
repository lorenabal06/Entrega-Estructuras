package es.uah.matcomp.ed.e1.ejerciciosclases.ListaDoblementeEnlazada;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIteradorDoble {

    private ListaDoblementeEnlazada<Integer> lista;
    private IteradorListaDoblementeEnlazada<Integer> iterador;

    @BeforeEach
    void setUp() {
        lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        iterador = new IteradorListaDoblementeEnlazada<>(lista.cabeza, lista);
    }

    @Test
    void testHasNext() {
        assertTrue(iterador.hasNext()); // Debe haber elementos
        iterador.next();
        iterador.next();
        iterador.next();
        assertFalse(iterador.hasNext()); // No debe haber más elementos
    }

    @Test
    void testNext() {
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        assertNull(iterador.next()); // No hay más elementos
    }

    @Test
    void testHasPrevious() {
        iterador.next(); // Ahora en nodo2
        assertTrue(iterador.hasPrevious()); // Debería haber un nodo anterior

        iterador.previous();
        assertFalse(iterador.hasPrevious()); // En nodo1, no hay anterior
    }

    @Test
    void testPrevious() {
        iterador.next(); // Ahora en nodo2
        iterador.next(); // Ahora en nodo3
        assertEquals(2, iterador.previous()); // Debe volver a nodo2
        assertEquals(1, iterador.previous()); // Debe volver a nodo1
        assertNull(iterador.previous()); // No hay más atrás
    }

    @Test
    void testDelete() {
        iterador.next(); // Apunta a nodo1
        iterador.delete(); // Borra nodo1 (ajusta los enlaces)

        assertEquals(2, iterador.next()); // Debe continuar con nodo2
        assertEquals(3, iterador.next()); // Luego con nodo3
        assertNull(iterador.next()); // No hay más elementos
    }

    @Test
    void testEliminarUltimoElemento() {
        iterador.next();
        iterador.next();
        iterador.next(); // Ahora en el último nodo (3)
        iterador.delete(); // Elimina nodo3

        assertFalse(iterador.hasNext()); // No debe haber más elementos después
        assertEquals(2, lista.getNumElementos()); // La lista ahora tiene 2 elementos
    }

    @Test
    void testEliminarElementoIntermedio() {
        iterador.next();
        iterador.next(); // Ahora en nodo2
        iterador.delete(); // Borra nodo2

        assertEquals(3, iterador.next()); // Debe continuar con nodo3
        assertNull(iterador.next()); // No hay más elementos
    }
}
