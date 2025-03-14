package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;
public class DiccionarioBasico<K, V> {
    protected ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista;

    public DiccionarioBasico() {
        this.lista = new ListaDoblementeEnlazada<>();
    }

    // Si la clave ya existe (incluso si su valor es null) se actualiza el valor;
    // de lo contrario se añade el nuevo elemento.
    public void add(K clave, V valor) {
        Iterador<ElementoDiccionario<K, V>> iterador = lista.getIterador();

        while (iterador.hasNext()) {
            ElementoDiccionario<K, V> elemento = iterador.next();
            if (elemento.getClave().equals(clave)) {
                elemento.setValor(valor);
                return;
            }
        }
        lista.add(new ElementoDiccionario<>(clave, valor));
    }

    // Soft delete: en lugar de eliminar el nodo, se establece el valor a null.
    public boolean delete(K clave) {
        Iterador<ElementoDiccionario<K, V>> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            ElementoDiccionario<K, V> elemento = iterador.next();
            if (elemento.getClave().equals(clave)) {
                elemento.setValor(null);
                return true;
            }
        }
        return false;
    }

    // Retorna el valor asociado a la clave; si está marcado como eliminado, devuelve null.
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

