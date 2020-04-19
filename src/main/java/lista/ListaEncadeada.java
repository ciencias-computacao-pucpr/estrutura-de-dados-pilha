package lista;

public class ListaEncadeada<T extends Comparable<T>> implements Lista<T> {
    private Node<T> primeiro = null;

    @Override
    public boolean vazia() {
        return primeiro == null;
    }

    @Override
    public void inserePrimeiro(T info) {
        Node<T> valor = new Node<>(info);
        if (primeiro != null) {
            valor.prox = primeiro;
        }
        primeiro = valor;
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
        Node<T> ultimo = primeiro;
        Node<T> valor = new Node<>(info);

        if (ultimo == null) {
            primeiro = valor;
            return;
        }

        while (ultimo.prox != null) {
            ultimo = ultimo.prox;
        }

        ultimo.prox = valor;
    }

    @Override
    public void insereOrdenado(T info) {
        Node<T> valor = new Node<>(info);

        if (primeiro == null) {
            inserePrimeiro(info);
            return;
        }

        Node<T> aComparar = primeiro;

        if (info.compareTo(aComparar.info) <=0) {
            valor.prox = primeiro;
            primeiro = valor;
            return;
        }

        while (aComparar != null) {
            if (info.compareTo(aComparar.info) > 0 && (aComparar.prox == null || info.compareTo(aComparar.prox.info) <=0)) {
                insereDepois(aComparar, info);
                return;
            }
            aComparar = aComparar.prox;
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> n = primeiro;

        while (n != null) {
            if (builder.length() > 0)
                builder.append(", ");

            builder.append(n.info);
            n = n.prox;
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
        if (primeiro == null)
            return null;

        Node<T> nodeARemover = primeiro;
        Node<T> novoPrimeiro = primeiro.prox;
        nodeARemover.prox = null;
        primeiro = novoPrimeiro;
        return nodeARemover;
    }

    @Override
    public Node<T> removeUltimo() {
        Node<T> node = this.primeiro;
        if (node == null)
            return null;

        if (node.prox == null)
            removePrimeiro();

        Node<T> penultimo = node;
        node = node.prox;
        while (node.prox != null) {
            penultimo = node;
            node = node.prox;
        }

        penultimo.prox = null;
        return node;
    }

    @Override
    public Node<T> remove(Node<T> nodeARemover) {
        if (primeiro == null)
            return null;

        if (primeiro == nodeARemover) {
            return removePrimeiro();
        }

        for (Node<T> n = primeiro; n.prox != null; n = n.prox) {
            if (n.prox == nodeARemover) {
                n.prox = nodeARemover.prox;
                nodeARemover.prox = null;
                return nodeARemover;
            }
        }
        return null;
    }

    @Override
    public Node<T> getPrimeiro() {
        return primeiro;
    }

    @Override
    public Node<T> getUltimo() {
        Node<T> node= primeiro;
        while (node.prox != null)
            node = node.prox;
        return node;
    }
}
