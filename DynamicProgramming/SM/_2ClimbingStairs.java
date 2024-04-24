package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _2ClimbingStairs {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long startTime = System.nanoTime();
        int result = countClimbingStairs(n);
        long endTime = System.nanoTime();
        System.out.println("result recursion: " + result);
        System.out.println("Time taken: " + (endTime - startTime) / 1000_000.0);

        int[] arr = new int[n + 1];
        arr[0] = 1;
        long startTimeMem = System.nanoTime();
        int resultMem = countClimbingStairsMem(n, arr);
        long endTimeMem = System.nanoTime();
        System.out.println("result Memoization: " +resultMem);
        System.out.println("Time taken: " + (endTimeMem - startTimeMem) / 1000_000.0);


        long startTimeTab = System.nanoTime();
        int resultTab = countClimbingStairsTab(n);
        long endTimeTab = System.nanoTime();
        System.out.println("result Tabulization: " +resultTab);
        System.out.println("Time taken: " + (endTimeTab - startTimeTab) / 1000_000.0);
    }

    public static int countClimbingStairs(int n){
        if(n == 0) return 1;
        if(n < 0)   return 0;

        int step1 = countClimbingStairs(n - 1);
        int step2 = countClimbingStairs(n - 2);
        int step3 = countClimbingStairs(n - 3);

        return step1 + step2 + step3;
    }

    public static int countClimbingStairsMem(int n, int[] arr){
        if(n < 0)   return 0;
        if(arr[n] != 0) return arr[n];

        int step1 = countClimbingStairs(n - 1);
        int step2 = countClimbingStairs(n - 2);
        int step3 = countClimbingStairs(n - 3);

        arr[n] = step1 + step2 + step3;

        return arr[n];
    }

    public static int countClimbingStairsTab(int n){
        int[] arr = new int[n + 1];
        arr[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 3; j++){
                if(i - j >=0){
                    arr[i] += arr[i-j];
                }
            }
        }

        return arr[n];
    }
}
