
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _4ExitPointMatrix {
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

        printExitPoint(new int[3][4]);
    }

    public static void printExitPoint(int[][] matrix) {
        int row = 0, col = 0;
        // String[] directions = {"North", "East", "South", "West"};

        String currentDirection = "East";
        while (true) {
            while (matrix[row][col] == 0) {

                switch (currentDirection) {
                    case "North":
                        row--;
                        break;
                    case "East":
                        col++;
                        break;
                    case "South":
                        row++;
                        break;
                    case "West":
                        col--;
                        break;
                    default:
                        System.out.println(currentDirection);
                        System.out.println("unhandled case 0");
                        break;
                }
                if(hasExited(row, col, matrix)){
                    return;
                }
            }

            switch (currentDirection) {
                case "North":
                    col++;
                    currentDirection = "East";
                    break;
                case "East":
                    row++;
                    currentDirection = "South";
                    break;
                case "South":
                    col--;
                    currentDirection = "West";
                    break;
                case "West":
                    row--;
                    currentDirection = "North";
                    break;
                default:
                    System.out.println("unhandled case 1");
                    break;

            }
            if(hasExited(row, col, matrix)){
                return;
            }
        }

    }

    public static boolean hasExited(int row, int col, int[][] matrix) {
        if (row == matrix.length) {
            System.out.println(row - 1);
            System.out.println(col);
            return true;
        }

        if (row == -1) {
            System.out.println(row + 1);
            System.out.println(col);
            return true;
        }

        if (col == matrix[0].length) {
            System.out.println(row);
            System.out.println(col - 1);
            return true;
        }

        if (col == -1) {
            System.out.println(row);
            System.out.println(col + 1);
            return true;
        }
        return false;
    }
}