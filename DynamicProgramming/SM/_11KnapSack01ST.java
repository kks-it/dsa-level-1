package SM;

// Question Link: https://takeuforward.org/data-structure/0-1-knapsack-dp-19/

public class _11KnapSack01ST{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */

            // return knapSack01Recursion(weight, value, maxWeight, n - 1);

            // Integer[][] dp = new Integer[n][maxWeight + 1];
            // return knapsack01Mem(weight, value, n - 1, maxWeight, dp);

            // return knapsack01Tab2D(weight, value, maxWeight);

            return knapsack01Tab1D(weight, value, maxWeight);


    }

    public static int knapSack01Recursion(int[] weight, int[] value, int capacity, int index){
        if(index == 0)
            return weight[0] <= capacity ? value[0] : 0;

        int profit = knapSack01Recursion(weight, value, capacity, index - 1);
        if( capacity - weight[index] >= 0 ){
            profit = Math.max(profit, knapSack01Recursion(weight, value, capacity - weight[index], index - 1) + value[index]);
        }
        return profit;
    }

    public static int knapsack01Mem(int[] weight, int[] value, int i, int capacity, Integer[][] dp){
        if(i == 0){
            if(weight[0] <= capacity)   return value[0];
            return 0;
        }
        if(dp[i][capacity] != null) return dp[i][capacity];
        int take = 0;
        if(weight[i] <= capacity){
            take = knapsack01Mem(weight, value, i - 1, capacity - weight[i] , dp) +value[i];
        }
        int notTake = knapsack01Mem(weight, value, i - 1, capacity, dp);

        return dp[i][capacity] = Math.max(take, notTake);
    }

    public static int knapsack01Tab2D(int[] weight, int[] value, int capacity){
        int[][] dp = new int[weight.length][capacity + 1];
        
        for(int i = weight[0]; i <= capacity; i++)   dp[0][i] = value[0];

        for(int i = 1; i < weight.length; i++){
            for(int j = 1; j <= capacity; j++){
                dp[i][j] = dp[i - 1][j];
                if(j - weight[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i -1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[weight.length - 1][capacity];

    }

    public static int knapsack01Tab1D(int[] weight, int[] value, int capacity){
        int[] dp = new int[capacity + 1];

        for(int i = 0; i < weight.length; i++){
            for(int j = capacity; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }

        return dp[capacity];
    }

}