package SM;

// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/


class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length];

        for(int t = 1; t <= k; t++){
            int maxProfit = Integer.MIN_VALUE;
            for(int d = 1; d < prices.length; d++){
                maxProfit = Math.max(maxProfit, dp[t - 1][ d - 1] - prices[d - 1]);
                dp[t][d] = Math.max(maxProfit + prices[d], dp[t][d - 1]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
