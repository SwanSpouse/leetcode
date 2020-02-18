package array;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // row
        for (int i = 0; i < matrix.length; i++) {
            int val = matrix[i][0];
            for (int x = i, y = 0; x < matrix.length && y < matrix[x].length; x++, y++) {
                if (val != matrix[x][y]) {
                    return false;
                }
            }
        }
        // line
        for (int j = 0; j < matrix[0].length; j++) {
            int val = matrix[0][j];
            for (int x = 0, y = j; x < matrix.length && y < matrix[x].length; x++, y++) {
                if (val != matrix[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
