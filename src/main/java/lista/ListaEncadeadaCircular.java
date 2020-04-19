package lista;

import java.util.Iterator;

public class ListaEncadeadaCircular<T extends Comparable<T>> implements Lista<T>, Iterable<T> {
    private Node<T> primeiro = null;

    @Override
    public boolean vazia() {
        return primeiro == null;
    }

    @Override
    public void inserePrimeiro(T info) {
        Node<T> novoPrimeiro = new Node<>(info);
        if (primeiro != null) {
            novoPrimeiro.prox = primeiro;
            ultimo().prox = novoPrimeiro;
        } else {
            novoPrimeiro.prox = novoPrimeiro;
        }
        primeiro = novoPrimeiro;
    }

    private Node<T> ultimo() {
        Node<T> n = primeiro;
        while (!isUltimo(n)) {
            n = n.prox;
        }

        return n;
    }
    @Override
    public void insereDepois(Node<T> node, T info) {
        Node<T> valor = new Node<>(info);
        if (node.prox != null) {
            valor.prox = node.prox;
        }

        node.prox = valor;
    }

    @Override
    public void insereUltimo(T info) {

        Node<T> novoUltimo = new Node<>(info);

        if (primeiro == null) {
            inserePrimeiro(info);
            return;
        }

        Node<T> ultimoAtual = ultimo();

        ultimoAtual.prox = novoUltimo;
        novoUltimo.prox = primeiro;
    }


    @Override
    public void insereOrdenado(T info) {
        if (primeiro == null) {
            inserePrimeiro(info);
            return;
        }

        if (info.compareTo(primeiro.info) <= 0) {
            inserePrimeiro(info);
            return;
        }

        for (Node<T> node = primeiro; !isUltimo(node); node = node.prox) {
            if (info.compareTo(node.info) > 0 && info.compareTo(node.prox.info) <= 0) {
                insereDepois(node, info);
                return;
            }
        }

        insereUltimo(info);
    }

    private boolean isUltimo(Node<T> no) {
        return no.prox == primeiro;
    }

    @Override
    public String imprime() {
        StringBuilder builder = new StringBuilder();

        for (T n : this) {
            if (builder.length() > 0)
                builder.append(", ");

            builder.append(n);
        }

        return builder.toString();
    }

    @Override
    public Node<T> valorEm(int pos) {
        int idx = 0;

        Node<T> n = primeiro;

        while (n != null && idx < pos) {
            n = n.prox;
            idx++;
        }

        return n;
    }

    @Override
    public Node<T> removePrimeiro() {
        return null;
    }

    @Override
    public Node<T> removeUltimo() {
        return null;
    }

    @Override
    public Node<T> remove(Node<T> node) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> atual = null;

            @Override
            public boolean hasNext() {
                return (atual == null && primeiro != null) ||
                        (atual != null && atual.prox != primeiro);
            }

            @Override
            public T next() {
                if (atual == null) {
                    atual = primeiro;
                    return atual.info;
                }
                atual = atual.prox;
                return atual.info;
            }
        };
    }
}
