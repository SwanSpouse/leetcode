package sort_and_search;

import utils.Print;

public class MergeSort {

    public static void merge(int[] input, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (input[i] < input[j]) {
                temp[index++] = input[i++];
            } else {
                temp[index++] = input[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = input[i++];
        }
        while (j <= right) {
            temp[index++] = input[j++];
        }
        // 将排序结果写回input
        for (i = left; i <= right; i++) {
            input[i] = temp[i];
        }
    }

    public static void sort(int[] input, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(input, left, mid, temp);
        sort(input, mid + 1, right, temp);
        merge(input, left, mid, right, temp);
    }

    public static void mergeSort(int[] input) {
        int[] temp = new int[input.length]; // 这个数据申请的比较精髓，使得后面不用申请无用内存
        sort(input, 0, input.length - 1, temp);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 4, 2, 5};
        mergeSort(input);
        Print.PrintArr(input);

        input = new int[]{1, 3, 3, 3, 3, 2};
        mergeSort(input);
        Print.PrintArr(input);

        input = new int[]{6, 5, 4, 3, 2, 1};
        mergeSort(input);
        Print.PrintArr(input);
    }
}
