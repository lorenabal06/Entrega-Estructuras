package es.uah.matcomp.ed.e1.ejerciciosclases;


import static org.junit.jupiter.api.Assertions.*;

import es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario.ElementoDiccionario;
import org.junit.jupiter.api.Test;

class TestElementoDiccionario {

    private ElementoDiccionario<String, Integer> elemento1;
    private ElementoDiccionario<String, Integer> elemento2;
    private ElementoDiccionario<String, Integer> elemento3;

    @Test
    void setUp() {
        elemento1 = new ElementoDiccionario<>("clave1", 10);
        elemento2 = new ElementoDiccionario<>("clave2", 20);
        elemento3 = new ElementoDiccionario<>("clave1", 30); // Misma clave que elemento1
    }

    @Test
    void testGetClave() {
        assertEquals("clave1", elemento1.getClave());
        assertEquals("clave2", elemento2.getClave());
    }

    @Test
    void testGetValor() {
        assertEquals(10, elemento1.getValor());
        assertEquals(20, elemento2.getValor());
    }

    @Test
    void testSetValor() {
        elemento1.setValor(50);
        assertEquals(50, elemento1.getValor());
    }

    @Test
    void testEquals() {
        assertEquals(elemento1, elemento3); // Deben ser iguales porque tienen la misma clave
        assertNotEquals(elemento1, elemento2); // Deben ser diferentes porque tienen claves distintas
    }

    @Test
    void testHashCode() {
        assertEquals(elemento1.hashCode(), elemento3.hashCode()); // HashCode debe ser igual para la misma clave
        assertNotEquals(elemento1.hashCode(), elemento2.hashCode()); // HashCode diferente para claves distintas
    }
}
