package es.uah.matcomp.ed.e1.ejerciciosclases;

public class IteradorDiccionario<K, V> implements Iterador<ElementoDiccionario<K, V>> {
    private IteradorListaDoblementeEnlazada<ElementoDiccionario<K, V>> iterador;

    public IteradorDiccionario(IteradorListaDoblementeEnlazada<ElementoDiccionario<K, V>> iterador) {
        this.iterador = iterador;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public ElementoDiccionario<K, V> next() {
        return iterador.next();
    }

    @Override
    public void delete() {
        iterador.delete();
    }
}
