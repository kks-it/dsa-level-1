
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

// Question: return amount if available in denominations otherwise return floor and ceil value of that amount in denominations array

// Sample Input:
// 8                                                                
// 5
// 10
// 15
// 22
// 33
// 40
// 42
// 55
// 25
// Output:
// floor: 22 ceil: 33

public class _15BrokenEconomyGQ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i =0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int amt = Integer.parseInt(br.readLine());

        denominations(arr, amt);
    }

    public static void denominations(int[] arr, int amt){
        int low = 0;
        int high = arr.length - 1;
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == amt){
                System.out.println(arr[mid]);
                return;
            }else if(arr[mid] < amt){
                floor = arr[mid];
                low = mid + 1;
            }else{
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        System.out.println("floor: " + floor + " ceil: " + ceil);
    }
}
