
import java.util.Scanner;

public class _10DifferenceOfArrays {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];

        for(int i = 0; i < arr1.length; i++){
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for(int i = 0; i < arr2.length; i++){
            arr2[i] = scn.nextInt();
        }

        getArraysDifference(arr1, arr2);
    }

    public static void getArraysDifference(int[] a1, int[] a2){
        int[] diffArray = new int[a2.length];

        int borrow = 0;
        for(int i = 1; i <= a2.length; i++){
            int diff = a2[a2.length - i] - borrow;

            if(a1.length - i >= 0){
                diff -= a1[a1.length - i];
            }

            if(diff < 0){
                diff += 10;
                borrow = 1;
            }else{
                borrow = 0;
            }
            diffArray[diffArray.length - i] = diff;
        }

        int index = 0;
        while(diffArray[index] == 0){
            index++;
        }

        for(int i = index; i < diffArray.length; i++){
            System.out.println(diffArray[i]);
        }

    }
}
