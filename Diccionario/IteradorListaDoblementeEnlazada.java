package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

public class IteradorListaDoblementeEnlazada<T> implements IteradorDoble<T> {
    private ElementoDoble<T> actual;
    private ElementoDoble<T> ultimoDevuelto;
    private ListaDoblementeEnlazada<T> lista;

    public IteradorListaDoblementeEnlazada(ElementoDoble<T> cabeza, ListaDoblementeEnlazada<T> lista) {
        this.actual = cabeza;
        this.ultimoDevuelto = null;
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        ultimoDevuelto = actual;
        actual = actual.siguiente;
        return ultimoDevuelto.dato;
    }

    @Override
    public boolean hasPrevious() {
        return ultimoDevuelto != null && ultimoDevuelto.anterior != null;
    }

    @Override
    public T previous() {
        if (!hasPrevious()) return null;
        actual = ultimoDevuelto;
        ultimoDevuelto = actual.anterior;
        return actual.dato;
    }

    @Override
    public void delete() {
        if (ultimoDevuelto != null) {
            if (ultimoDevuelto.anterior != null) {
                ultimoDevuelto.anterior.siguiente = ultimoDevuelto.siguiente;
            } else {
                lista.cabeza = ultimoDevuelto.siguiente;
            }

            if (ultimoDevuelto.siguiente != null) {
                ultimoDevuelto.siguiente.anterior = ultimoDevuelto.anterior;
            } else {
                lista.cola = ultimoDevuelto.anterior;
            }

            lista.decrementarTamano();
            ultimoDevuelto = null;
        }
    }
}

