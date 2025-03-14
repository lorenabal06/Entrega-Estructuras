package es.uah.matcomp.ed.e1.ejerciciosclases;

import es.uah.matcomp.ed.e1.ejerciciosclases.ListaBasica.Iterador;
import es.uah.matcomp.ed.e1.ejerciciosclases.ListaBasica.ListaBasica;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestListaBasica {

    @Test
    void testListaBasica() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.delete(2); // Eliminamos el 2 directamente

        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();

        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(1, 3), resultado);
    }

    @Test
    void testListaConDuplicados() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);

        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();

        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(1, 2, 2, 3), resultado);
    }

    @Test
    void testEliminarConIterador() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        Iterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            if (iterador.next() == 2) {
                iterador.delete(); // Elimina el 2 usando el iterador
            }
        }

        List<Integer> resultado = new ArrayList<>();
        iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(1, 3), resultado);
    }

    @Test
    void testListaVacia() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();

        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(), resultado);
    }

    @Test
    void testEliminarPrimerElemento() {
        ListaBasica<Integer> lista = new ListaBasica<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        Iterador<Integer> iterador = lista.getIterador();
        if (iterador.hasNext()) {
            iterador.next();
            iterador.delete(); // Elimina el primer elemento (1)
        }

        List<Integer> resultado = new ArrayList<>();
        iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(2, 3), resultado);
    }
}
