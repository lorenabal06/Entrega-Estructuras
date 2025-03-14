package es.uah.matcomp.ed.e1.ejerciciosclases.PilaYCola;

public interface Iterador<T> {
    boolean hasNext();
    T next();
    void delete();
}
