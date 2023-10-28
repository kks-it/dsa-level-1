
import java.util.Scanner;

public class pattern17 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces = n/2;
        int stars = 1;
        for(int row = 1; row <= n; row++){
            for(int sp = 1; sp <= spaces; sp++){
                if(row == (n + 1) / 2){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }

            for(int st = 1; st <= stars; st++){
                System.out.print("*\t");
            }

            System.out.println();
            if(row <= n/2){
                stars++;
            }else{
                stars--;
            }

        }
    }
}
