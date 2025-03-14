package es.uah.matcomp.ed.e1.ejerciciosclases.Diccionario;

import java.util.Objects;

public class ElementoDiccionario<K, V> {
    private K clave;
    private V valor;

    public ElementoDiccionario(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ElementoDiccionario<?, ?> that = (ElementoDiccionario<?, ?>) obj;
        return Objects.equals(clave, that.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave);
    }
}

