
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class _17SubsetOfAnArrayPep {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(br.readLine());

        }

        System.out.println("<---------------------Output--------------------->");
        // printAllSubsets(nums);
        printAllSubsetsA2(nums);
    }

    public static void printAllSubsets(int[] nums){
        List<String> subsets = new ArrayList<>();
        subsets.add("");
        for(int val: nums){
            int size = subsets.size();
            for(int i = 0; i < size; i++){
                String subset = subsets.get(i);
                subsets.set(i, subset + "-" + " ");
                subsets.add(new String(subset + val + " "));
            }
        }
        for(String subset: subsets){
            System.out.println(subset);
        }
    }

    public static void printAllSubsetsA2(int[] nums){     
        for(int num = 0; num < Math.pow(2,nums.length); num++){
            String[] subset = new String[nums.length];
            int number = num;
            for(int i = nums.length - 1; i >= 0; i--){
                int rem = number % 2;
                if(rem == 0){
                    subset[i] = "-";
                }else{
                    subset[i] = "" + nums[i];
                }
                number /= 2;
            }

            for(String val: subset){
                System.out.print(val + "\t");
            }
            System.out.println("\t");

        }
    }
}
