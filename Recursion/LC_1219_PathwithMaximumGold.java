package Recursion;

class LC_1219_PathwithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                max = Math.max(max, maxGold(grid, i, j));
            }
        }

        return max;
    }

    public int maxGold(int[][] grid, int row, int col){
        if(grid[row][col] == 0) return 0;
        int result = grid[row][col];
        grid[row][col] = 0;

        int max = Integer.MIN_VALUE;
        if(row - 1 >= 0){
            max = Math.max(max, maxGold(grid, row - 1, col));
        }

        if( col + 1 < grid[0]. length){
            max = Math.max(max, maxGold(grid, row, col + 1));
        }

        if(row + 1 < grid.length){
            max = Math.max(max, maxGold(grid, row + 1, col));
        }

        if(col - 1 >= 0){
            max = Math.max(max, maxGold(grid, row, col - 1));
        }
        grid[row][col] = result;
        return result + max;
    }
}