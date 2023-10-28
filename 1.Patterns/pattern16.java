import java.util.Scanner;

public class pattern16 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int spaces = n - 2;

        for(int row = 1; row <= (n + 1) / 2; row++){
            for(int val = 1; val <= row; val++){
                System.out.print(val + "\t");
            }

            for(int sp = 1; sp <= spaces; sp++){
                System.out.print("\t");
            }

            int values = row == (n + 1) / 2 ? row - 1: row;
            for(int val = values; val >= 1; val--){
                System.out.print(val + "\t");
            }

            System.out.println();
            spaces -= 2;
        }
    }
}
