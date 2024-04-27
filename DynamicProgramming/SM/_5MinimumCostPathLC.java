package SM;

import java.util.Scanner;

// Sample Input:
// 3
// 3
// 1
// 3
// 1
// 1
// 5
// 1
// 4
// 2
// 1

// Sample Output:
// 7

// Question Link : https://leetcode.com/problems/minimum-path-sum/description/ 


public class _5MinimumCostPathLC {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int rows = scn.nextInt();
        int cols = scn.nextInt();
    
        int[][] arr = new int[rows][cols];
    
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        scn.close();

        int minCost = minimumCostPath(arr);
        System.out.println("min cost: " + minCost);
    }

    public static int minimumCostPath(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        dp[dp.length -1][dp[0].length - 1] = arr[arr.length - 1][arr[0].length - 1];

        for(int row = dp.length - 1; row >= 0; row--){
            for(int col = dp[0].length -1; col >= 0; col--){
                if(row == dp.length -1 && col == dp[0].length - 1)  continue;
                int min = Integer.MAX_VALUE;
                if(row + 1 < dp.length){
                    min = dp[row + 1][col];
                }
                if(col + 1 < dp[0].length){
                    min = Math.min(min, dp[row][col + 1]);
                }
                dp[row][col] = min + arr[row][col];
            }
        }

        for(int[] row: dp){
            for(int num: row){
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}


