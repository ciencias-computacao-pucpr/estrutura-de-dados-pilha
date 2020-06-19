package sorting;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static sorting.SortUtils.isSorted;

public class Main {
    public static void main(String[] args) {
        testarAlgoritmo(1000);
        testarAlgoritmo(10000);
        testarAlgoritmo(40000);
    }

    private static long testarAlgoritmo(int t) {
        List<Integer> listaOrdenada = criaListaOrdenada(t);
        List<Integer> listaPoucoBanguncada = SortUtils.shuffle(listaOrdenada, (int) (t * 0.1));
        List<Integer> listaTotalmenteBaguncada = SortUtils.shuffle(listaOrdenada);
        List<Integer> listaDecrescente = reverse(listaOrdenada);

        long t1 = ordernarTemporizadoHeap(listaPoucoBanguncada);
        long t2 = ordernarTemporizadoHeap(listaTotalmenteBaguncada);
        long t3 = ordernarTemporizadoHeap(listaDecrescente);

        System.out.println("Algoritmo: HeapSort");
        System.out.println(MessageFormat.format("Ordenou MergeSort {3}: {0} {1} {2}", isSorted(listaPoucoBanguncada), isSorted(listaTotalmenteBaguncada), isSorted(listaDecrescente),t));
        System.out.println(MessageFormat.format("    Tempo pouco baguncada:      {0}", t1));
        System.out.println(MessageFormat.format("    Tamanho bastante baguncada: {0}", t2));
        System.out.println(MessageFormat.format("    Tamanho decrescente:        {0}", t3));
        System.out.println();

        listaPoucoBanguncada = SortUtils.shuffle(listaOrdenada, (int) (t * 0.1));
        listaTotalmenteBaguncada = SortUtils.shuffle(listaOrdenada);
        listaDecrescente = reverse(listaOrdenada);

        long t4 = ordernarTemporizadoMerge(listaPoucoBanguncada);
        long t5 = ordernarTemporizadoMerge(listaTotalmenteBaguncada);
        long t6 = ordernarTemporizadoMerge(listaDecrescente);

        System.out.println("Algoritmo: MergeSort");
        System.out.println(MessageFormat.format("Ordenou MergeSort {3}: {0} {1} {2}", isSorted(listaPoucoBanguncada), isSorted(listaTotalmenteBaguncada), isSorted(listaDecrescente),t));
        System.out.println(MessageFormat.format("    Tempo pouco baguncada:      {0}", t4));
        System.out.println(MessageFormat.format("    Tamanho bastante baguncada: {0}", t5));
        System.out.println(MessageFormat.format("    Tamanho decrescente:        {0}", t6));
        System.out.println();

        listaPoucoBanguncada = SortUtils.shuffle(listaOrdenada, (int) (t * 0.1));
        listaTotalmenteBaguncada = SortUtils.shuffle(listaOrdenada);
        listaDecrescente = reverse(listaOrdenada);

        long t7 = ordernarTemporizadoShell(listaPoucoBanguncada);
        long t8 = ordernarTemporizadoShell(listaTotalmenteBaguncada);
        long t9 = ordernarTemporizadoShell(listaDecrescente);

        System.out.println(MessageFormat.format("Ordenou ShellSort {3}: {0} {1} {2}", isSorted(listaPoucoBanguncada), isSorted(listaTotalmenteBaguncada), isSorted(listaDecrescente),t));
        System.out.println(MessageFormat.format("    Tempo pouco baguncada:      {0}", t7));
        System.out.println(MessageFormat.format("    Tamanho bastante baguncada: {0}", t8));
        System.out.println(MessageFormat.format("    Tamanho decrescente:        {0}", t9));
        System.out.println();

        return 0;
    }


    private static List<Integer> reverse(List<Integer> listaOrdenada) {
        List<Integer> reverse = new LinkedList<>(listaOrdenada);
        Collections.reverse(reverse);
        return reverse;
    }
    private static long ordernarTemporizadoShell(List<Integer> listaPoucoBanguncada) {
        Instant inicio = Instant.now();
        shellSort(listaPoucoBanguncada);
        Instant fim = Instant.now();
        return Duration.between(inicio, fim).toMillis();
    }


    private static long ordernarTemporizadoHeap(List<Integer> lista) {
        Instant inicio = Instant.now();
        heapSort(lista);
        Instant fim = Instant.now();
        return Duration.between(inicio, fim).toMillis();
    }
    private static long ordernarTemporizadoMerge(List<Integer> lista) {
        Instant inicio = Instant.now();
        new MergeSort().ordena(lista);
        Instant fim = Instant.now();
        return Duration.between(inicio, fim).toMillis();
    }


    private static List<Integer> criaListaOrdenada(int tam) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < tam; i++) {
            res.add(i);
        }
        return res;
    }

    public static void shellSort(List<Integer> nums) {
        int h = 1;
        int n = nums.size();

        while(h < n) {
            h = h * 3 + 1;
        }

        h = h / 3;
        int c, j;

        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = nums.get(i);
                j = i;
                while (j >= h && nums.get(j - h) > c) {
                    nums.set(j, nums.get(j - h));
                    j = j - h;
                }
                nums.set(j, c);
            }
            h = h / 2;
        }
    }

    public static void heapSort(List<Integer> vetor) {
        int tamanho = vetor.size();
        int i = tamanho / 2, pai, filho, t;

        while (true) {
            if (i > 0) {
                i--;
                t = vetor.get(i);
            } else {
                tamanho--;
                if (tamanho <= 0) {
                    return;
                }
                t = vetor.get(i);
                vetor.set(tamanho,vetor.get(0));
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tamanho) {
                if ((filho + 1 < tamanho) && (vetor.get(filho + 1) > vetor.get(filho))) {
                    filho++;
                }
                if (vetor.get(filho) > t) {
                    vetor.set(pai, vetor.get(filho));
                    pai = filho;
                    filho = pai * 2 + 1;
                } else {
                    break;
                }
            }
            vetor.set(pai, t);
        }
    }


}
