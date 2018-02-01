package dynamic_programing;

/**
 * dp简单问题。公式为:
 *		dp[line-1][row-1] = grid[line-1][row-1];
 * 		dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]);
 */
class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int line = grid.length;
        int row  = grid[0].length;

        int [][] dp = new int[line][row];
        for(int i= line-1; i >=0; i -- ) {
        	for(int j= row -1; j >=0; j --) {
        		if(i == line -1 && j == row -1 ){
        			dp[i][j] = grid[i][j];
        			continue;
        		}
        		int right = j + 1 >= row ? Integer.MAX_VALUE : dp[i][j+1] + grid[i][j];
        		int down = i + 1 >= line? Integer.MAX_VALUE : dp[i+1][j] + grid[i][j];
        		dp[i][j] = right < down ? right : down;
        	}
        }
        return dp[0][0];
    }
}