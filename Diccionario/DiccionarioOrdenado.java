package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

public class DiccionarioOrdenado<K extends Comparable<K>, V> extends DiccionarioBasico<K, V> {

    @Override
    public void add(K clave, V valor) {
        ElementoDiccionario<K, V> nuevo = new ElementoDiccionario<>(clave, valor);
        ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista = super.lista;

        if (lista.getNumElementos() == 0) {
            lista.add(nuevo);
            return;
        }

        Iterador<ElementoDiccionario<K, V>> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            ElementoDiccionario<K, V> actual = iterador.next();
            if (clave.equals(actual.getClave())) {
                actual.setValor(valor);
                return;
            }
            if (clave.compareTo(actual.getClave()) < 0) {
                lista.insertBefore(actual, nuevo);
                return;
            }
        }
        lista.add(nuevo);
    }
}

