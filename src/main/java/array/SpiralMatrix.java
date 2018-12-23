package array;

import utils.Print;

import java.util.*;

/**
 * 细节题 适合心静的时候做。
 */
class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return ret;
        }
        int line = matrix.length;
        int row = matrix[0].length;
        int step = line < row ? (line - 1) / 2 : (row - 1) / 2;
        for (int margin = 0; margin <= step; margin += 1) {
            // up 
            for (int j = margin; j < row - margin; j++) {
                ret.add(matrix[margin][j]);
            }
            // right
            for (int i = margin + 1; i < line - 1 - margin; i++) {
                ret.add(matrix[i][row - 1 - margin]);
            }
            // bottom
            for (int j = row - 1 - margin; j >= margin && margin != line - 1 - margin; j--) {
                ret.add(matrix[line - 1 - margin][j]);
            }
            // left
            for (int i = line - 1 - margin - 1; i > margin && row - 1 - margin != margin; i--) {
                ret.add(matrix[i][margin]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        Print.printList(spiralOrder(matrix));

        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        Print.printList(spiralOrder(input));

//        int[][] errBranch = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//        };
        int[][] errBranch = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10},
        };
        Print.printList(spiralOrder(errBranch));
    }
}