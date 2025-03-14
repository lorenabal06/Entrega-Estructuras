package es.uah.matcomp.ed.e1.ejerciciosclases;

public interface Iterador<T> {
    boolean hasNext();
    T next();
    void delete();
}
