

import java.util.Scanner;

public class _18InvertedBarChart {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i =0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        printInvertedBarChart(arr);

    }

    public static void printInvertedBarChart(int[] nums){
        int max = nums[0];

        for(int i = 1; i< nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        for(int i = 0; i < max; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[j] > 0){
                    System.out.print("*\t");
                    nums[j] -= 1;
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
