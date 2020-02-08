package array;

import utils.Print;

public class DuplicateZeros {
    public void move(int[] arr, int pos) {
        for (int i = arr.length - 2; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
    }


    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 || i == arr.length - 1) {
                continue;
            }
            move(arr, i);
            arr[i + 1] = 0;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        new DuplicateZeros().duplicateZeros(arr);
        Print.printArr(arr);
    }
}
