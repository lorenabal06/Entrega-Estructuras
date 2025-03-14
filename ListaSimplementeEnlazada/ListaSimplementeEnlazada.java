package es.uah.matcomp.ed.e1.ejerciciosclases.ListaSimplementeEnlazada;

public class ListaSimplementeEnlazada<T> implements Lista<T> {
    Elemento<T> cabeza;
    private Elemento<T> cola;
    private int tamano;

    public ListaSimplementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    @Override
    public boolean add(T dato) {
        Elemento<T> nuevo = new Elemento<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamano++;
        return true;
    }

    @Override
    public boolean delete(T dato) {
        if (cabeza == null) return false;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) cola = null;
            tamano--;
            return true;
        }

        Elemento<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            if (actual.siguiente == cola) {
                cola = actual;
            }
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            return true;
        }
        return false;
    }

    @Override
    public int getNumElementos() {
        return tamano;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaSimplementeEnlazada<>(cabeza, this);
    }

    public void decrementarTamano() {
        tamano--;
    }
}

