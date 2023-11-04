
import java.util.Scanner;

public class pattern19 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for (int row = 1; row <= n; row++) {
            // row 1
            if (row == 1) {
                for (int col = 1; col <= n; col++) {
                    if (col <= (n + 1) / 2 || col == n) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }

            int spaces = n / 2;
            if (row >= 2 && row <= n / 2) {
                // row 2 to n <= n/2
                for (int sp = 1; sp <= spaces; sp++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int sp = 1; sp <= spaces - 1; sp++) {
                    System.out.print("\t");
                }
                System.out.print("*");
            }

            if (row == (n + 1) / 2) {
                // row (n + 1) / 2
                for (int col = 1; col <= n; col++) {
                    System.out.print("*\t");
                }
            }

            if (row > (n + 1) / 2 && row < n) {
                // row ( n + 1) / 2 to n -1
                System.out.print("*\t");
                for (int sp = 1; sp <= spaces - 1; sp++) {
                    System.out.print("\t");
                }
                System.out.print("*");
            }

            if (row == n) {
                // row n
                for (int col = 1; col <= n; col++) {
                    if (col == 1 || col > n / 2) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }

    }
}
