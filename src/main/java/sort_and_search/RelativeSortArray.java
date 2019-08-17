package sort_and_search;

import utils.Print;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            dict.put(arr2[i], i);
        }

        Integer[] arrInput = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arrInput[i] = arr1[i];
        }
        Arrays.sort(arrInput, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (dict.containsKey(o1) && dict.containsKey(o2)) {
                    return dict.get(o1) - dict.get(o2);
                } else if (dict.containsKey(o1) && !dict.containsKey(o2)) {
                    return dict.get(o1) - arrInput.length;
                } else if (!dict.containsKey(o1) && dict.containsKey(o2)) {
                    return arrInput.length - dict.get(o2);
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arrInput[i];
        }
        return arr1;
    }

    public static void main(String[] args) {
//        Print.printArr(new RelativeSortArray().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}));
        Print.printArr(new RelativeSortArray().relativeSortArray(new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31}, new int[]{2, 42, 38, 0, 43, 21}));
    }
}

