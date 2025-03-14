package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

public interface Iterador<T> {
    boolean hasNext();
    T next();
    void delete();
}
