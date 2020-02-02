package sort_and_search;

import utils.Print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {


    public void sort(int[][] mat, int i, int j) {
        List<Integer> cur = new ArrayList<>();
        for (int x = i, y = j; x < mat.length && y < mat[x].length; x++, y++) {
            cur.add(mat[x][y]);
        }
        Collections.sort(cur);
        for (int x = i, y = j, index = 0; x < mat.length && y < mat[x].length; x++, y++, index++) {
            mat[x][y] = cur.get(index);
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }
        // left
        for (int i = 0; i < mat.length; i++) {
            sort(mat, i, 0);
        }
        // top
        for (int j = 1; j < mat[0].length; j++) {
            sort(mat, 0, j);
        }
        return mat;
    }

    public static void main(String[] args) {
        Print.print2DArr(new SortTheMatrixDiagonally().diagonalSort(new int[][]{
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2},
        }));
    }
}
