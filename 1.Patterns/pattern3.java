import java.util.Scanner;

public class pattern3 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces = n - 1;
        int stars = 1;

        for(int row = 1; row <= n; row ++){
            for(int sp = 1; sp <= spaces; sp++){
                System.out.print("\t");
            }
            for(int st = 1; st <= stars; st++){
                System.out.print("*" + "\t");
            }
            spaces--;
            stars++;
            System.out.println();
        }
    }
}
