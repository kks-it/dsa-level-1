package SM;

// Question Link: https://leetcode.com/problems/coin-change/
class _8CoinChange1LC {
    public int coinChange(int[] coins, int amount) {
        // int result = coinChangeRecursion(coins.length - 1, coins, amount);

        // int [][] dp = new int[coins.length][amount + 1];
        // int result = coinChangeMem(coins.length - 1, coins, amount, dp);

        int result = coinChangeTab1D(coins, amount);

        if(result == Integer.MAX_VALUE) return - 1;
        return result;
    }

    public static int coinChangeRecursion(int index, int[] coins, int amount){
        if(amount == 0) return 0;
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }else{
                return Integer.MAX_VALUE;
            }
        }

        int take = Integer.MAX_VALUE;
        if(amount - coins[index] >= 0){
            take = coinChangeRecursion(index, coins, amount-coins[index]);
            if(take < Integer.MAX_VALUE) take += 1;
        }

        int notTake = coinChangeRecursion(index - 1, coins, amount);

        return Math.min(take, notTake);
    }

    public static int coinChangeMem(int index, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(index == 0){
            if(amount % coins[index] == 0){
                return dp[index][amount] =  amount / coins[index];
            }
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount] != 0)  return dp[index][amount];

        int take = Integer.MAX_VALUE;
        if(amount - coins[index] >= 0){
            take = coinChangeMem(index, coins, amount - coins[index], dp);
            if(take != Integer.MAX_VALUE) take += 1;
        }

        int notTake = coinChangeMem(index - 1, coins, amount, dp);

        return dp[index][amount] = Math.min(take, notTake);

    }

    public static int coinChangeTab1D(int[] coins, int amount){
        Integer[] dp = new Integer[amount + 1];
        dp[0]  = 0;

        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0 && dp[j - coins[i]] != null){
                    if(dp[j] == null){
                        dp[j] = dp[j - coins[i]] + 1;
                    }else{
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }
                }
                
            }
        }
        return dp[amount] == null ? -1: dp[amount];
    }
}