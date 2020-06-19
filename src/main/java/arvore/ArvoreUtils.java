package arvore;

import java.util.LinkedList;
import java.util.List;

public final class ArvoreUtils {
    public static <T extends Comparable<T>> List<T> preOrdem(Node<T> raiz) {
        List<T> result = new LinkedList<>();
        preOrdem(raiz,result);
        return result;
    }

    private static <T extends Comparable<T>> void preOrdem(Node<T> raiz, List<T> result) {
        if (raiz != null) {
            result.add(raiz.getValor());
            preOrdem(raiz.getEsquerdo(), result);
            preOrdem(raiz.getDireito(), result);
        }
    }

    public static <T extends Comparable<T>> List<T> inOrdem(Node<T> raiz) {
        List<T> result = new LinkedList<>();
        inOrdem(raiz,result);
        return result;
    }

    private static <T extends Comparable<T>> void inOrdem(Node<T> raiz, List<T> result) {
        if (raiz != null) {
            inOrdem(raiz.getEsquerdo(),result);
            result.add(raiz.getValor());
            inOrdem(raiz.getDireito(),result);
        }
    }

    public static <T extends Comparable<T>> List<T> posOrdem(Node<T> raiz) {
        List<T> result = new LinkedList<>();
        posOrdem(raiz,result);
        return result;
    }
    private static <T extends Comparable<T>> void posOrdem(Node<T> raiz, List<T> result) {
        if (raiz != null) {
            posOrdem(raiz.getEsquerdo(),result);
            posOrdem(raiz.getDireito(),result);
            result.add(raiz.getValor());
        }
    }


    public static <T extends Comparable<T>> int altura(Node<T> raiz) {
        if (raiz == null) return -1;

        int esquerdo = altura(raiz.esquerdo);
        int direito = altura(raiz.direito);

        if ( esquerdo > direito )
            return 1 + esquerdo;

        return 1 + direito;
    }
}
