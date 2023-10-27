
import java.util.Scanner;

public class pattern12 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nums = 1;
        int a = 0, b = 1;
        for(int row = 1; row <= n; row++){
            for(int num = 1; num <= nums; num++){
                System.out.print(a + "\t");
                int temp = a + b;
                a = b;
                b = temp ;
            }
            System.out.println();
            nums++;
        }
    }
}
