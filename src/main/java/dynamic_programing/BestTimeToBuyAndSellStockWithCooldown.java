package dynamic_programing;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int getPrice(int[] prices, int i, int j) {
        int cur = 0;
        for (int index = j + 1; index <= i; index++) {
            if (prices[i] > prices[index]) {
                cur = Math.max(cur, prices[i] - prices[index]);
            }
        }
        return cur;
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[i] - prices[j]);
            }
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + getPrice(prices, i, j + 1));
            }
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{3, 1, 4, 5, 2, 6}));
    }
}