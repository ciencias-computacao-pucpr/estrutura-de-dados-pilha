package arvore;

public class ArvoreBinaria<T extends Comparable<T>> {

    private Node<T> raiz;

    public ArvoreBinaria(T raiz) {
        this.raiz = new Node<>(raiz);
    }

    public Node<T> getRaiz() {
        return raiz;
    }


    public static <T extends Comparable<T>> void preOrdem(Node<T> raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor());
            preOrdem(raiz.getEsquerdo());
            preOrdem(raiz.getDireito());
        }
    }

    public static <T extends Comparable<T>> void inOrdem(Node<T> raiz) {
        if (raiz != null) {
            inOrdem(raiz.getEsquerdo());
            System.out.print(raiz.getValor());
            inOrdem(raiz.getDireito());
        }
    }

    public static <T extends Comparable<T>> void posOrdem(Node<T> raiz) {
        if (raiz != null) {
            posOrdem(raiz.getEsquerdo());
            posOrdem(raiz.getDireito());
            System.out.print(raiz.getValor());
        }
    }
}
