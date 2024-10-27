import java.util.Arrays;

public class Revison {
    public static void main(String[] args) {
        int[][] arr1 = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
        int[][] arr2 = { { 3, 3, 3 }, { 3, 3, 3 }, { 3, 3, 3 } };

        int[][] result = matrixMultiplication(arr1, arr2);

        Arrays.stream(result).forEach((arr) -> {
            for (int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        });
    }

    public static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {
        if (arr1[0].length != arr2.length) {
            return null;
        }

        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                // calculate result[i][j]
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}