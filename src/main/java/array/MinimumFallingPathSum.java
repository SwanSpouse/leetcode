package array;

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][A[0].length];
        for (int j = 0; j < A[0].length; j++) {
            dp[0][j] = A[0][j];
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int a = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int b = j == A[i].length - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                int c = dp[i - 1][j];
                dp[i][j] = Math.min(a, Math.min(b, c)) + A[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            min = Math.min(min, dp[A.length - 1][j]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
