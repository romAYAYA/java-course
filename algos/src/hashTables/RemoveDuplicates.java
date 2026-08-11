package hashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveDuplicates {
    void main() {
        int[] arr = {1, 2, 2, 3, 4, 4, 5, 1};
        IO.println(removeDuplicates(arr));
    }

    public List<Integer> removeDuplicates(int[] arr) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : arr) {
            if (!seen.containsKey(num)) {
                seen.put(num, true);
                res.add(num);
            }
        }
        return res;
    }
}
