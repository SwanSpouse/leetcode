package array;

import utils.Print;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] horizon = new int[grid.length];
        int[] vertical = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            horizon[i] = grid[i][0];
            for (int j = 0; j < grid[i].length; j++) {
                horizon[i] = Math.max(horizon[i], grid[i][j]);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            vertical[j] = grid[0][j];
            for (int i = 0; i < grid.length; i++) {
                vertical[j] = Math.max(vertical[j], grid[i][j]);
            }
        }
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(horizon[i], vertical[j]);
                ret += min - grid[i][j];
                grid[i][j] = min;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0},};
        System.out.println(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(grid));

        Print.print2DArr(grid);
    }
}
