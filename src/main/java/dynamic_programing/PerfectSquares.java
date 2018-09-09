package dynamic_programing;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int a = 1; a * a <= i; a++) {
                min = Math.min(min, dp[i - a * a] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
        System.out.println(new PerfectSquares().numSquares(53));
    }
}
