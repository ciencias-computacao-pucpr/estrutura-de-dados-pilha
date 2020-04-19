package fila;

import lista.Lista;
import lista.ListaEncadeada;
import lista.Node;

public class FilaEncadeada<T extends Comparable<T>> implements Fila<T> {

    private Lista<T> lista;

    public FilaEncadeada() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void insere(T i) {
        lista.insereUltimo(i);
    }

    @Override
    public T frente() {
        Node<T> node = lista.valorEm(0);
        return node == null ? null : node.getInfo();
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean vazia() {
        return lista.vazia();
    }
}
