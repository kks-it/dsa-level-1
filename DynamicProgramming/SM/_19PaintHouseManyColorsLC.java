package SM;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// leet code premium question: Paint House II

public class _19PaintHouseManyColorsLC {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][c];

        for(int i = 0; i < n; i++){
            for(int  j = 0; j < c; j++){
                cost[i][j] = Integer.parseInt(br.readLine());
            }
        }

        // int[] result =  paintHouseIIRecursion(cost, n, c, n - 1);
        // int min = Integer.MAX_VALUE;
        // for(int num: result){
        //     min = Math.min(min, num);
        // }

        int min = paintHoseIITabulation1D(cost);
        System.out.println("min cost: " + min);
    }

    public static int[] paintHouseIIRecursion(int[][] cost,int n, int c, int idx){
        if(idx == 0)    return cost[0];
        int[] result = paintHouseIIRecursion(cost, n, c, idx - 1);
        int min =  Integer.MAX_VALUE, smin = Integer.MAX_VALUE;

        for(int num: result){
            if(num < min){
                smin = min;
                min = num;
            }else if(num < smin){
                smin = num;
            }
        }

        for(int i = 0; i < c; i++){
            if(result[i] == min){
                result[i] = min + cost[idx][i];
            }else if(result[i] == smin){
                result[i] = smin + cost[idx][i];
            }
        }

        return result;
    }

    public static int paintHoseIITabulation1D(int[][] cost){
        int h = cost.length, c = cost[0].length;

        int[] dp = new int[c];
        for(int i = 0; i < c; i++){
            dp[i] = cost[0][i];
        }

        for(int i = 1; i < h; i++){
            int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
            for(int num: dp){
                if(num < min){
                    smin = min;
                    min = num;
                }else if(num < smin){
                    smin = num;
                }
            }

            for(int j = 0; j < c; j++){
                if(dp[j] == min){
                    dp[j] = min + cost[i][j];
                }else{
                    dp[j] = smin + cost[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int num: dp){
            if(num < min) min = num;
        }

        return min;

    }

}   
