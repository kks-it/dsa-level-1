// this solution O(n^2) is better than the solution on pepcoding O(n^3)

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Question: Print all subarrays. A subarray is a contiguous non-empty part of an array.

// Sample Input: 
// 3
// 10
// 20
// 30

// <-------------------------Output------------------------->
// 10 
// 10 20 
// 10 20 30 
// 20 
// 20 30 
// 30 


public class _14SubArrayProblemGQ {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        printSubArray(arr);
    }

    public static void printSubArray(int[] arr){
        System.out.println("<-------------------------Output------------------------->");
        for(int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j< arr.length; j++){
                sb.append(arr[j]);
                sb.append(" ");
                System.out.println(sb);
            }
        }
    }
}
