package es.uah.matcomp.ed.e1.ejerciciosclases;

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
        lista.delete(2);

        List<Integer> resultado = new ArrayList<>();
        Iterador<Integer> iterador = lista.getIterador();

        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        assertEquals(List.of(1, 3), resultado);
    }
}
