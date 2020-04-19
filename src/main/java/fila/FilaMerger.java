package fila;

public class FilaMerger<T extends Comparable<T>> {
    private FilaEstatica<T> fila1;
    private FilaEstatica<T> fila2;

    public FilaMerger(FilaEstatica<T> fila1, FilaEstatica<T> fila2) {
        this.fila1 = fila1;
        this.fila2 = fila2;
    }

    public FilaEstatica<T> merge() {
        T valor1 = null;
        T valor2 = null;

        FilaEstatica<T> resultado = new FilaEstatica<T>(fila1.tamanho() + fila2.tamanho());

        valor1 = fila1.remove();
        valor2 = fila2.remove();

        while (valor1 != null || valor2 != null) {

            try {
                if (valor1 != null && valor1.compareTo(valor2) < 0) {
                    resultado.insere(valor1);
                    valor1 = null;
                } else {
                    resultado.insere(valor2);
                    valor2 = null;
                }
            } catch (FilaEstatica.FilaCheiaException e) {
                e.printStackTrace();
            }

            if (valor1 == null)
                valor1 = fila1.remove();

            if (valor2 == null)
                valor2 = fila2.remove();
        }

        return resultado;
    }
}
