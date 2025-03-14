package es.uah.matcomp.ed.e1.ejerciciosclases.ListaBasica;

import java.util.Arrays;

public class ListaBasica<T> implements Lista<T> {
    private Object[] elementos;
    private int size;

    public ListaBasica() {
        elementos = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T elemento) {
        if (size == elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length * 2);
        }
        elementos[size++] = elemento;
        return true;
    }

    @Override
    public boolean delete(T elemento) {
        for (int i = 0; i < size; i++) {
            if ((elementos[i] != null && elementos[i].equals(elemento)) || (elementos[i] == null && elemento == null)) {
                System.arraycopy(elementos, i + 1, elementos, i, size - i - 1);
                elementos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaBasica();
    }

    @Override
    public int getNumElementos() {
        return size;
    }

    private class IteradorListaBasica implements Iterador<T> {
        private int indice = 0;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {
            return indice < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                lastReturnedIndex = indice;
                return (T) elementos[indice++];
            }
            return null;
        }

        @Override
        public void delete() {
            if (lastReturnedIndex != -1) {
                System.arraycopy(elementos, lastReturnedIndex + 1, elementos, lastReturnedIndex, size - lastReturnedIndex - 1);
                elementos[--size] = null;
                indice = lastReturnedIndex;
                lastReturnedIndex = -1;
            }
        }
    }
}
