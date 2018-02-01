package array;

import utils.Print;

class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = Integer.MIN_VALUE;
                    matrix[0][j] = Integer.MIN_VALUE;
                }
            }
        }
        Print.Print2DArr(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][0] == Integer.MIN_VALUE || matrix[0][j] == Integer.MIN_VALUE ? 0 : matrix[i][j];
            }
        }

        System.out.println();

        Print.Print2DArr(matrix);

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 1, 1}};
        setZeroes(matrix);
    }

}