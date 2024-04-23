
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _13InverseAnArray{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n] ;

        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inversed = inverse(a);
        display(inversed);
    }

    public static int[] inverse(int[] a){
        int[] inversed = new int[a.length];

        for(int i = 0; i < a.length; i++){
            inversed[a[i]] = i;
        }
        return inversed;
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val);
            sb.append("\t");
        }

        System.out.println(sb);
    }
}