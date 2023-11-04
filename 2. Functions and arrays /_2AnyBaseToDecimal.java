
import java.util.Scanner;
import java.lang.Math;

public class _2AnyBaseToDecimal{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int base = scn.nextInt();

        int result = convertAnyBaseToDecimal( num,  base);
        System.out.println(result);

    }

    public static int convertAnyBaseToDecimal(int num, int base){
        int result = 0;
        int power = 0;

        while(num != 0){
            int digit = num % 10;
            result += digit * Math.pow(base, power);
            num /= 10;
            power++;
        }
        return result;
    }
}