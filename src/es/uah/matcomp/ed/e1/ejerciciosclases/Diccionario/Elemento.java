package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

public class Elemento<T> {
    T dato;
    Elemento<T> siguiente;

    public Elemento(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

