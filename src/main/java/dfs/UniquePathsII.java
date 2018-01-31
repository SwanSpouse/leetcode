package dfs;


/**
 * 这两道题其实是用动归的方法解决的。想要用dfs需要采用备忘录法。
 */
class UniquePathsII {

    public static void calPaths(int[][] ret, int[][] obstacleGrid, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    ret[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    ret[i][j] = 0;
                    continue;
                }
                int right = j + 1 >= n ? 0 : ret[i][j + 1];
                int down = i + 1 >= m ? 0 : ret[i + 1][j];
                ret[i][j] = right + down;
            }
        }
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ret = new int[obstacleGrid.length][obstacleGrid[0].length];
        calPaths(ret, obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
        return ret[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}