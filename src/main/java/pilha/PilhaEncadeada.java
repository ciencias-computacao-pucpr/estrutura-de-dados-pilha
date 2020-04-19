package pilha;

import lista.Lista;
import lista.ListaEncadeada;
import lista.Node;
import pilha.exception.PilhaVaziaException;

public class PilhaEncadeada<T extends Comparable<T>> implements Pilha<T> {

    private final Lista<T> lista;

    public PilhaEncadeada() {
        lista = new ListaEncadeada<T>();
    }

    @Override
    public T topo() {
        Node<T> node = lista.getPrimeiro();
        if (node == null)
            return null;
        return node.getInfo();
    }

    @Override
    public boolean vazia() {
        return lista.vazia();
    }

    @Override
    public boolean cheia() {
        return false;
    }

    @Override
    public void empilha(T elemento) {
        lista.inserePrimeiro(elemento);
    }

    @Override
    public T desempilha() {
        if (vazia())
            throw new PilhaVaziaException();
        return lista.removePrimeiro().getInfo();
    }
}
