public class Pilha<T> {
    private Object[] elementos;
    private int tamanho;
    private int topo = -1;

    public Pilha(int tamanho) {
        this.elementos = new Object[tamanho];
        this.tamanho = tamanho;
    }

    public T topo() {
        return (T) elementos[topo];
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == tamanho-1;
    }

    public void empilha(T elemento) {
        if (cheia()) throw new PilhaCheiaException();

        elementos[++topo] = (T)elemento;
    }

    public T desempilha() {
        if (vazia()) throw new PilhaVaziaException();

        return (T) elementos[topo--];
    }

    public static class PilhaVaziaException extends RuntimeException {
    }

    public static class PilhaCheiaException extends RuntimeException {
    }
}
