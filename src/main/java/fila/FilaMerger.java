package fila;

public class FilaMerger<T extends Comparable<T>> {
    private Fila<T> fila1;
    private Fila<T> fila2;

    public FilaMerger(Fila<T> fila1, Fila<T> fila2) {
        this.fila1 = fila1;
        this.fila2 = fila2;
    }

    public Fila<T> merge() {
        T valor1 = null;
        T valor2 = null;

        Fila<T> resultado = new Fila<T>(fila1.tamanho() + fila2.tamanho());

        valor1 = fila1.remover();
        valor2 = fila2.remover();

        while (valor1 != null || valor2 != null) {

            try {
                if (valor1 != null && valor1.compareTo(valor2) < 0) {
                    resultado.adicionar(valor1);
                    valor1 = null;
                } else {
                    resultado.adicionar(valor2);
                    valor2 = null;
                }
            } catch (Fila.FilaCheiaException e) {
                e.printStackTrace();
            }

            if (valor1 == null)
                valor1 = fila1.remover();

            if (valor2 == null)
                valor2 = fila2.remover();
        }

        return resultado;
    }
}
