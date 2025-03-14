package es.uah.matcomp.ed.e1.ejerciciosclases.PilaYCola;

public class Cola<T> {
    private ListaSimplementeEnlazada<T> lista;

    public Cola() {
        this.lista = new ListaSimplementeEnlazada<>();
    }

    public void enqueue(T elemento) {
        lista.add(elemento);
    }

    public T dequeue() {
        if (lista.getNumElementos() == 0) {
            return null; // Retorna null si la cola está vacía
        }

        T dato = lista.getCabeza().dato;
        lista.setCabeza(lista.getCabeza().siguiente);
        lista.decrementarTamano();
        return dato;
    }

    public boolean isEmpty() {
        return lista.getNumElementos() == 0;
    }

    public int size() {
        return lista.getNumElementos();
    }

    public T peek() {
        return (lista.getCabeza() != null) ? lista.getCabeza().dato : null;
    }
}
