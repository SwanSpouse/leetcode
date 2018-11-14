package dynamic_programing;

public class IntegerReplacement {
//    public int integerReplacement(int n) {
//        int[] dp = new int[n + 1];
//        dp[1] = 0;
//
//        for (int i = 2; i <= n; i++) {
//            if (i % 2 == 0) {
//                dp[i] = dp[i / 2] + 1;
//            } else {
//                dp[i] = Math.min(dp[(i - 1) / 2], dp[(i + 1) / 2]) + 2;
//            }
//        }
//        return dp[n];
//    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement((int) (((long) n + 1) / 2)) + 2, integerReplacement(n - 1) + 1);
        }
    }
}

