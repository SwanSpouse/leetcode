package array;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<List<Integer>> ret = new ArrayList<>(grid.length);
        if (grid.length == 0) {
            return ret;
        }
        int[][] temp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int x = (i + (j + k) / grid[0].length) % grid.length;
                int y = (j + k) % grid[0].length;
                temp[x][y] = grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                cur.add(grid[i][j]);
            }
            ret.add(cur);
        }
        return ret;
    }
}
