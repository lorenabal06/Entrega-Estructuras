package es.uah.matcomp.ed.e1.ejerciciosclases;

public class ListaSimplementeEnlazada<T> implements Lista<T> {
    private Elemento<T> cabeza;
    private int tamano;

    public ListaSimplementeEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    @Override
    public boolean add(T dato) {
        Elemento<T> nuevo = new Elemento<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Elemento<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamano++;
        return true;
    }

    @Override
    public boolean delete(T dato) {
        if (cabeza == null) return false;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamano--;
            return true;
        }

        Elemento<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
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
        return new IteradorListaSimplementeEnlazada<>(cabeza);
    }

    // Métodos auxiliares para es.uah.matcomp.ed.e1.ejerciciosclases.Pila y es.uah.matcomp.ed.e1.ejerciciosclases.Cola
    public Elemento<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Elemento<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void incrementarTamano() {
        tamano++;
    }

    public void decrementarTamano() {
        tamano--;
    }
}
