package dfs;

import utils.Print;

public class NumberOfIslands {

    public void travelCurrentIsland(char[][] grid, int[][] visited, char land, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '0' || visited[x][y] == 1) {
            return;
        }
        grid[x][y] = land;
        visited[x][y] = 1;
        travelCurrentIsland(grid, visited, land, x + 1, y);
        travelCurrentIsland(grid, visited, land, x - 1, y);
        travelCurrentIsland(grid, visited, land, x, y - 1);
        travelCurrentIsland(grid, visited, land, x, y + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    travelCurrentIsland(grid, visited, (char) (islandCount + 'A'), i, j);
                    islandCount += 1;
                }
            }
        }
        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
//        char[][] grid = new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
        Print.print2DArr(grid);
    }
}
