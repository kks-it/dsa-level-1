package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


// Sample Input:
// 5
// 3

// Sample Output:
// Recursion Result
// time taken: 0.0145 milliseconds
// result: 25
// Memoization Result
// time taken: 0.008542 milliseconds
// result: 25
// Tabulation Result
// time taken: 0.049125 milliseconds
// result: 25

public class _23ParitionToKTeams {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        double startTime = System.nanoTime();
        int result = partitionToKTeamsRecursion(n, k);
        double endTime = System.nanoTime();
        System.out.println("Recursion Result");
        System.out.println("time taken: " + (endTime - startTime) / 1_000_000 + " milliseconds");
        System.out.println("result: " + result);

        double startTime1 = System.nanoTime();
        Integer[][] dp = new Integer[n + 1][k + 1];
        int result1 = partitionToKTeamsMem(n, k, dp);
        double endTime1 = System.nanoTime();
        System.out.println("Memoization Result");
        System.out.println("time taken: " + (endTime1 - startTime1) / 1_000_000 + " milliseconds");
        System.out.println("result: " + result1);



        double startTime2 = System.nanoTime();
        int result2 = partitionToKTeamsTab(n, k);
        double endTime2 = System.nanoTime();
        System.out.println("Tabulation Result");
        System.out.println("time taken: " + (endTime2 - startTime2) / 1_000_000 + " milliseconds");
        System.out.println("result: " + result2);
    }

    public static int partitionToKTeamsRecursion(int players, int teams){
        if(players < teams) return 0;
        if(players == teams || teams == 1) return 1;


        int result = partitionToKTeamsRecursion( players - 1, teams) * teams;
        result += partitionToKTeamsRecursion(players - 1, teams - 1);

        return result;
    }

    public static int partitionToKTeamsMem(int players, int teams, Integer[][] dp){
        if(players < teams) return 0;
        if(players == teams || teams == 1) return 1;

        if(dp[players][teams] != null)  return dp[players][teams];

        int result = partitionToKTeamsRecursion( players - 1, teams) * teams;
        result += partitionToKTeamsRecursion(players - 1, teams - 1);

        return dp[players][teams] = result;
    }

    public static int partitionToKTeamsTab(int players, int teams){
        int[][] dp = new int[teams + 1][players + 1];

        for(int i = 1; i < players; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= teams; i++){
            for(int j = 1; j <= players; j++){
                dp[i][j] = dp[i][j - 1] * i + dp[i - 1][j - 1];
            }
        }
        return dp[teams][players];

    }
}
