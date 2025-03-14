package es.uah.matcomp.ed.e1.ejerciciosclases.ListaDoblementeEnlazada;

public class ListaDoblementeEnlazada<T> implements Lista<T> {
    ElementoDoble<T> cabeza;
    ElementoDoble<T> cola;
    private int tamaño;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    @Override
    public boolean add(T dato) {
        ElementoDoble<T> nuevo = new ElementoDoble<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamaño++;
        return true;
    }

    @Override
    public boolean delete(T dato) {
        if (cabeza == null) return false;

        ElementoDoble<T> actual = cabeza;
        while (actual != null && !actual.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual == null) return false; // El dato no existe en la lista

        if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
        } else if (actual == cola) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        tamaño--;
        return true;
    }

    @Override
    public int getNumElementos() {
        return tamaño;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDoblementeEnlazada<>(cabeza, this);
    }

    public void insertBefore(T referencia, T nuevoDato) {
        ElementoDoble<T> actual = cabeza;
        while (actual != null && !actual.dato.equals(referencia)) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            ElementoDoble<T> nuevo = new ElementoDoble<>(nuevoDato);
            nuevo.siguiente = actual;
            nuevo.anterior = actual.anterior;
            if (actual.anterior != null) {
                actual.anterior.siguiente = nuevo;
            } else {
                cabeza = nuevo;
            }
            actual.anterior = nuevo;
            tamaño++;
        }
    }

    public void decrementarTamano() {
        tamaño--;
    }
}
