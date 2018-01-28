package array;

import utils.Print;

/**
 * 细节题
 */
class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];

        int curValue = 1;
        for (int margin = 0; margin < n / 2 + 1; margin++) {
            // up
            for (int j = margin; j < n - margin; j++) {
                ret[margin][j] = curValue++;
            }
            // right
            for (int i = margin + 1; i < n - 1 - margin; i++) {
                ret[i][n - 1 - margin] = curValue++;
            }
            // down
            for (int j = n - 1 - margin; j >= margin && margin != n - 1 - margin; j--) {
                ret[n - 1 - margin][j] = curValue++;
            }
            // left 
            for (int i = n - 1 - margin - 1; i > margin && margin != n - 1 - margin; i--) {
                ret[i][margin] = curValue++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println();
        Print.Print2DArr(generateMatrix(4));
    }
}