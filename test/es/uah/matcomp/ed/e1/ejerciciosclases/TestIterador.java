package es.uah.matcomp.ed.e1.ejerciciosclases;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* Para probar la interfaz Iterador<T>, necesitamos una clase concreta que la implemente.
Como ya hemos trabajado con IteradorListaSimplementeEnlazada<T>, podemos
hacerle pruebas unitarias para verificar el correcto funcionamiento de Iterador<T>
 */

class TestIterador {

    private IteradorListaSimplementeEnlazada<Integer> iterador;

    @Test
    void setUp() {
        // Crear una lista enlazada simple con algunos elementos
        Elemento<Integer> nodo1 = new Elemento<>(1);
        Elemento<Integer> nodo2 = new Elemento<>(2);
        Elemento<Integer> nodo3 = new Elemento<>(3);

        // Crear iterador con el nodo inicial
        iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
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
        assertNull(iterador.next()); // No hay más elementos, debe devolver null
    }

    @Test
    void testDelete() {
        iterador.next(); // Mueve el iterador al primer nodo
        iterador.delete(); // Borra el nodo actual

        assertEquals(2, iterador.next()); // Debe continuar en el siguiente nodo
    }
}
