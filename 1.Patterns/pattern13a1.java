
import java.util.Scanner;

public class pattern13a1 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nums = 0;

        for(int row = 0; row <= n; row++){
            for(int num = 0; num <= nums; num++){
                System.out.print(combination(row, num) + "\t");
            }
            System.out.println();
            nums++ ;
        }
    }

    public static int combination(int num1, int num2){
        if(num2 == 0){
            return 1;
        }
        num2 = num2 < (num1 - num2) ? num2 : (num1 - num2);
        int iterations = num2;
        int numerator = 1;
        for(int i = 1 ; i <= iterations; i++){
            numerator *= num1;
            num1--;
        }

        int denominator = 1;
        for(int i = 1; i<= iterations; i++){
            denominator *= num2;
            num2--;
        }

        return numerator/denominator;
    }
}
