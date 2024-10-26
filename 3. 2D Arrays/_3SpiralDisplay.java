
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Sample input1:
// 3
// 4
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// 11
// 12

// Sample Output1:
// 1       5       9       10      11      12      8       4       3       2       6       7

// Sample Input2:
// 3
// 3
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9

// Sample Output2:
// 1       4       7       8       9       6       3       2

public class _3SpiralDisplay {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(br.readLine());
            }
        }
        System.out.println("<---------------Input------------------>");
        display(matrix);
        System.out.println("<-----------------Output----------------------->");
        printSpiralArray(matrix);
    }

    public static void printSpiralArray(int[][] matrix) {
        int rowMin = 0, rowMax = matrix.length - 1, colMin = 0, colMax = matrix[0].length - 1;

        while (rowMin <= rowMax && colMin <= colMax) {
            if (colMin <= colMax) {
                for (int row = rowMin; row <= rowMax; row++) {
                    System.out.print(matrix[row][colMin] + "\t");
                }
                colMin++;
            }

            if (rowMin <= rowMax) {
                for (int col = colMin; col <= colMax; col++) {
                    System.out.print(matrix[rowMax][col] + "\t");
                }
                rowMax--;
            }

            if (colMin <= colMin) {
                for (int row = rowMax; row >= rowMin; row--) {
                    System.out.print(matrix[row][colMax] + "\t");
                }
                colMax--;
            }

            if (rowMin <= rowMax) {
                for (int col = colMax; col >= colMin; col--) {
                    System.out.print(matrix[rowMin][col] + "\t");
                }
                rowMin++;
            }
            System.out.println();
        }
    }

    public static void display(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < matrix[0].length; col++) {
                sb.append(matrix[row][col]);
                sb.append("\t");
            }
            System.out.println(sb);
        }
    }
}
