import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int stars = (n + 1)/2;
        int spaces = 1 ;

        for(int row = 1; row <= n  ; row++){
            for(int st = 1; st <= stars; st++){
                System.out.print("*" + "\t");
            }
            for(int sp = 1; sp <= spaces; sp++){
                System.out.print("\t");
            }
            for(int st = 1; st <= stars; st++){
                System.out.print("*" + "\t");
            }
            if( row <= n/2){
                stars--;
                spaces += 2;
            }else{
                spaces -= 2;
                stars++;
            }
            System.out.println();
        }
    }
}
