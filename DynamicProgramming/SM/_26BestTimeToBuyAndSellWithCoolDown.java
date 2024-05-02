package SM;
import java.util.Scanner;;

public class _26BestTimeToBuyAndSellWithCoolDown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int maxProfit = bestTimeToBuyAndSellWithCoolDown( arr);
        System.out.println("max profit: " + maxProfit);
    }   

    public static int bestTimeToBuyAndSellWithCoolDown(int[] prices){
        int obsp = - prices[0], ossp = 0, ocsp = 0;

        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(obsp, ocsp - prices[i]);
            int nssp = Math.max(ossp, prices[i] + obsp);
            int ncsp = ossp;

            obsp = nbsp; ossp = nssp; ocsp = ncsp;
        }

        return ossp;
    }
}



