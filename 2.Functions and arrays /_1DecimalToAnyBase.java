import java.util.Scanner;

public class _1DecimalToAnyBase{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int decimal = scn.nextInt();
        int base = scn.nextInt();

        int converted = decimalToBase(decimal, base);

        System.out.println("decimal: " + decimal + " in base: " + base + " is --> " + converted);
    }

    public static int decimalToBase(int decimal, int base){
        int ans = 0, power = 0;
        while(decimal > 0){
            int rem = decimal % base;
            decimal /= base;

            ans += rem * Math.pow(10, power) ;
            power++;
        }
        return ans;
    }
}