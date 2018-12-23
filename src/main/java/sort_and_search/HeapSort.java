package sort_and_search;

import utils.Print;

public class HeapSort {

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    // 一次堆调整，向下调整
    public static void adjust(int[] input, int len, int pos) {
        int left = (pos + 1) * 2 - 1;
        int right = (pos + 1) * 2;
        while (left < len || right < len) {
            int leftVal = left < len ? input[left] : Integer.MIN_VALUE;
            int rightVal = right < len ? input[right] : Integer.MIN_VALUE;
            if (rightVal >= leftVal && rightVal >= input[pos]) {
                swap(input, pos, right);
                pos = right;
            } else if (leftVal >= rightVal && leftVal >= input[pos]) {
                swap(input, pos, left);
                pos = left;
            } else {
                break;
            }
            left = (pos + 1) * 2 - 1;
            right = (pos + 1) * 2;
        }
    }

    // 升序是大根堆
    public static void heapSort(int[] input) {
        // 首先从第一个非叶子节点开始，从后往前进行调整
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            adjust(input, input.length, i);
        }
        // 从最后一个节点开始，每次取一个堆顶元素和末尾元素交换，然后输出末尾元素
        // 重新确定堆顶元素的位置
        for (int i = input.length - 1; i >= 0; i--) {
            swap(input, 0, i);
            adjust(input, i, 0);
        }
    }

    /* TODO 上面的所有调整都是向下调整。如果要是往堆里面插入元素，首先把元素放到末端，
    然后做一次向上调整就好了。不用向下调整。
    */

    public static void main(String[] args) {
        int[] input = new int[]{4, 6, 8, 5, 9};
        heapSort(input);
        Print.printArr(input);

        input = new int[]{1, 3, 3, 3, 3, 2};
        heapSort(input);
        Print.printArr(input);

        input = new int[]{6, 5, 4, 3, 2, 1};
        heapSort(input);
        Print.printArr(input);
    }
}
