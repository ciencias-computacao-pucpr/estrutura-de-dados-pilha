package arvore;

import static arvore.ArvoreBinaria.*;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<String> arvore = new ArvoreBinaria<>("A");

        Node<String> b = arvore.getRaiz().esquerdo("B");
        b.esquerdo("D");
        b.direito("E").esquerdo("G");

        Node<String> f = arvore.getRaiz().direito("C").direito("F");
        f.esquerdo("H");
        f.direito("I");

        preOrdem(arvore.getRaiz());
        System.out.println();
        inOrdem(arvore.getRaiz());
        System.out.println();
        posOrdem(arvore.getRaiz());
        System.out.println();
    }
}
