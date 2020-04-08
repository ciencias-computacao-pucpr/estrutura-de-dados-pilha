package lista;

public class Node <T> {
    final T info;
    Node<T> prox;

    public Node(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
}
