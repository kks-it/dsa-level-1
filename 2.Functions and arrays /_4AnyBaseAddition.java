
import java.util.Scanner;

// Sample Input1:
// 8           
// 346
// 777

// Sample output2:
// 1345

// Sample Input2:
// 5
// 234
// 343

// Sample output2:
// 1132

public class _4AnyBaseAddition {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int base = scn.nextInt();
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();

        int result = getAnyBaseAddition(base, num1, num2);
        System.out.println(result);
    }

    public static int getAnyBaseAddition(int base, int num1, int num2){
        int sum = 0;

        int carry = 0;
        int power = 1;
        while(num1 != 0 || num2 != 0 || carry != 0){
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            int digitSum = digit1 + digit2 + carry;

            int rem = digitSum % base;

            sum += rem * power;
            carry = digitSum / base;

            num1 /= 10;
            num2 /= 10;
            power *= 10;
        }

        return sum;
    }
}
