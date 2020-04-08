package lista;

public interface Lista<T extends Comparable<T>> {
    boolean vazia();

    void inserePrimeiro(T info);

    void insereDepois(Node<T> node, T info);

    void insereUltimo(T info);

    void insereOrdenado(T info);

    String imprime();

    Node<T> valorEm(int pos);
}
