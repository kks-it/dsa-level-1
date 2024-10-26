
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _7StateOfWakanda2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(br.readLine());
        // int cols = Integer.parseInt(br.readLine());

        int[][] matrix = new int[rows][rows];

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix.length; col++){
                matrix[row][col] = Integer.parseInt(br.readLine());
            }
        }

        printItemsDiagonally(matrix);
    }

    public static void printItemsDiagonally(int[][] matrix){
        System.out.println("<------------------Output------------------------->");
        int offset = 0;
        for(int diagonalSize = matrix.length; diagonalSize >= 1; diagonalSize--){
            for(int row = 0; row < diagonalSize; row++){
                int col = row + offset;
                // System.out.print("row --> "+ row + "col" + col);
                System.out.println(matrix[row][col]);
            }
            offset++;
        }

    }
}
