
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Sample Input:
// 6
// 1
// 2
// 3
// 4
// 5
// 6
// -8

// Sample output:
// 3       4       5       6       1       2 

public class _12RotateAnArraySolGQ{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

    public static void rotate(int[] a, int k){
        k %= a.length;
        if(k < 0)   k += a.length;

        reverse(a, 0, a.length - 1 - k);
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int[] a, int start , int end){
        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val : a){
            sb.append(val);
            sb.append("\t");
        }

        System.out.println(sb);
    }
}