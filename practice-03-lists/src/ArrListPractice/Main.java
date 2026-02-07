package ArrListPractice;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        var main = new Main();

        var firstList = List.of("test", "bolshoi test", "ehso test", "aga", "test", "vot", "nu i tak");
        var secondList = List.of("test", "bolshoi test", "ehso test", "aga", "vot", "test");

        System.out.println(main.filterStrsByLen(firstList, 4));
        System.out.println(main.countDuplicates(secondList, "test"));
        System.out.println(main.mergeLists(firstList, secondList));
        System.out.println(main.filterStrsByLen(firstList, 5));
        System.out.println(main.changeStr(secondList, "test", "ogogo"));
        System.out.println(main.getMaxLenStr(firstList));
        System.out.println(main.removeDuplicates(firstList));
        System.out.println(main.printLastActions(firstList, 3));
        System.out.println(main.removeBlackList(firstList, secondList));
    }

    public List<String> filterStrsByLen(@NotNull List<String> arr, int tar) {
        var arrCopy = new ArrayList<>(arr);
        arrCopy.removeIf(s -> s.length() < tar);
        return arrCopy;
    }

    public int countDuplicates(@NotNull List<String> arr, String tar) {
        int count = 0;

        for (var s : arr) {
            if (s.equals(tar)) {
                count++;
            }
        }

        return count;
    }

    public List<String> mergeLists(@NotNull List<String> firstArr, @NotNull List<String> secondArr) {
        var newList = new ArrayList<String>();
        newList.addAll(firstArr);
        newList.addAll(secondArr);

        return removeDuplicates(newList);
    }

    public List<String> changeStr(@NotNull List<String> arr, String strToChange, String tarStr) {
        var arrCopy = new ArrayList<>(arr);

        for (var i = 0; arrCopy.size() > i; i++) {
            if (strToChange.equals(arrCopy.get(i))) {
                arrCopy.set(i, tarStr);
            }
        }

        return arrCopy;
    }

    public String getMaxLenStr(@NotNull List<String> arr) {
        String max = "";

        for (var s : arr) {
            if (s.length() > max.length()) {
                max = s;
            }
        }

        return max;
    }

    public List<String> printLastActions(@NotNull List<String> arr, int limit) {
        if (limit >= arr.size()) {
            return new ArrayList<>(arr);
        }

        return new ArrayList<>(arr.subList(arr.size() - limit, arr.size()));
    }

    public List<String> removeBlackList(@NotNull List<String> arr, @NotNull List<String> blackList) {
        var res = new ArrayList<String>();

        for (var s : arr) {
            if (!blackList.contains(s)) {
                res.add(s);
            }
        }

        return res;
    }

    private <T> List<T> removeDuplicates(@NotNull List<T> arr) {
        var arrCopy = new ArrayList<>(arr);

        for (var i = 0; i < arrCopy.size(); i++) {
            for (var j = i + 1; j < arrCopy.size(); j++) {
                if (arrCopy.get(i).equals(arrCopy.get(j))) {
                    arrCopy.remove(j);
                    j--;
                }
            }
        }
        return arrCopy;
    }
}
