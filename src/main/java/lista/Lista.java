package lista;

public interface Lista<T extends Comparable<T>> {
    boolean vazia();

    void inserePrimeiro(T info);

    void insereDepois(Node<T> node, T info);

    void insereUltimo(T info);

    void insereOrdenado(T info);

    String toString();

    Node<T> valorEm(int pos);

    Node<T> removePrimeiro();

    Node<T> removeUltimo();

    Node<T> getPrimeiro();

    Node<T> getUltimo();

    Node<T> remove(Node<T> node);
}
