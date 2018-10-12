package array;

import utils.Print;

public class FlippingAnImage {

    public void swap(int[][] A, int x1, int y1, int x2, int y2) {
        int temp = A[x1][y1];
        A[x1][y1] = A[x2][y2];
        A[x2][y2] = temp;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int left = 0, right = A[i].length - 1; left < right; left += 1, right -= 1) {
                swap(A, i, left, i, right);
            }
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Print.Print2DArr(new FlippingAnImage().flipAndInvertImage(new int[][]{
                {1, 1, 0}, {1, 0, 1}, {0, 0, 0}
        }));
    }
}
