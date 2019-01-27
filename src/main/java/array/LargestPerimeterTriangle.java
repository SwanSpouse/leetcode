package array;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A, 0, A.length);
        int left = A.length - 3;
        while (left >= 0) {
            if (A[left] + A[left + 1] > A[left + 2]) {
                return A[left] + A[left + 1] + A[left + 2];
            }
            left -= 1;
        }
        return 0;
    }
}
