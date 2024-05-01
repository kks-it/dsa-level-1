package SM;


// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


public class _24BestTimeToBuyAndSellStocksIILC {
    public int maxProfit(int[] prices) {
        int result = 0;

        int buy = prices[0], sell = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > sell){
                sell = prices[i];
            }else{
                result += sell - buy;
                buy = prices[i];
                sell = prices[i];
            }
        }
        result += sell - buy;
        return result;
    }
}




