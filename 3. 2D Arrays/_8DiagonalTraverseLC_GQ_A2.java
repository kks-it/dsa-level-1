
import java.util.Scanner;

public class _8DiagonalTraverseLC_GQ_A2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int rows = scn.nextInt();
        int cols = scn.nextInt();

        int[][] matrix = new int[rows][cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                matrix[row][col] = scn.nextInt();
            }
        }
        scn.close();

        Solution sol = new Solution();
        int[] result = sol.findDiagonalOrder(matrix);

        System.out.println("<----------------------------Output----------------------->");
        for(int val: result){
            System.out.println(val);
        }
    }
} 

class Solution{
    public int[] findDiagonalOrder(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        boolean up = true;

        int diagonals = rows + cols - 1;

        int[] result = new int[rows * cols];
        int index = 0;

        int rowt = -1, colt = -1, rowh = -1, colh = -1;
        for(int dia = 0; dia < diagonals; dia++){
            if(up == false){
                rowh = colt < cols - 1? 0: rowt + 1;
                colh = colt < cols - 1? colt + 1: cols - 1;

                while(rowh < rows && colh > -1){
                    result[index++] = mat[rowh][colh];
                    rowt = rowh; colt = colh;
                    rowh++; colh--;
                }
                up = true;

            }else{
                rowh = rowt < rows - 1? rowt + 1: rows - 1;
                colh = rowt < rows - 1? 0: colt + 1;

                while(rowh > -1 && colh < cols){
                    result[index++] = mat[rowh][colh];
                    rowt = rowh; colt = colh;
                    rowh--; colh++;
                }
                up = false;
            }
        }

        return result;
    }
}