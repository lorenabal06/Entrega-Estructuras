package es.uah.matcomp.ed.e1.ejerciciosclases.ListaDoblementeEnlazada;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestElementoDoble {

    private ElementoDoble<Integer> nodo1;
    private ElementoDoble<Integer> nodo2;
    private ElementoDoble<Integer> nodo3;

    @BeforeEach
    void setUp() {
        nodo1 = new ElementoDoble<>(10);
        nodo2 = new ElementoDoble<>(20);
        nodo3 = new ElementoDoble<>(30);

        // Enlazar nodos doblemente
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;
        nodo2.siguiente = nodo3;
        nodo3.anterior = nodo2;
    }

    @Test
    void testGetDato() {
        assertNotNull(nodo1);
        assertNotNull(nodo2);
        assertNotNull(nodo3);

        assertEquals(10, nodo1.dato);
        assertEquals(20, nodo2.dato);
        assertEquals(30, nodo3.dato);
    }

    @Test
    void testSetSiguiente() {
        assertNotNull(nodo1.siguiente);
        assertNotNull(nodo2.siguiente);
        assertNull(nodo3.siguiente); // Último nodo no tiene siguiente

        assertEquals(nodo2, nodo1.siguiente);
        assertEquals(nodo3, nodo2.siguiente);
    }

    @Test
    void testSetAnterior() {
        assertNotNull(nodo2.anterior);
        assertNotNull(nodo3.anterior);
        assertNull(nodo1.anterior); // Primer nodo no tiene anterior

        assertEquals(nodo1, nodo2.anterior);
        assertEquals(nodo2, nodo3.anterior);
    }

    @Test
    void testEnlaceBidireccional() {
        assertEquals(nodo1, nodo2.anterior);
        assertEquals(nodo2, nodo3.anterior);
        assertEquals(nodo2, nodo1.siguiente);
        assertEquals(nodo3, nodo2.siguiente);
    }
}

