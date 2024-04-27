
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Sample Input1:
// 2
// 3
// 1
// 2
// 3
// 4
// 5
// 6
// Sample Output1:
// 1
// 4
// 5
// 2
// 3
// 6

public class _2TheStateOfWakanda1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());

        int[][] matrix = new int[rows][cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                matrix[row][col] = Integer.parseInt(br.readLine());
            }
        }
        System.out.println("<------------------Output--------------------->");
        printWaveTraversal(matrix);
    }

    public static void printWaveTraversal(int[][] matrix){
        for(int col = 0; col < matrix[0].length; col++){
            if(col % 2 == 0){
                for(int row = 0; row < matrix.length; row ++){
                    System.out.println(matrix[row][col] + "\t");
                }
            }else{
                for(int row = matrix.length -1; row >= 0; row-- ){
                    System.out.println(matrix[row][col] + "\t");
                }
            }
        }
    }
}
