package SM;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Time complexity without dp = O(2 ^ n)
// Time complexity with dp = O(n)

public class _1Fibonacci {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // long startTime = System.nanoTime();
        // int result = fib(n);
        // long endTime = System.nanoTime();
        // System.out.println("Time taken: " + ( endTime - startTime)/ 1000000.0);
        // System.out.println("output: " + result);
        
        
        long[] arr = new long[n + 1];
        long startTimeDp = System.nanoTime();
        long resultDp = fibDp(n, arr);
        long endTimeDp = System.nanoTime();
        
        System.out.println("Time taken by Dp: " + ( endTimeDp - startTimeDp)/ 1000000.0);
        System.out.println("outputDp: " + resultDp);
        

    }

    public static int fib(int n){
        if(n <= 1)  return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static long fibDp(int n, long[] arr){
        if(n <= 1) return n;

        if(arr[n] != 0) return arr[n];
        
        long fib = fibDp(n - 1, arr) + fibDp(n - 2, arr);
        arr[n] = fib;
        return fib;
    }
}
