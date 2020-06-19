package sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SortUtils {
    public static List<Integer> shuffle(List<Integer> items) {
        return shuffle(items, items.size());
    }

    public static List<Integer> shuffle(List<Integer> items, int quantidade) {
        List<Integer> result = new LinkedList<>(items);
        final Random random = new Random();

        for (int index = 0; index < quantidade; index++) {
            final int randomIndex = random.nextInt(quantidade);
            result = swap(result, index, randomIndex);
        }

        return result;
    }

    public static List<Integer> swap(List<Integer> sourceList, final int idxA, final int idxB) {
        List<Integer> nextStep = new LinkedList<>(sourceList);
        nextStep.set(idxA, sourceList.get(idxB));
        nextStep.set(idxB, sourceList.get(idxA));
        return nextStep;
    }


    public static boolean isSorted(List<Integer> list) {
        for (int index = 0, lastItemIndex = list.size() - 1; index < lastItemIndex; index++) {
            Integer integer = list.get(index);
            Integer nextValue = list.get(index + 1);
            if (integer > nextValue)
                return false;
        }
        return true;
    }
}