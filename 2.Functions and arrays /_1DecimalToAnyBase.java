
import java.util.Scanner;
import java.lang.Math;

public class _1DecimalToAnyBase{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int base = scn.nextInt();

        int result = 0;
        int power = 0;

        while(num != 0){
            int rem = num % base;
            result += rem * Math.pow(10, power);
            num /= base;
            power++;
        }

        System.out.println(result);
        
    }
}