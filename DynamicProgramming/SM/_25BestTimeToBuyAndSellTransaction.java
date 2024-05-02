package SM;
import java.util.Scanner;

public class _25BestTimeToBuyAndSellTransaction {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int t = scn.nextInt();

        int maxProfit = bestTimeToBuyAndSellTransaction(arr, t);
        System.out.println("maximum profit: " + maxProfit);
    }

    //tf: transaction fees
    //obsp: old buy stock profit
    //ossp: old sell stock profit
    public static int bestTimeToBuyAndSellTransaction(int[] prices, int tf){
        int obsp = - prices[0], ossp = 0;

        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(obsp, ossp - prices[i]);
            int nssp = Math.max(ossp, prices[i] + obsp - tf );

            obsp = nbsp;
            ossp = nssp;
        }

        return ossp;
    }
}
