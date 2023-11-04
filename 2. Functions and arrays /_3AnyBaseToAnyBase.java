
import java.util.Scanner;
import java.lang.Math;

public class _3AnyBaseToAnyBase {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int base1 = scn.nextInt();
        int base2 = scn.nextInt();

        int decimal = convertAnyBaseToDecimal(num, base1);
        int result = convertDecimalToAnyBase(decimal, base2);

        System.out.println(result);
    }

    public static int convertAnyBaseToDecimal(int num, int base){
        int result = 0, power = 0;

        while(num != 0){
            int digit = num % 10;
            result += digit * Math.pow(base, power);
            num /= 10;
            power++;
        }

        return result;
    }

    public static int convertDecimalToAnyBase(int num, int base){
        int result = 0, power = 0;

        while(num != 0){
            int rem = num % base;
            result += rem * Math.pow(10, power);
            power++;
            num /= base;
        }
        return result;
    }
}
