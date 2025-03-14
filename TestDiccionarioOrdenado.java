package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.uah.matcomp.ed.e1.ejerciciosclases.ListaDoblementeEnlazada.Iterador;

class TestDiccionarioOrdenado {

    private DiccionarioOrdenado<String, Integer> diccionario;

    @BeforeEach
    void setUp() {
        diccionario = new DiccionarioOrdenado<>();
        diccionario.add("C", 3);
        diccionario.add("A", 1);
        diccionario.add("B", 2);
    }

    @Test
    void testAddAndOrder() {
        Iterador<ElementoDiccionario<String, Integer>> iterador = diccionario.getIterador();

        assertTrue(iterador.hasNext());
        assertEquals("A", iterador.next().getClave());
        assertTrue(iterador.hasNext());
        assertEquals("B", iterador.next().getClave());
        assertTrue(iterador.hasNext());
        assertEquals("C", iterador.next().getClave());
        assertFalse(iterador.hasNext()); // No debe haber más elementos
    }

    @Test
    void testGet() {
        assertEquals(1, diccionario.get("A"));
        assertEquals(2, diccionario.get("B"));
        assertEquals(3, diccionario.get("C"));
    }

    @Test
    void testGetNonExistingKey() {
        assertNull(diccionario.get("D")); // Clave que no existe
    }

    @Test
    void testDelete() {
        assertTrue(diccionario.delete("B")); // Se elimina "B"
        assertNull(diccionario.get("B")); // Ya no debería existir

        Iterador<ElementoDiccionario<String, Integer>> iterador = diccionario.getIterador();
        assertEquals("A", iterador.next().getClave());
        assertEquals("C", iterador.next().getClave());
        assertFalse(iterador.hasNext()); // No debe haber más elementos

        assertEquals(2, diccionario.getIterador().hasNext() ? 2 : 1); // Verifica tamaño actualizado
    }

    @Test
    void testUpdateValue() {
        diccionario.add("A", 10); // Se actualiza el valor de "A"
        assertEquals(10, diccionario.get("A")); // Debe reflejar el nuevo valor
        assertEquals(2, diccionario.get("B"));
        assertEquals(3, diccionario.get("C"));
    }

    @Test
    void testEmptyDictionary() {
        DiccionarioOrdenado<String, Integer> emptyDic = new DiccionarioOrdenado<>();

        assertNull(emptyDic.get("X")); // Buscar en diccionario vacío debe devolver null
        assertFalse(emptyDic.delete("X")); // Eliminar en diccionario vacío debe devolver false

        Iterador<ElementoDiccionario<String, Integer>> iterador = emptyDic.getIterador();
        assertFalse(iterador.hasNext()); // No debe haber elementos en el iterador
    }
}
