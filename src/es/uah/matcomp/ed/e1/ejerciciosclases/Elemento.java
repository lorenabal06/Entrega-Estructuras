package es.uah.matcomp.ed.e1.ejerciciosclases;

public class Elemento<T> {
    public T dato;
    public Elemento<T> siguiente;

    public Elemento(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Elemento<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Elemento<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Elemento{" + "dato=" + dato + '}';
    }
}


