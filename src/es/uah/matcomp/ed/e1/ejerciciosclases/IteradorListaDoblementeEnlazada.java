package es.uah.matcomp.ed.e1.ejerciciosclases;

public class IteradorListaDoblementeEnlazada<T> implements IteradorDoble<T> {
    private ElementoDoble<T> actual;

    public IteradorListaDoblementeEnlazada(ElementoDoble<T> cabeza) {
        this.actual = cabeza;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }

    @Override
    public boolean hasPrevious() {
        return actual != null && actual.anterior != null;
    }

    @Override
    public T previous() {
        if (!hasPrevious()) return null;
        actual = actual.anterior;
        return actual.dato;
    }

    @Override
    public void delete() {
        if (actual != null && actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            }
        }
    }
}
