package array;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
		int lowestPrice = prices[0];
		int profit = 0;

		for(int i=1; i < prices.length; i ++ ) {
			if(prices[i] - lowestPrice > profit) {
				profit = prices[i] - lowestPrice;
			}
			if(prices[i] < lowestPrice) {
				lowestPrice = prices[i];
			}
		}
		return profit;
	}
}
