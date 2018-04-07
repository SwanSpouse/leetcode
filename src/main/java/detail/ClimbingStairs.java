package detail;

class ClimbingStairs {
    // 超时了。
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    // 正向算比递归要节省时间。递归做了好多重复的计算。
    public static int climbStairs(int n) {
        int[] ret = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ret[i] = i <= 2 ? i : ret[i - 1] + ret[i - 2];
        }
        return ret[n];
    }
}