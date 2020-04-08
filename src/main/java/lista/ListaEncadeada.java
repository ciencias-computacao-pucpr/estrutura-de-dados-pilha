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
            primeiro = valor;
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
    public String imprime() {
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

}
