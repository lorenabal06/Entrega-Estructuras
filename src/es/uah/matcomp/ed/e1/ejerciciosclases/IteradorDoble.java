package es.uah.matcomp.ed.e1.ejerciciosclases;

public interface IteradorDoble<T> extends Iterador<T> {
    boolean hasPrevious();
    T previous();
}
