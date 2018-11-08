package sort_and_search;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int[] list = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list[index++] = matrix[i][j];
            }
        }
        Arrays.sort(list);
        return list[k - 1];
    }
}
