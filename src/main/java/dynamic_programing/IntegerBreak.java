package dynamic_programing;

public class IntegerBreak {

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = max(dp[i], j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2000));
    }
}
