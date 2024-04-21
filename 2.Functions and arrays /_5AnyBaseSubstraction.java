
import java.util.Scanner;


// Sample Input1:
// 8
// 25
// 34

// Sample Output1:
// 7

// Sample Input2:
// 10
// 99999
// 100000

// Sample Output2:
// 1


public class _5AnyBaseSubstraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        if(n1 > n2){
            System.out.println("num2 should be greater than num1");
            return;
        }

        int result = getAnyBaseSubstraction(b, n1, n2);
        System.out.println(result);
    
    }

    public static int getAnyBaseSubstraction(int base, int num1, int num2){
        int difference = 0;
        int borrow = 0;
        int power = 1;

        while(num2 != 0){
            int digit2 = num2 % 10;
            int digit1 = num1 % 10;

            int digit = digit2- borrow - digit1;

            if(digit < 0){
                digit += base;
                borrow = 1;
            }else{
                borrow = 0;
            }

            difference += digit * power;

            num2 /= 10;
            num1 /= 10;
            power *= 10;
        }
        return difference;
    }
}
