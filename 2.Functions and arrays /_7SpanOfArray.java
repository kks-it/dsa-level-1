

import java.util.Scanner;

public class _7SpanOfArray {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i]= scn.nextInt();
        }

        int ans = getSpanOfArray(arr);
        System.out.println(ans);
    }

    public static int getSpanOfArray(int[] arr){
        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] < min){
                min = arr[i];
            }
        }

        return max - min;
    }
}
