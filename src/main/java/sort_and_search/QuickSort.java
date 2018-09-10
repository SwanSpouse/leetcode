package sort_and_search;

import utils.Print;

public class QuickSort {

    public static void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int sentinel = input[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && input[right] >= sentinel) {
                right -= 1;
            }
            input[left] = input[right];
            while (left < right && input[left] <= sentinel) {
                left += 1;
            }
            input[right] = input[left];
        }
        input[left] = sentinel;
        quickSort(input, start, left - 1);
        quickSort(input, left + 1, end);
    }

    public static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 4, 2, 5};
        quickSort(input);
        Print.PrintArr(input);

        input = new int[]{1, 3, 3, 3, 3, 2};
        quickSort(input);
        Print.PrintArr(input);

        input = new int[]{6, 5, 4, 3, 2, 1};
        quickSort(input);
        Print.PrintArr(input);
    }
}
