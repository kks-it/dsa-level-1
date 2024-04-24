package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Question: given stairs n along with an array which represents no. of maximum jumps that can be taken from stair n.
// Find out the count of all the possible ways to reach stair n from stair 0.

// Sample Input: 
// 6   (n)
// 3
// 2
// 2
// 0
// 2
// 4

// Sample Output:
// count: 4

public class _3ClimbingStairsWithjumpsArr{
    public static void main(String[] args)  throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] jumpsArr = new int[n];

        for(int i = 0 ; i < jumpsArr.length; i++){
            jumpsArr[i] = Integer.parseInt(br.readLine());
        }

        int count = countClimbingStairsWithjumpsArrTab(n, jumpsArr);
        System.out.println("count: "+ count);

    }

    public static int countClimbingStairsWithjumpsArrTab(int n, int[] jumpsArr){
        int[] dp = new int[n + 1];

        dp[n] = 1;

        for(int i = n-1; i >= 0; i--){
            int jumps = jumpsArr[i];
            for(int j = 1; j <= jumps; j++){
                if( i + j <= n){
                    dp[i] += dp[i + j];
                }
            }
        }
        return dp[0];
    }
}
