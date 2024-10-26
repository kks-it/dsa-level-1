import java.util.List;
import java.util.ArrayList;

class _3SpiralDisplayLC {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowMin = 0, rowMax = matrix.length - 1, colMin = 0, colMax = matrix[0].length - 1;

        while (rowMin <= rowMax && colMin <= colMax) {
            if (rowMin <= rowMax) {
                for (int col = colMin; col <= colMax; col++) {
                    result.add(matrix[rowMin][col]);
                }
                rowMin++;
            }

            if (colMin <= colMin) {
                for (int row = rowMin; row <= rowMax; row++) {
                    result.add(matrix[row][colMax]);
                }
                colMax--;
            }

            if (rowMin <= rowMax) {
                for (int col = colMax; col >= colMin; col--) {
                    result.add(matrix[rowMax][col]);
                }
                rowMax--;
            }

            if (colMin <= colMax) {
                for (int row = rowMax; row >= rowMin; row--) {
                    result.add(matrix[row][colMin]);
                }
                colMin++;
            }
        }
        return result;
    }

}