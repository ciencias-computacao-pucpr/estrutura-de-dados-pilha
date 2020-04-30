package arvore;

public class Node<T extends Comparable<T>>  {
    T info;
    Node<T> esquerdo;
    Node<T> direito;

    public Node(T raiz) {
        info = raiz;
    }

    public Node<T> esquerdo(T info) {
        esquerdo = new Node<>(info);
        return esquerdo;
    }

    public Node<T> direito(T info) {
        direito = new Node<>(info);
        return direito;
    }

    public Node<T> getDireito() {
        return direito;
    }

    public Node<T> getEsquerdo() {
        return esquerdo;
    }

    public T getValor() {
        return info;
    }

    public void setValor(T valor) {
        info = valor;
    }

}
