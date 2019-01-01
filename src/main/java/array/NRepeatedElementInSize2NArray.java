package array;

import java.util.HashSet;

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int item : A) {
            if (set.contains(item)) {
                return item;
            }
            set.add(item);
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new NRepeatedElementInSize2NArray().repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(new NRepeatedElementInSize2NArray().repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(new NRepeatedElementInSize2NArray().repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
