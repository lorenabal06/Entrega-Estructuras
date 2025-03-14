package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

import es.uah.matcomp.ed.e1.ejerciciosclases.ListaDoblementeEnlazada.Iterador;

public class IteradorDiccionario<K, V> implements Iterador<ElementoDiccionario<K, V>> {
    private Iterador<ElementoDiccionario<K, V>> iterador;
    private boolean puedeEliminar = false;
    private ElementoDiccionario<K, V> ultimoElemento;

    public IteradorDiccionario(Iterador<ElementoDiccionario<K, V>> iterador) {
        this.iterador = iterador;
        this.ultimoElemento = null;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public ElementoDiccionario<K, V> next() {
        if (!hasNext()) {
            return null;
        }
        puedeEliminar = true;
        ultimoElemento = iterador.next();
        return ultimoElemento;
    }

    @Override
    public void delete() {
        if (puedeEliminar) {
            iterador.delete();
            puedeEliminar = false;
        }
    }
}
