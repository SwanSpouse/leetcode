package sort_and_search;

import java.util.ArrayList;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evens.add(A[i]);
            } else {
                odds.add(A[i]);
            }
        }
        int oddIndex = 0, evenIndex = 0;
        int[] ret = new int[A.length];
        for (int i = 0; i < ret.length; i++) {
            if (i % 2 == 0) {
                ret[i] = evens.get(evenIndex++);
            } else {
                ret[i] = odds.get(oddIndex++);
            }
        }
        return ret;
    }
}
