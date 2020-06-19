package arvore;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static arvore.ArvoreUtils.*;

public class Main {
    public static void main(String[] args) {
//        ArvoreBinaria<String> arvore = new ArvoreBinaria<>("A");
//
//        Node<String> b = arvore.getRaiz().esquerdo("B");
//        b.esquerdo("D");
//        b.direito("E").esquerdo("G");
//
//        Node<String> f = arvore.getRaiz().direito("C").direito("F");
//        f.esquerdo("H");
//        f.direito("I");



//        ArvoreBinaria<String> arvore = new ArvoreBinaria<>("J");
//        Node<String> nodeC = arvore.getRaiz().esquerdo("C");
//        Node<String> nodeM = arvore.getRaiz().direito("M");
//
//        nodeC.esquerdo("B");
//        nodeC.direito("E");
//
//        nodeM.esquerdo("L");
//        nodeM.direito("N");
//        JCBEMLN
//        BCEJLMN
//        BECLNMJ
//        2
//        JCBENL
//        BCEJLN
//        BECLNJ

//        ArvoreBinaria<String> arvore = new ArvoreBinaria<>("J");
//        arvore.inserir("G");
//        arvore.inserir("M");
//        arvore.inserir("B");
//        arvore.inserir("E");
//        arvore.inserir("L");
//        arvore.inserir("N");
//        arvore.inserir("X");
//        arvore.inserir("W");
//        arvore.inserir("V");

        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>(8);
        arvore2.inserir(1);
        imprimir(arvore2);
        arvore2.inserir(7);
        imprimir(arvore2);
        arvore2.inserir(4);
        imprimir(arvore2);
        arvore2.inserir(-1);
        imprimir(arvore2);
        arvore2.inserir(9);
        imprimir(arvore2);
        arvore2.inserir(25);
        imprimir(arvore2);
        arvore2.inserir(10);
        imprimir(arvore2);
        arvore2.inserir(-5);
        imprimir(arvore2);
        arvore2.inserir(-10);
        imprimir(arvore2);
    }

    private static void imprimirTudo(ArvoreBinaria<Integer> arvore2) {
        for (Integer integer : preOrdem(arvore2.getRaiz())) {
            System.out.print(integer);
            System.out.print(" ");
        }
        System.out.println();
//        for (Integer integer : inOrdem(arvore2.getRaiz())) {
//            System.out.print(integer);
//            System.out.print(" ");
//        }
//        System.out.println();
//        for (Integer integer : posOrdem(arvore2.getRaiz())) {
//            System.out.print(integer);
//            System.out.print(" ");
//        }
        System.out.println();
    }


    static <T extends Comparable<T>> void imprimir(Node<T> raiz, int nivel, List<String > linhas) {
        if (raiz == null) return;


        if (nivel  > linhas.size() -1)

            linhas.add(repete(nivel*(3 - raiz.getValor().toString().length()))+raiz.getValor().toString());
        else {
            String s = repete(4 - raiz.getValor().toString().length());
            linhas.set(nivel, linhas.get(nivel) + s + raiz.getValor().toString());
        }
        if (raiz.esquerdo != null) {
            imprimir(raiz.esquerdo, nivel +1,linhas);
        }
        if (raiz.direito != null)
            imprimir(raiz.direito, nivel +1, linhas);
    }

    static String repete(int n ) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(" ");
        }

        return s.toString();
    }

    static <T extends Comparable<T>> void imprimir(ArvoreBinaria<T> raiz) {
        System.out.println("---------------------------------------");
        List<String> ret = new LinkedList<>();
        if (raiz != null) {
            imprimir(raiz.getRaiz(), 0, ret);
        }

        for (String s : ret) {
            System.out.println(s);
            for (int i = 0; i <= count(s);i++) {
                System.out.print(" /");
                System.out.print(" \\");
            }
            System.out.println();
        }
    }

    private static int count(String s) {
        int c = 0;
        for (Character ch : s.toCharArray()) {
            if (ch.equals(' ')) c++;
        }
        return c;
    }


}
