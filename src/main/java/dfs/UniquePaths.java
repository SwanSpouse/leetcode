package dfs;

import java.util.HashMap;

/**
 * dfs的经典题
 * 超时了。难点在于剪枝。
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

    public int dfs(int ret, HashMap<Point, Integer> map, int m, int n, int line, int row) {
        if (line == m - 1 && row == n - 1) {
            return 1;
        }
        if (line > m - 1 || row > n - 1) {
            return 0;
        }
        Point down = new Point(line +1 , row);
        int downValue = 0;
        if(map.containsKey(down)){
            downValue = map.get(down);
        } else {
            downValue = dfs(ret, map, m, n, line +1 , row);
            map.put(down, downValue);
        }

        Point right = new Point(line, row + 1);
        int rightValue = 0;
        if(map.containsKey(right)){
            rightValue = map.get(right);
        }else{
            rightValue = dfs(ret, map, m,n, line, row+1);
            map.put(right, rightValue);
        }
        map.put(cur, downValue + rightValue);
        return downValue + rightValue;
    }

    public int uniquePaths(int m, int n) {
        HashMap<Point, Integer> map = new HashMap<Point, Integer>();
        return dfs(0, map, m, n, 0, 0);
    }
}










