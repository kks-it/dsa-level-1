
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11ReverseAnArray{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void reverse(int[] a){
    // write your code here
    int low = 0, high = a.length - 1;

    while(low < high){
        a[low] = a[low] + a[high];
        a[high] = a[low] - a[high];
        a[low] = a[low] - a[high];
        low++; high--;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
 }

}