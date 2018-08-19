package array;

public class MaximalSquare {

    public int countArea(char[][] matrix, int x, int y) {
        if (matrix[x][y] == '0') {
            return 0;
        }
        int area = 1;
        for (int step = 1; step < matrix.length; step++) {
            if (x + step >= matrix.length || y + step >= matrix[0].length) {
                return area;
            }
            // 检查横向是否都是1
            for (int i = x; i <= x + step; i++) {
                if (matrix[i][y + step] == '0') {
                    return area;
                }
            }
            // 检查竖向是否都是1
            for (int j = y; j <= y + step; j++) {
                if (matrix[x + step][j] == '0') {
                    return area;
                }
            }
            area = (int) Math.pow(step + 1, 2);
        }
        return area;
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                max = Math.max(max, countArea(matrix, i, j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
                {'1', '0', '0', '1', '0'}};

        System.out.println(new MaximalSquare().countArea(matrix, 0, 2));

//        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

}
