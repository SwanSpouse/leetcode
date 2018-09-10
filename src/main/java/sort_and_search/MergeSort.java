package sort_and_search;

import utils.Print;

public class MergeSort {

    public static int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int i = 0;
        int index1 = 0, index2 = 0;
        while (index1 < left.length && index2 < right.length) {
            if (left[index1] <= right[index2]) {
                ret[i++] = left[index1++];
            } else {
                ret[i++] = right[index2++];
            }
        }
        while (index1 < left.length) {
            ret[i++] = left[index1++];
        }
        while (index2 < right.length) {
            ret[i++] = right[index2++];
        }
        return ret;
    }

    public static int[] mergeSort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int mid = input.length / 2;
        int[] left = new int[mid];
        for (int i = 0, index = 0; i < mid; i++, index++) {
            left[index] = input[i];
        }

        int[] right = new int[input.length - mid];
        for (int i = mid, index = 0; i < input.length; i++, index++) {
            right[index] = input[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 4, 2, 5};
        Print.PrintArr(mergeSort(input));

        input = new int[]{1, 3, 3, 3, 3, 2};
        Print.PrintArr(mergeSort(input));

        input = new int[]{6, 5, 4, 3, 2, 1};
        Print.PrintArr(mergeSort(input));
    }
}
