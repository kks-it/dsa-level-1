package SM;

import java.util.Scanner;

// Sample Input1:
// 6
// 6
// 0
// 1
// 4
// 2
// 8
// 2
// 4
// 3
// 6
// 5
// 0
// 4
// 1
// 2
// 4
// 1
// 4
// 6
// 2
// 0
// 7
// 3
// 2
// 2
// 3
// 1
// 5
// 9
// 2
// 4
// 2
// 7
// 0
// 8
// 5
// 1

// Sample Output1:
// 33

public class _6GoldMine {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int rows = scn.nextInt(); int cols = scn.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int maxGold = goldMine(arr);
        System.out.println("max gold: " + maxGold);
    }

    public static int goldMine(int[][] arr){
        int rows = arr.length, cols = arr[0].length;

        int[][] dp = new int[rows][cols];

        for(int col = cols - 1; col >= 0; col--){
            for(int row = rows -1; row >= 0; row--){
                if(col == cols - 1){
                    dp[row][col] = arr[row][col];
                }else{
                    int max = dp[row][col + 1];
                    if(row - 1 >= 0){
                        max = Math.max(max, dp[row - 1][col + 1]);
                    }

                    if(row + 1 < rows){
                        max = Math.max(max, dp[row + 1][col + 1]);
                    }
                    dp[row][col] = max + arr[row][col];
                }
            }
        }
        int maxGold = 0;
        for(int row = 0; row < rows; row++){
            maxGold = Math.max(maxGold, dp[row][0]);
        }

        return maxGold;
    }
}
