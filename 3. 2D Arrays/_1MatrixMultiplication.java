
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Sample Input1:
// 3    matrix1 rows
// 3    matrix1 cols
// 2
// 2
// 2
// 2
// 2
// 2
// 2
// 2
// 2
// 3    matrix2 rows
// 3    matrix2 cols
// 3
// 3
// 3
// 3
// 3
// 3
// 3
// 3
// 3

// Sample Output2:
// 18      18      18
// 18      18      18
// 18      18      18

public class _1MatrixMultiplication{
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ) );

        int n1 = Integer.parseInt(br.readLine());
        int m1 = Integer.parseInt(br.readLine());

        int[][] matrix1 = new int[n1][m1];

        for(int row = 0; row < n1; row++){
            for(int col = 0; col < m1; col++){
                matrix1[row][col] = Integer.parseInt(br.readLine());
            }
        }


        int n2 = Integer.parseInt(br.readLine());
        int m2 = Integer.parseInt(br.readLine());

        int[][] matrix2 = new int[n2][m2];

        for(int row = 0; row < n2; row++){
            for(int col = 0; col < m2; col++){
                matrix2[row][col] = Integer.parseInt(br.readLine());
            }
        }

        if(m1 == n2){
            int[][] mul = matrixMultiplication(matrix1, matrix2, n1, m1, n2, m2);
            display(mul);
        }else{
            System.out.println("Matrices with given dimensions cannot be multiplied");
        }
    }

    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2, int n1, int m1, int n2, int m2){
        int[][] result = new int[n1][m2];

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                int sum = 0;
                for(int k = 0; k < m1; k++){
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void display(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col < matrix[0].length; col++){
                sb.append(matrix[row][col]);
                sb.append("\t");
            }
            System.out.println(sb);
        }
    }
}