
import java.util.Scanner;

public class _8BarChartGQ {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
            if(arr[i] > max){
                max = arr[i];
            }
        }

        while(max > 0){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == max){
                    System.out.print("*\t");
                    arr[i]--;
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
            max--;
        }
    }
}
