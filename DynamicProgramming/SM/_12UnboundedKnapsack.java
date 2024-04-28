package SM;

// Question Link: https://www.naukri.com/code360/problems/unbounded-knapsack_1215029

public class _12UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        // return unboundedKnapsackRecursion(profit, weight, w, n - 1);

        // Integer[][] dp = new Integer[n][w + 1];
        // return unboundedKnapsackMem(profit, weight, w, n - 1, dp);

        // return unboundedKnapsackTab2D(profit, weight, w);
        return unboundedKnapsackTab1D(profit, weight, w);
    }

    public static int unboundedKnapsackRecursion(int[] profit, int[] weight, int capacity, int index){
        if(index == 0){
            return (capacity >= weight[0]? capacity / weight[0] * profit[0] : 0) ;
        }

        int take = 0;
        if(capacity - weight[index] >= 0){
            take = unboundedKnapsackRecursion(profit, weight, capacity - weight[index], index) + profit[index];
        }
        int notTake = unboundedKnapsackRecursion(profit, weight, capacity, index - 1);

        return Math.max(notTake, take);
    }

    public static int unboundedKnapsackMem(int[] profit, int[] weight, int capacity, int index, Integer[][] dp){
        if(index == 0){
            return (capacity >= weight[0]? capacity / weight[0] * profit[0] : 0);
        }

        if(dp[index][capacity] != null) return dp[index][capacity];

        int take = 0;
        if(capacity >= weight[index] ) {
            take = unboundedKnapsackMem(profit, weight, capacity  - weight[index], index, dp) + profit[index];
        } 
        int notTake = unboundedKnapsackMem(profit, weight, capacity, index - 1, dp);

        return dp[index][capacity] = Math.max(take, notTake);
    }

    public static int unboundedKnapsackTab2D(int[] profit, int[] weight, int capacity){
        int[][] dp = new int[weight.length][capacity + 1];

        for(int i = weight[0]; i  <= capacity; i++){
            dp[0][i ] = dp[0][i - weight[0]] + profit[0];
        }


        for(int i = 1; i < weight.length ; i++){
            for(int j = 1; j <= capacity ; j++){
                if(j >= weight[i]){
                    dp[i][j] = Math.max(dp[i][j - weight[i]] + profit[i], dp[i - 1][j]);
                }
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[weight.length - 1][capacity];
    }

    public static int unboundedKnapsackTab1D(int[] profit, int[] weight, int capacity){
        int[] dp = new int[capacity + 1];

        for(int i = 0; i < weight.length; i++){
            for(int j = weight[i]; j <= capacity; j++){
                if(dp[j - weight[i]] + profit[i] > dp[j])
                    dp[j] = dp[j - weight[i]] + profit[i];
            }
        }
        return dp[capacity];
    }
}
