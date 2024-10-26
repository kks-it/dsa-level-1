
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _17SubSetOfAnArrayLCGQ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        printSubArrays(arr);
    }

    public static void printSubArrays(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for(int val: arr){
            int size = result.size();
            for(int i = 0; i < size; i++){
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(val);
                result.add(newSubset);
            }
        }

        System.out.println(result);
    }
}
