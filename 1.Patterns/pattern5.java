import java.util.Scanner;


public class pattern5 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces = n/2;
        int stars = 1;

        for(int row = 1; row <= (n+1)/2; row++){
            for(int sp = 1; sp <= spaces; sp++){
                System.out.print("\t");
            }
            for(int st = 1; st <= stars; st++){
                System.out.print("*" + "\t");
            }
            spaces--;
            stars += 2;
            System.out.println();
        }

        spaces = 1; stars = n-2 ;
        for(int row = 1; row <= n/2; row++){
            for(int sp = 1; sp <= spaces; sp++){
                System.out.print("\t");
            }
            for(int st = 1; st <= stars; st++){
                System.out.print("*" + "\t");
            }
            spaces++;
            stars-= 2;
            System.out.println();
        }
    }
}
