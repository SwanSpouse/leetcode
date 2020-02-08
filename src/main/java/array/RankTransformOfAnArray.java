package array;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> ranks = new HashMap<>();

        int curRank = 1;
        for (int i = 0; i < copy.length; i++) {
            if (i != 0 && copy[i - 1] == copy[i]) {
                continue;
            } else {
                ranks.put(copy[i], curRank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }
}
