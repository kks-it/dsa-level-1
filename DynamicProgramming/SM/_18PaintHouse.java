package SM;

// Question Link: https://www.geeksforgeeks.org/problems/distinct-coloring--170645/1



public class _18PaintHouse{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        int mod = 1_000_000_007;
        long red = 0, blue = 0, green = 0;
        
        for(int i = 0; i < N; i++){
            long nextRed = Math.min(blue, green) + r[i] % mod;
            long nextBlue = Math.min(red, green ) + b[i] % mod;
            long nextGreen = Math.min(red, blue) + g[i] % mod;
            
            red = nextRed; blue = nextBlue; green = nextGreen;
            
            // System.out.println("house " + i + "  :  " + " r b g" + red + " : " + blue + " : " + green);
        }
        
        long min = red;
        if(blue < min)  min = blue;
        if(green < min) min = green;
        
        return min;
    }
}


