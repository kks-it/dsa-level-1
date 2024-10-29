package SM;

// It can be done in multiple ways: 1 sliding window 2. Dynamic programming
// As of now coming to the solution intuition wise, DP is preferred.


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



// class Solution {
//     public int maxProfit(int[] prices) {
//         // int canBuy = 1; // 1= yes

//         // Integer[][] mem = new Integer[2][prices.length];
//         // return solution(prices, 0, 1, mem);

//         // // Tabulation
//         // int[][] tab = new int[2][prices.length + 1];

//         // // row = 0 (canBuy = false) ; row = 1 (canBuy = true)
//         // tab[0][prices.length] = 0;
//         // tab[1][prices.length] = 0;

//         // for(int i = prices.length - 1; i >= 0; i--){
//         //     tab[0][i] = Math.max(tab[1][i + 1] + prices[i], tab[0][i + 1]);
//         //     tab[1][i] = Math.max(tab[0][i + 1] - prices[i], tab[1][i + 1]);
//         // }

//         // return tab[1][0];


//         //Space optimisation
//         //observation, In the array that we have created for Tabulisation. How many previous states 
//         // we need to calculate current state? only 1(previous one), we are not going beyond that for 
//         // calculating current state. whenever no. of states are limited (one, two, etc) space
//         //  optimisation can be done.

//         int canBuy = 0, canSell = 0;

//         for(int i = prices.length - 1; i >= 0; i--){
//             int newCanBuy = Math.max(canBuy, canSell - prices[i]);
//             int newCanSell = Math.max(canSell, canBuy + prices[i]);

//             canBuy = newCanBuy;
//             canSell = newCanSell;
//         }

//         return canBuy;
        
//     }

//     public int solution(int[] prices, int i, int canBuy, Integer[][] mem ){
//         if(i == prices.length)  return 0;

//         if(Objects.nonNull(mem[canBuy][i])){
//             return mem[canBuy][i];
//         }

//         int max = solution(prices, i + 1, canBuy, mem);

//         if(canBuy == 1){
//             int buy = solution(prices, i + 1, 0, mem);
//             max= Math.max(max, buy - prices[i]);
//         }else{
//             int sell = solution(prices, i + 1, 1, mem);
//             max = Math.max(max, sell + prices[i]);
//         }

//         mem[canBuy][i] = max;
//         return max;
//     }
// }






