package es.uah.matcomp.ed.e1.ejerciciosclases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDiccionario {
    @Test
    void testDiccionario() {
        DiccionarioOrdenado<String, Integer> diccionario = new DiccionarioOrdenado<>();
        diccionario.add("a", 1);
        diccionario.add("b", 2);
        diccionario.delete("a");

        Iterador<ElementoDiccionario<String, Integer>> iterador = diccionario.getIterador();
        assertTrue(iterador.hasNext());
        assertEquals("a", iterador.next().getClave());
    }
}
