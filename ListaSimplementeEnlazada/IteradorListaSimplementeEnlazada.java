package es.uah.matcomp.ed.e1.ejerciciosclases.ListaSimplementeEnlazada;

public class IteradorListaSimplementeEnlazada<T> implements Iterador<T> {
    private Elemento<T> actual;
    private Elemento<T> previo;
    private Elemento<T> anteriorAlPrevio;
    private ListaSimplementeEnlazada<T> lista;

    public IteradorListaSimplementeEnlazada(Elemento<T> cabeza, ListaSimplementeEnlazada<T> lista) {
        this.actual = cabeza;
        this.previo = null;
        this.anteriorAlPrevio = null;
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null; // Retorna null si no hay más elementos
        }
        T dato = actual.dato;
        anteriorAlPrevio = previo;
        previo = actual;
        actual = actual.siguiente;
        return dato;
    }

    @Override
    public void delete() {
        if (previo != null) {
            if (anteriorAlPrevio == null) {
                lista.cabeza = actual; // Se elimina el primer elemento
            } else {
                anteriorAlPrevio.siguiente = actual; // Se enlaza el anterior al siguiente de previo
            }
            lista.decrementarTamano();
            previo = null;
        }
    }
}
