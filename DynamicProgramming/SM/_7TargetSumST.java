package SM;

import java.util.Scanner;

//Question Link: https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
import java.util.* ;
import java.io.*; 
public class _7TargetSumST {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        // Boolean dp[][] = new Boolean[arr.length][k + 1];
        // return targetSumMem(0, arr, k, dp);

        // return targetSumTab2D(arr, k);

        return targetSumTab1D(arr, k);
    }
    public static boolean targetSumMem(int index, int[] arr, int target, Boolean[][] dp){
        if(target == 0) return true;
        if(index == arr.length - 1 ) return arr[index] == target;

        if(dp[index][target] != null)   return dp[index][target];
        
        boolean take = false;
        if(target - arr[index] >= 0){
            take = targetSumMem(index + 1, arr, target - arr[index], dp);
        }
        boolean notTake = targetSumMem(index + 1, arr, target, dp);
        return dp[index][target] = take || notTake;
    }

    public static boolean targetSumTab2D(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length][target + 1];

        for(int i = 0; i < arr.length; i++)
            dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if(j - arr[i] >= 0){
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i]];
                }
            }
        }
        return dp[arr.length - 1][target];
    }

    public static boolean targetSumTab1D(int[] arr, int target){
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int i = 0 ; i < arr.length; i++){
            for(int j = target; j >= arr[i]; j--)
                    dp[j] = dp[j] || dp[j - arr[i]];
        }
        return dp[target];
    }
}
