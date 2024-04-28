package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _10CoinChangePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] coins = new int[n];

        for(int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());

        int target = Integer.parseInt(br.readLine());

        // int result = coinChangePermutationRecursion(coins, target);

        // Integer[] dp = new Integer[target + 1];
        // int result = coinChangePermutationMem(coins, target, dp);

        int result = coinChangePermutationTab(coins, target);
        System.out.println("result: "+ result);
    }

    public static int coinChangePermutationRecursion(int[] coins, int target){
        if(target == 0) return 1;

        int result = 0;
        for(int i = 0; i < coins.length; i++){
            if(target - coins[i] >= 0)
                result += coinChangePermutationRecursion(coins, target - coins[i]);
        }

        return result;
    }

    public static int coinChangePermutationMem(int[] coins, int target, Integer[]dp){
        if(target == 0) return 1;

        if( dp[target] != null) return dp[target];

        int result = 0;

        for(int i = 0; i < coins.length; i++){
            if(target - coins[i] >= 0)
                result += coinChangePermutationMem(coins, target - coins[i], dp);
        }

        return dp[target] = result;
    }


    public static int coinChangePermutationTab(int[] coins, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int k = 1; k <= target; k++){
            for(int i = 0; i < coins.length; i++){
                if(k - coins[i] >= 0){
                    dp[k] += dp[k - coins[i]];
                }
            }
        }

        return dp[target];
    }
    
}
