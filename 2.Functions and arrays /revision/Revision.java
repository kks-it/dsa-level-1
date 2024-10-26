package revision;

import java.io.IOException;

public class Revision {
    public static void main(String[] args) throws IOException {
        int count = 5;
        int[] arr = { 3, 1, 0, 7, 5 };

        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            max = Math.max(max, num);
        }

        for (int row = max; row >= 1; row--) {
            for (int col = 1; col <= count; col++) {
                if (arr[col] >= row) {
                    System.out.println("*\t");
                } else {
                    System.out.println("\t");
                }
            }
        }
    }
}