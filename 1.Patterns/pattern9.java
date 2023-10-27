
import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces1 = 0;
        int spaces2 = n-2;

        for(int row = 1; row <= n; row++){
            for(int sp = 1; sp <= spaces1; sp++){
                System.out.print("\t");
            }
            System.out.print("*" + "\t");
            for(int sp = 1; sp <= spaces2; sp++){
                System.out.print("\t");
            }
            if( row != (n + 1) / 2){
                System.out.print("*");
            }
            if(row <= n/2){
                spaces1++;
                spaces2 -= 2;
            }else{
                spaces1--;
                spaces2 += 2;
            }
            System.out.println();
        }
    }
}
