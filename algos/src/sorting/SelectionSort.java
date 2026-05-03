package sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static List<Integer> selectionSort(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<>();
        List<Integer> copiedArr = new ArrayList<>(arr);

        for (int i = 0; i < arr.size(); i++) {
            int smallestIdx = findSmallest(copiedArr);
            newArr.add(copiedArr.get(smallestIdx));
            copiedArr.remove(smallestIdx);
        }

        return newArr;
    }

    public static int findSmallest(List<Integer> arr) {
        int smallest = arr.getFirst();
        int smallestIdx = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIdx = i;
            }
        }

        return smallestIdx;
    }
}
