package sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeSort{

    public void ordena(List<Integer> lista) {
        ordena(lista, 0, lista.size()-1);
    }

    public void ordena(List<Integer> array, int indiceInicio, int indiceFim) {

        if (array != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < array.size() && array.size() != 0) {
            int meio = ((indiceFim + indiceInicio) / 2);
            ordena(array, indiceInicio, meio);
            ordena(array, meio + 1, indiceFim);
            merge(array, indiceInicio, meio, indiceFim);
        }
    }

    /**
     * O merge consiste na junção de duas listas já ordenadas.
     * Usa um array auxiliar.
     *
     * @param array
     * @param indiceInicio
     * @param meio
     * @param indiceFim
     */

    public void merge(List<Integer> array, int indiceInicio, int meio, int indiceFim) {

        Integer[] auxiliar =new Integer[array.size()];
        for (int i = indiceInicio; i <= indiceFim; i++) {
            auxiliar[i] = array.get(i);
        }
        int i = indiceInicio;
        int j = meio + 1;
        int k = indiceInicio;

        while (i <= meio && j <= indiceFim) {
            if (auxiliar[i].compareTo(auxiliar[j]) < 0) {
                array.set(k, auxiliar[i]);
                i++;
            } else {
                array.set(k, auxiliar[j]);
                j++;
            }
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (i <= meio) {
            array.set(k, auxiliar[i]);
            i++;
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (j <= indiceFim) {
            array.set(k, auxiliar[j]);
            j++;
            k++;
        }
    }

}