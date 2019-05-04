package array;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        Boolean containZero = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] = -A[i];
                K -= 1;
            } else if (A[i] == 0) {
                containZero = true;
            }
        }
        Arrays.sort(A);
        if (K > 0) {
            if (!containZero && K % 2 == 1) {
                A[0] = -A[0];
            }
        }
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            ret += A[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
