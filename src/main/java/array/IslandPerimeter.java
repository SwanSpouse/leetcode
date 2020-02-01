package array;

class IslandPerimeter {

    public int count(int[][] grid, int x, int y) {
        int ret = 0;
        // up
        if(x - 1 < 0 || grid[x-1][y] == 0) {
            ret += 1;
        }
        // down 
        if(x + 1 >= grid.length || grid[x+1][y] == 0)  {
            ret += 1;
        }
        // left
        if(y -1 < 0 || grid[x][y-1] == 0) {
            ret += 1;
        }
        // right
        if(y +1 >= grid[x].length || grid[x][y+1] == 0) {
            ret += 1;
        }
        return ret;
    }

    public int islandPerimeter(int[][] grid) {
        int ret = 0 ;
        for(int i = 0; i < grid.length; i ++) {
            for(int  j =0; j < grid[i].length; j ++) {
                if (grid[i][j] == 0) {
                    continue ;
                }
                ret += count(grid, i, j);
            }
        }
        return ret;
    }
}