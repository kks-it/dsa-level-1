package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// // Sample Input:
// 8
// 4
// 2
// 0
// 3
// 1
// 1
// 2
// 5
// // Sample Output:
// min moves2: 3

public class _4ClimbingStairsWithMinimumMoves{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] jumpsArr = new int[n];

        for(int i = 0; i < jumpsArr.length; i++){
            jumpsArr[i] = Integer.parseInt(br.readLine());
        }

        int minMoves = countClimbingStairsWithMinimumMoves(n, jumpsArr);
        System.out.println("min moves: " + minMoves);

        int minMoves2 = countClimbingStairsWithMinimumMoves2(n, jumpsArr);
        System.out.println("min moves2: " + minMoves2);


    }

    public static int countClimbingStairsWithMinimumMoves(int n, int[] jumpsArr){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            int jumps = jumpsArr[i];
            for(int j = 1; j <= jumps; j++){
                if(i + j <= n && dp[i + j] < Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }
        for(int no: dp){
            System.out.print(no + "\t");
        }
        return dp[0];
    }

    public static int countClimbingStairsWithMinimumMoves2(int n, int[] jumpsArr){
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            int jumps = jumpsArr[i];
            for(int j = 1; j <= jumps; j++){
                if( i + j <=n && dp[i + j] != null){
                    dp[i] = dp[i] == null ? dp[i + j] + 1: Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0];
    }
}