
import java.util.Scanner;

// Sample Input:
// 3 (arr1 size)
// 2
// 5
// 5
// 2 (arr2 size)
// 4
// 8

// Sample Output:
// 3
// 0
// 3

public class _9SumOfTwoArrays {
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

        int size = (arr1.length > arr2.length) ? arr1.length : arr2.length ;
        int[] sumArray = new int[size];

        int carry = 0;
        for(int i = 1; i <= sumArray.length; i++){
            int sum = 0;

            int index1 = arr1.length - i;
            if(index1 >= 0){
                sum += arr1[index1];
            }

            int index2 = arr2.length - i ;
            if(index2 >= 0){
                sum += arr2[index2];
            }

            sum += carry;

            sumArray[sumArray.length - i] = sum % 10;
            carry = sum / 10;
        }

        if(carry > 0){
            System.out.println(carry);
        }

        for(int num : sumArray){
            System.out.println(num);
        }
    }
}
