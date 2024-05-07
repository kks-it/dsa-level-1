package SM;

// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


public class _27BestTimeToBuyAndSellStockIIILC {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];

        int buy = prices[0];
        dp[0][0] = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }
            dp[0][i] = Math.max(dp[0][i - 1], prices[i] - buy);
        }

        int sell = prices[prices.length - 1];
        dp[1][prices.length - 1] = 0;

        for(int i = prices.length - 2; i >= 0; i--){
            if(prices[i] > sell){
                sell = prices[i];
            }
            dp[1][i] = Math.max(dp[1][i + 1], sell - prices[i]);
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, dp[0][i] + dp[1][i]);
        }
        return maxProfit;
    }
}

