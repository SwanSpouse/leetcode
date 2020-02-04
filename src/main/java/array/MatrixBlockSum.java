package array;

import utils.Print;

public class MatrixBlockSum {

    public int calc(int[][] mat, int k, int x, int y) {
        int ret = 0;
        for (int i = Math.max(0, x - k); i <= Math.min(mat.length - 1, x + k); i++) {
            for (int j = Math.max(0, y - k); j <= Math.min(mat[x].length - 1, y + k); j++) {
                ret += mat[i][j];
            }
        }
        return ret;
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        if (mat.length == 0) {
            return mat;
        }
        int[][] answer = new int[mat.length][mat[0].length];

        for (int r = 0; r < answer.length; r++) {
            for (int c = 0; c < answer[r].length; c++) {
                answer[r][c] = calc(mat, K, r, c);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Print.print2DArr(new MatrixBlockSum().matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
    }
}
