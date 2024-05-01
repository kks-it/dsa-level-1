package SM;

import java.util.Arrays;
import java.util.Scanner;

public class _21TilingMx1 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();

        scn.close();

        int[] dp = new int[n];

        for(int i = 0; i < m - 1 ; i++){
            dp[i] = 1;
        }

        dp[m - 1] = 2;

        for(int i = m ; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - m];
        }

        System.out.println("result: " + dp[n -1]);
    }
}
