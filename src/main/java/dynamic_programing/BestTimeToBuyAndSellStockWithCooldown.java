package dynamic_programing;

public class BestTimeToBuyAndSellStockWithCooldown {

//    public int getPrice(int[] prices, int i, int j) {
//        int cur = 0;
//        for (int index = j + 1; index <= i; index++) {
//            if (prices[i] > prices[index]) {
//                cur = Math.max(cur, prices[i] - prices[index]);
//            }
//        }
//        return cur;
//    }
//
//    public int maxProfit(int[] prices) {
//        if (prices.length <= 1) {
//            return 0;
//        }
//        int[] dp = new int[prices.length];
//        for (int i = 1; i < prices.length; i++) {
//            for (int j = 0; j < i; j++) {
//                dp[i] = Math.max(dp[i], prices[i] - prices[j]);
//            }
//            for (int j = 0; j < i - 1; j++) {
//                dp[i] = Math.max(dp[i], dp[j] + getPrice(prices, i, j + 1));
//            }
//        }
//        int max = dp[0];
//        for (int i = 1; i < dp.length; i++) {
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{3, 1, 4, 5, 2, 6}));
    }
}