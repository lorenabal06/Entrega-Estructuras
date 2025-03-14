package es.uah.matcomp.ed.e1.ejerciciosclases;

import static org.junit.jupiter.api.Assertions.*;

import es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario.ElementoDiccionario;
import es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario.IteradorDiccionario;
import es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario.IteradorListaDoblementeEnlazada;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class TestIteradorDiccionario {

    private IteradorListaDoblementeEnlazada<ElementoDiccionario<String, Integer>> iteradorLista;
    private IteradorDiccionario<String, Integer> iteradorDiccionario;


    @Test
    void testHasNext() {
        assertTrue(iteradorDiccionario.hasNext()); // Debe haber elementos al inicio
        iteradorDiccionario.next();
        iteradorDiccionario.next();
        iteradorDiccionario.next();
        assertFalse(iteradorDiccionario.hasNext()); // No debe haber más elementos
    }

    @Test
    void testNext() {
        assertEquals("Uno", iteradorDiccionario.next().getClave());
        assertEquals("Dos", iteradorDiccionario.next().getClave());
        assertEquals("Tres", iteradorDiccionario.next().getClave());
    }

    @Test
    void testNextThrowsExceptionWhenEmpty() {
        iteradorDiccionario.next();
        iteradorDiccionario.next();
        iteradorDiccionario.next();
        assertThrows(NoSuchElementException.class, () -> iteradorDiccionario.next());
    }

    @Test
    void testDelete() {
        iteradorDiccionario.next(); // Apunta al primer elemento
        iteradorDiccionario.delete(); // Elimina el primero

        assertEquals("Dos", iteradorDiccionario.next().getClave()); // Verifica el siguiente
    }
}

