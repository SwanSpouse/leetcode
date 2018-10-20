package dynamic_programing;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i =1; i <= amount; i ++ ) {
            int minCoin = Integer.MAX_VALUE;
            boolean hasSolution = false;
            for(int j =0; j < coins.length; j ++) {
                if(i >= coins[j] && dp[i - coins[j]] >= 0) {
                    hasSolution = true;
                    minCoin = Math.min(minCoin, dp[i - coins[j]]  + 1);
                }
            }
            dp[i] = hasSolution ? minCoin : -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
//        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChange(new int[]{}, 10));
    }
}
