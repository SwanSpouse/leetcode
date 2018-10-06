package array;

public class MaxAreaOfIsland {

    public int curCount ;

    public void dfs(int[][] grid, int x, int y) {
        if(x >= grid.length || x < 0 || y >= grid[x].length || y < 0 || grid[x][y] != 1) {
            return;
        }
        curCount += 1;
        grid[x][y] = 2;
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for(int i=0; i < grid.length; i ++) {
            for(int j =0; j < grid[i].length; j ++) {
                if(grid[i][j] == 1) {
                    curCount = 0;
                    dfs(grid, i, j);
                    maxCount = Math.max(maxCount, curCount);
                }
            }
        }
        return maxCount;
    }
}
