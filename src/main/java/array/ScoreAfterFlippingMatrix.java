package array;

public class ScoreAfterFlippingMatrix {

    public int toInteger(int[][] input, int line) {
        int ret = 0;
        for (int j = 0; j < input[line].length; j++) {
            ret = ret * 2 + input[line][j];
        }
        return ret;
    }

    public boolean onesMore(int[][] input, int row) {
        int ret = 0;
        for (int i = 0; i < input.length; i++) {
            ret += input[i][row];
        }
        return ret > input.length / 2;
    }

    public int matrixScore(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }

        for (int j = 0; j < A[0].length; j++) {
            if (onesMore(A, j)) {
                continue;
            }
            for (int i = 0; i < A.length; i++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }

        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            ret += toInteger(A, i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new ScoreAfterFlippingMatrix().matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
}
