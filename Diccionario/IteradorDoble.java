package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

public interface IteradorDoble<T> extends Iterador<T> {
    boolean hasPrevious();
    T previous();
}
