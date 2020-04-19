package pilha;

import pilha.exception.PilhaCheiaException;
import pilha.exception.PilhaVaziaException;

public class PilhaEstatica<T> implements Pilha<T> {
    private T[] elementos;
    private int topo = -1;

    public PilhaEstatica(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
    }

    @Override
    public T topo() {
        if (topo < 0 || topo >= elementos.length)
            return null;
        return elementos[topo];
    }

    @Override
    public boolean vazia() {
        return topo == -1;
    }

    @Override
    public boolean cheia() {
        return topo == elementos.length - 1;
    }

    @Override
    public void empilha(T elemento) {
        if (cheia()) throw new PilhaCheiaException();

        elementos[++topo] = elemento;
    }

    @Override
    public T desempilha() {
        if (vazia()) throw new PilhaVaziaException();

        return elementos[topo--];
    }




}
