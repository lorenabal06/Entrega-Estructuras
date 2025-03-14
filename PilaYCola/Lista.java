package es.uah.matcomp.ed.e1.ejerciciosclases.PilaYCola;

public interface Lista<T> {
    boolean add(T elemento);
    boolean delete(T elemento);
    Iterador<T> getIterador();
    int getNumElementos();
}
