package es.uah.matcomp.ed.e1.ejerciciosclases;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestElemento {

    private Elemento<Integer> nodo1;
    private Elemento<Integer> nodo2;

    @Test
    void setUp() {
        nodo1 = new Elemento<>(10);
        nodo2 = new Elemento<>(20);
        nodo1.setSiguiente(nodo2);
    }

    @Test
    void testGetDato() {
        assertEquals(10, nodo1.getDato());
        assertEquals(20, nodo2.getDato());
    }

    @Test
    void testSetDato() {
        nodo1.setDato(30);
        assertEquals(30, nodo1.getDato());
    }

    @Test
    void testGetSiguiente() {
        assertEquals(nodo2, nodo1.getSiguiente());
        assertNull(nodo2.getSiguiente()); // nodo2 no tiene siguiente
    }

    @Test
    void testSetSiguiente() {
        Elemento<Integer> nodo3 = new Elemento<>(40);
        nodo2.setSiguiente(nodo3);
        assertEquals(nodo3, nodo2.getSiguiente());
    }

    @Test
    void testToString() {
        assertEquals("Elemento{dato=10}", nodo1.toString());
        assertEquals("Elemento{dato=20}", nodo2.toString());
    }
}
