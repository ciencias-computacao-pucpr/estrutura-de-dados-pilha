package fila;

public interface Fila<T> {
    void insere(T i);

    T frente();

    T remove();

    boolean vazia();

    String toString();
}
