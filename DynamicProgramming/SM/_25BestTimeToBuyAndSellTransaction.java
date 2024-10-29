package SM;

// Sample Input:
// 12
// 10 15 17 20 16 18 22 20 22 20 23 25
// 3

// Sample Output:
// maximum profit: 13
public class _25BestTimeToBuyAndSellTransaction {
    public static void main(String[] args){
        int[] arr = {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        int t = 3;

        int maxProfit = bestTimeToBuyAndSellTransaction(arr, t);
        System.out.println("maximum profit: " + maxProfit);
    }

    // tf: transaction fees
    // obsp: old buy stock profit
    // ossp: old sell stock profit
    public static int bestTimeToBuyAndSellTransaction(int[] prices, int tf) {
        int obsp = -prices[0], ossp = 0;

        for (int i = 1; i < prices.length; i++) {
            int nbsp = Math.max(obsp, ossp - prices[i]);
            int nssp = Math.max(ossp, prices[i] + obsp - tf);

            obsp = nbsp;
            ossp = nssp;
        }

        return ossp;
    }
}
