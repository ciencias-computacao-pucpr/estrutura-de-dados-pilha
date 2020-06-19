package arvore;

public class Node<T extends Comparable<T>>  {
    T info;
    Node<T> esquerdo;
    Node<T> direito;

    public Node(T valor) {
        info = valor;
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

    public boolean isFolha() {
        return esquerdo == null && direito == null;
    }

    public boolean menorQue(Node<T> outro) {
        return info.compareTo(outro.info) < 0;
    }
    public boolean menorQue(T outro) {
        return info.compareTo(outro) < 0;
    }

    public boolean maiorQue(Node<T> outro) {
        return info.compareTo(outro.info) > 0;
    }
    public boolean maiorQue(T outro) {
        return info.compareTo(outro) > 0;
    }

    public boolean igual(Node<T> outro) {
        return info.compareTo(outro.info) == 0;
    }
    public boolean igual(T outro) {
        return info.compareTo(outro) == 0;
    }

}
