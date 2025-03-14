package es.uah.matcomp.ed.e1.ejerciciosclases;

public class DiccionarioBasico<K, V> {
    protected ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista;

    public DiccionarioBasico() {
        this.lista = new ListaDoblementeEnlazada<>();
    }

    public void add(K clave, V valor) {
        lista.add(new ElementoDiccionario<>(clave, valor));
    }

    public boolean delete(K clave) {
        Iterador<ElementoDiccionario<K, V>> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            if (iterador.next().getClave().equals(clave)) {
                iterador.delete();
                return true;
            }
        }
        return false;
    }

    public V get(K clave) {
        Iterador<ElementoDiccionario<K, V>> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            ElementoDiccionario<K, V> elemento = iterador.next();
            if (elemento.getClave().equals(clave)) {
                return elemento.getValor();
            }
        }
        return null;
    }

    public Iterador<ElementoDiccionario<K, V>> getIterador() {
        return lista.getIterador();
    }
}
