package es.uah.matcomp.ed.e1.ejerciciosclases.PilaYCola;

public class IteradorListaSimplementeEnlazada<T> implements Iterador<T> {
    private Elemento<T> actual;
    private Elemento<T> previo;

    public IteradorListaSimplementeEnlazada(Elemento<T> cabeza) {
        this.actual = cabeza;
        this.previo = null;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null; // No se lanza excepción, retorna null
        }
        T dato = actual.dato;
        previo = actual;
        actual = actual.siguiente;
        return dato;
    }

    @Override
    public void delete() {
        if (previo != null) {
            previo.siguiente = actual != null ? actual.siguiente : null;
        }
    }
}
