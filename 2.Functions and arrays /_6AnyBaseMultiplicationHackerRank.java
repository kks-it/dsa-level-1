
import java.util.Scanner;

// Sample Input 1:
// 8
// 23
// 34

// Sampel Input 2:
// 1024
public class _6AnyBaseMultiplicationHackerRank {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();


        int result = getAnyBaseMultiplication(b, n1, n2);
        System.out.println(result);
    }

    public static int getAnyBaseMultiplication(int base, int num1, int num2){
        int result = 0;
        int power = 1;
        while(num2 != 0){
            int digit2 = num2 % 10;
            num2 /= 10;

            int n1 = num1;
            int carry = 0;
            int subResult = 0;
            int subPower = 1;
            while(n1 != 0 || carry != 0){
                int digit1 = n1 % 10;
                n1 /= 10;
                int mul = (digit1 * digit2) + carry;
                subResult += (mul % base) * subPower;
                subPower *= 10;
                carry = mul / base;
            }
            result = getAnyBaseAddition(base, result, subResult * power);
            power *= 10;
        }
        
        return result;
    }
    
    public static int getAnyBaseAddition(int base, int num1, int num2){
        int sum = 0;
        
        int carry = 0;
        int power = 1;
        
        while(num1 != 0 || num2 !=0 || carry !=0){
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            num1 /= 10; num2 /= 10;
            
            int digitSum = digit1 + digit2 + carry;
            
            sum += (digitSum % base) * power;
            power *= 10;
            carry = digitSum / base;
        }
        return sum;
    }
}
