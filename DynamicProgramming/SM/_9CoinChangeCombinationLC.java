package SM;
// Question Link: https://leetcode.com/submissions/detail/1241682515/


class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        // int count = coinChangeMem(amount, coins, coins.length - 1, dp);
        // int count = coinChangeTab2D(amount, coins);
        int count = coinChangeTab1D(amount, coins);
        return count;
    }

    // public static int coinChangeMem(int amount, int[] coins, int index, Integer[][] dp){
    //     if(index == 0) return (amount % coins[0] == 0)? 1: 0;
        
    //     if(dp[index][amount] != null)   return dp[index][amount];

    //     int take = 0;
    //     if(amount - coins[index] >= 0){
    //         take = coinChangeMem(amount - coins[index], coins, index, dp);
    //     } 
    //     int notTake = coinChangeMem(amount, coins, index - 1, dp);

    //     return dp[index][amount] = take + notTake;
    // }

    // public static int coinChangeTab2D(int amount, int[] coins){
    //     int[][] dp = new int[coins.length][amount + 1];

    //     for(int i = 0; i < coins.length; i++){
    //         dp[i][0] = 1;
    //     }
    //     for(int j = 1; j * coins[0] <= amount; j++){
    //         dp[0][j * coins[0]] = 1; 
    //     }
    //     for(int i = 1; i < coins.length; i++){
    //         for(int j = 1; j <= amount ; j++){
    //             dp[i][j] = dp[i - 1][j] ;
    //             if(j - coins[i] >=0) dp[i][j] += dp[i][j - coins[i]];
    //         }
    //     }
    //     return dp[coins.length - 1][amount];
    // }

    public static int coinChangeTab1D(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0)   dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}