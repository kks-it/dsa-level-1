package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class _24BestTimeToBuyAndSellStockLC {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] prices = new int[n];

        for(int i = 0; i < prices.length; i++){
            prices[i] = Integer.parseInt(br.readLine());
        }

        int result = maxProfit(prices);
        System.out.println("maximum profit: " + result);
    }

    public static int maxProfit(int[] prices){
        int min = Integer.MAX_VALUE, maxProfit = 0;

        for(int num: prices){
            if(num < min)   min = num;
            int profit = num - min;
            if(profit > maxProfit)  maxProfit = profit;
        }
        return maxProfit;
    }
}
