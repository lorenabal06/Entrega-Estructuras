package es.uah.matcomp.ed.e1.ejerciciosclases;

public class Pila<T> {
    private ListaSimplementeEnlazada<T> lista;

    public Pila() {
        this.lista = new ListaSimplementeEnlazada<>();
    }

    public void push(T elemento) {
        // Agregar el elemento en la cabeza en lugar del final para hacer `pop()` O(1)
        Elemento<T> nuevo = new Elemento<>(elemento);
        if (lista.getCabeza() == null) {
            lista.setCabeza(nuevo);
        } else {
            nuevo.siguiente = lista.getCabeza();
            lista.setCabeza(nuevo);
        }
        lista.incrementarTamano();
    }

    public T pop() {
        if (lista.getNumElementos() == 0) {
            return null; // Retorna null si la pila está vacía
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
