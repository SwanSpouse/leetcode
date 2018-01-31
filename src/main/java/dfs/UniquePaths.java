package dfs;

/**
 * dfs的经典题
 * 超时了。难点在于剪枝。
 *
 * 想多了。这道题就是反向算最简单。
 *
 */
class UniquePaths {
    class Point {
        int X;
        int Y;

        public Point(int x, int y) {
            this.X = x;
            this.Y = y;
        }

        public String toString() {
            return this.X + "," + this.Y;
        }
    }

    // 这个方法多用了个数组。多了空间复杂度。
    // public static void dfs(ArrayList<Integer> ret, int m, int n, int line, int row) {
    //     if( line == m-1 && row == n-1){
    //         ret.add(1);
    //         return;
    //     }
    //     if( line > m -1 || row > n -1 ) {
    //         return ;
    //     }
    //     dfs(ret, m, n, line + 1, row);
    //     dfs(ret, m, n, line, row+ 1);
    // }

    // public static int uniquePaths(int m, int n) {
    //     ArrayList<Integer> ret =new ArrayList<Integer>();
    //     dfs(ret, m, n, 0, 0);
    //     return ret.size();
    // }

    // 超时了。
    // public static int dfs(int ret, int m, int n, int line, int row) {
    //     if( line == m-1 && row == n-1){
    //         return 1;
    //     }
    //     if( line > m -1 || row > n -1 ) {
    //         return 0;
    //     }
    //     return dfs(ret, m, n, line + 1, row) + dfs(ret, m, n, line, row+ 1);
    // }

    // public static int uniquePaths(int m, int n) {
    //     return dfs(0, m, n, 0, 0);
    // }

    public static void calPath(int[][] ret, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    ret[i][j] = 1;
                    continue;
                }
                int rightVal = j + 1 > n - 1 ? 0 : ret[i][j + 1];
                int downVal = i + 1 > m - 1 ? 0 : ret[i + 1][j];
                ret[i][j] = rightVal + downVal;
            }
        }
    }

    public static int uniquePaths(int m, int n) {
        int[][] ret = new int[m][n];
        calPath(ret, m, n);
        return ret[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}










