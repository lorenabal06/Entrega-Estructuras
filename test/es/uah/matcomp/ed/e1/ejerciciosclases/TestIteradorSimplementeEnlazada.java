package es.uah.matcomp.ed.e1.ejerciciosclases;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIteradorListaSimplementeEnlazada {

    private Elemento<Integer> nodo1;
    private Elemento<Integer> nodo2;
    private Elemento<Integer> nodo3;
    private IteradorListaSimplementeEnlazada<Integer> iterador;

    @BeforeEach
    void setUp() {
        nodo1 = new Elemento<>(1);
        nodo2 = new Elemento<>(2);
        nodo3 = new Elemento<>(3);

        nodo1.siguiente = nodo2;
        nodo2.siguiente = nodo3;

        iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
    }

    @Test
    void testHasNext() {
        assertTrue(iterador.hasNext());
        iterador.next();
        iterador.next();
        iterador.next();
        assertFalse(iterador.hasNext()); // Después del último elemento, debe ser false
    }

    @Test
    void testNext() {
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        assertNull(iterador.next()); // No hay más elementos, devuelve null
    }

    @Test
    void testDelete() {
        iterador.next(); // Mueve el iterador al primer nodo
        iterador.delete(); // Intenta eliminar el primer nodo, pero sin referencia previa no es posible

        assertEquals(2, iterador.next()); // Continúa con el siguiente nodo
    }
}
