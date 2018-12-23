package array;

import utils.Print;

/**
 * 这道题的技巧点在于怎么利用第一行第一列来做标志位。
 */

class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return ;
        }
        int line = matrix.length;
        int row = matrix[0].length;

        boolean first_line_has_zero = false;
        boolean first_row_has_zero = false;

        for(int j=0; j <row; j ++ ) {
            if(matrix[0][j] == 0) {
                first_line_has_zero = true;
                break;
            }
        }

        for(int i=0; i < line; i ++) {
            if(matrix[i][0] == 0){
                first_row_has_zero =  true;
                break;
            }
        }

        for(int i=1; i < line; i ++ ) {
            for(int j=1; j < row; j ++ ) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i < line ; i ++ ) {
            for(int j=1; j < row ; j ++ ) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=0; j < row; j ++ ) {
            if(first_line_has_zero) {
                matrix[0][j] = 0;
            }
        }

        for(int i=0; i < line; i ++ ) {
            if(first_row_has_zero) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 1, 1}};
        setZeroes(matrix);
        Print.print2DArr(matrix);
    }

}