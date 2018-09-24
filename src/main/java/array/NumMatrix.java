package array;

public class NumMatrix {

    int[][] matrixSum ;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 ) {
            return ;
        }
        matrixSum = new int[matrix.length][matrix[0].length];

        for(int i=0; i < matrix.length; i ++) {
            for(int j=0; j < matrix[i].length; j ++ ) {
                int left = 0, up = 0, upLeft = 0;
                if (i < matrix.length && i >= 0 && j - 1 >= 0 && j - 1 < matrix[i].length) {
                    left = matrixSum[i][j-1];
                }
                if (i - 1 < matrix.length && i - 1 >=0 && j >= 0 && j < matrix[i].length ) {
                    up = matrixSum[i-1][j];
                }
                if (i - 1 >=0 && i - 1 < matrix.length && j - 1 >= 0 && j-1 < matrix[i-1].length ) {
                    upLeft = matrixSum[i-1][j-1];
                }
                matrixSum[i][j] = left + up - upLeft + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrixSum.length == 0) {
            return 0;
        }
        int rightDown =matrixSum[row2][col2];
        int rightUp = 0, leftUp = 0, leftDown = 0;

        if(row1 - 1 >= 0 && row1 - 1 < matrixSum.length && col1 -1 >= 0 && col1 -1 < matrixSum[0].length) {
            leftUp = matrixSum[row1-1][col1-1];
        }
        if(row1 -1 >=0 && row1 - 1 < matrixSum.length) {
            rightUp = matrixSum[row1-1][col2];
        }
        if(col1 -1 >=0 && col1 -1 < matrixSum[0].length) {
            leftDown = matrixSum[row2][col1-1];
        }
        return rightDown - rightUp - leftDown + leftUp;
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{ {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
