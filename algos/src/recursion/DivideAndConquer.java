package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DivideAndConquer {
    void main() {
        System.out.println(sum(List.of(5, 2, 3, 19)));
        System.out.println(countElements(List.of(3, 4, 5, 6, 7)));
        System.out.println(findMax(List.of(3, 7, 4, 5, 6)));
        System.out.println(binarySearch(23, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 23, 40)));
        System.out.println(quckSort(List.of(3, 6, 2, 8, 1, 4)));
    }

    public static int sum(List<Integer> arr) {
        if (arr.isEmpty()) return 0;
        return arr.getFirst() + sum(arr.subList(1, arr.size()));
    }

    public static int countElements(List<Integer> arr) {
        if (arr.isEmpty()) return 0;
        return 1 + countElements(arr.subList(1, arr.size()));
    }

    public static int findMax(List<Integer> arr) {
        if (arr.isEmpty()) throw new NoSuchElementException("empty list");
        int first = arr.getFirst();
        if (arr.size() == 1) return first;
        int tailMax = findMax(arr.subList(1, arr.size()));
        return Math.max(first, tailMax);
    }

    public static int binarySearch(int tar, List<Integer> arr) {
        return binarySearch(tar, arr, 0, arr.size() - 1);
    }

    public static int binarySearch(int tar, List<Integer> arr, int low, int high) {
        if (low > high) return -1; // база

        int mid = low + (high - low) / 2;
        int midVal = arr.get(mid);

        if (midVal == tar) return mid; // база
        else if (midVal > tar) {
            return binarySearch(tar, arr, low, mid - 1); // рекурсия
        } else {
            return binarySearch(tar, arr, mid + 1, high); // рекурсия
        }
    }

    public static List<Integer> quckSort(List<Integer> arr) {
        if (arr.size() < 2) return arr;

        else {
            int pivot = arr.getFirst();
            List<Integer> rest = arr.subList(1, arr.size());

            List<Integer> less = rest
                    .stream()
                    .filter(i -> i <= pivot)
                    .toList();
            List<Integer> greater = rest
                    .stream()
                    .filter(i -> i > pivot)
                    .toList();

//            List<Integer> less = new ArrayList<>();
//            List<Integer> greater = new ArrayList<>();
//
//            for (int i : rest) {
//                if (i <= pivot) less.add(i);
//                else greater.add(i);
//            }

            List<Integer> result = new ArrayList<>(quckSort(less));
            result.add(pivot);
            result.addAll(quckSort(greater));
            return result;
        }
    }
}
