package es.uah.matcomp.ed.e1.ejerciciosclases;

import es.uah.matcomp.ed.e1.ejerciciosclases.PilaYCola.Cola;
import es.uah.matcomp.ed.e1.ejerciciosclases.PilaYCola.Pila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPilaYCola {
    @Test
    void testPila() {
        Pila<Integer> pila = new Pila<>();

        assertTrue(pila.isEmpty());

        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(3, pila.peek()); // El último en entrar es 3
        assertEquals(3, pila.pop()); // Sacamos 3
        assertEquals(2, pila.pop()); // Sacamos 2
        assertEquals(1, pila.pop()); // Sacamos 1
        assertNull(pila.pop()); // La pila ya está vacía

        assertTrue(pila.isEmpty());
    }

    @Test
    void testCola() {
        Cola<Integer> cola = new Cola<>();

        assertTrue(cola.isEmpty());

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        assertEquals(10, cola.peek()); // El primero en entrar es 10
        assertEquals(10, cola.dequeue()); // Sacamos 10
        assertEquals(20, cola.dequeue()); // Sacamos 20
        assertEquals(30, cola.dequeue()); // Sacamos 30
        assertNull(cola.dequeue()); // La cola ya está vacía

        assertTrue(cola.isEmpty());
    }
}
