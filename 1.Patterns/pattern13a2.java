
import java.util.Scanner;

public class pattern13a2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nums = 0;
        for (int row = 0; row <= n; row++) {
            int val = 1;
            for (int num = 0; num <= nums; num++) {
                System.out.print(val + "\t");
                val = val * (row - num) / (num + 1);
            }
            System.out.println();
            nums++ ;
        }
    }
}
