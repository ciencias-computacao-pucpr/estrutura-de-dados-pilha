import java.util.Optional;

public class Pilha<T> {
    private T[] elementos;
    private int topo = -1;

    public Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
    }

    public T topo() {
        if (topo < 0 || topo >= elementos.length)
            return null;
        return elementos[topo];
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == elementos.length - 1;
    }

    public void empilha(T elemento) {
        if (cheia()) throw new PilhaCheiaException();

        elementos[++topo] = elemento;
    }

    public T desempilha() {
        if (vazia()) throw new PilhaVaziaException();

        return elementos[topo--];
    }

    public static class PilhaVaziaException extends RuntimeException {
    }

    public static class PilhaCheiaException extends RuntimeException {
    }
}
