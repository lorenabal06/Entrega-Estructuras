package es.uah.matcomp.ed.e1.ejerciciosclases.ListaDoblementeEnlazada;

public interface Iterador<T> {
    boolean hasNext();
    T next();
    void delete();
}
