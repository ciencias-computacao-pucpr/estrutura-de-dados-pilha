package fila;

public class Fila<T>{

    private T[] itens;
    private int primeiro = -1;
    private int ultimo = -1;

    public Fila(int capacidade) {
        itens = (T[]) new Object[capacidade];
    }

    public void adicionar(T i) throws FilaCheiaException {
        if (cheia())
            throw new FilaCheiaException();

        if (vazia())
            primeiro = ultimo = 0;
        else if (ultimo == itens.length - 1)
            ultimo = 0;
        else
            ultimo++;

        itens[ultimo] =i;
    }

    private boolean cheia() {
        return tamanho() >= itens.length;
    }

    public T peek() {
        if (vazia())
            return null;
        return itens[primeiro];
    }

    public int tamanho() {
        if (primeiro == -1)
            return 0;

        if (primeiro <= ultimo)
            return ultimo - primeiro + 1;

        return primeiro - ultimo + 1;
    }

    public T remover() {
        if (vazia())
            return null;
        if (tamanho() == 1) {
            T valor = itens[primeiro];
            primeiro = ultimo = -1;
            return valor;
        }

        if (primeiro == itens.length - 1) {
            T valor = itens[primeiro];
            primeiro = 0;
            return valor;
        }

        return itens[primeiro++];

    }

    private boolean vazia() {
        return tamanho() <= 0;
    }

    public String toString() {
        if (vazia())
            return "";

        StringBuilder buider = new StringBuilder();

        if (primeiro <= ultimo) {
            for (int i = primeiro; i <= ultimo; i++) {
                T iten = itens[i];
                buider.append(iten);
                if (i < ultimo)
                    buider.append(", ");
            }
            return buider.toString();
        }

        for (int i = primeiro; i < itens.length; i++) {
            buider.append(itens[i]);
            buider.append(", ");
        }

        for (int i = 0; i <= ultimo; i++) {
            buider.append(itens[i]);

            if (i < ultimo)
                buider.append(itens[i]);
        }

        return buider.toString();
    }

    public static class FilaCheiaException extends Exception {}
    public static class FilaVaziaException extends Exception {}
}
