
import java.util.Scanner;
import java.util.ArrayList;

public class _8DiagonalTraverseLC_GQ_A1 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] matrix = new int[n][m];

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m ; col++){
                matrix[row][col] = scn.nextInt();
            }
        }

        Solution sol = new Solution();
        int[] result = sol.findDiagonalOrder(matrix);

        display(result);
    }

    public static void display(int[] result){
        System.out.println("<--------------------Output------------------->");
        for(int val : result){
            System.out.println(val + "\t");
        }
    }
}

class Solution{
    public int[] findDiagonalOrder(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];
        int index = 0;

        int diagonals  = rows + cols - 1;

        for(int dia = 1; dia <= diagonals; dia++){
            int row = dia < cols ? 0: dia - cols;
            int col = dia < cols ? dia - 1 : cols - 1;

            ArrayList<Integer> inter = new ArrayList<>();

            while(col > -1 && row < rows){
                // System.out.println("row--> " + row + "cols--> " + col + "value --> " + mat[row][col]);
                inter.add(mat[row][col]);
                row++; col--;
            }

            int size = inter.size();
            if(dia % 2 == 1){
                for(int i = size -1; i >= 0; i--){
                    result[index] = inter.get(i);
                    index++;
                }
            }else{
                for(int i = 0; i < size; i++){
                    result[index] = inter.get(i);
                    index++;
                }
            }
        }

        return result;
    }
}
