package pilha;

public interface Pilha<T> {
    T topo();

    boolean vazia();

    boolean cheia();

    void empilha(T elemento);

    T desempilha();
}
