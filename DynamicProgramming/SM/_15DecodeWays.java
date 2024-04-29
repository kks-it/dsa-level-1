// Question Link: https://leetcode.com/problems/decode-ways/description/

public class _15DecodeWays {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        // return solutionMem(s, s.length() - 1, dp);

        return solutionTab(s);
    }

    public static int solutionMem(String s, int index, Integer[] dp){
            if(index == 0)   return  (s.charAt(0) != '0'? 1: 0);
            if(index < 0)   return 1;
    
            if(dp[index] != null)   return dp[index];
    
            int ways = 0;
            if(s.charAt(index) != '0'){
                ways += solutionMem(s, index - 1, dp);
            }
    
            if(s.charAt(index - 1) != '0' && Integer.parseInt(s.substring(index - 1, index + 1)) <= 26){
                ways += solutionMem(s, index - 2, dp);
            }
            // System.out.println("index " + index + " ways " + ways);
            return dp[index] = ways;
        }

    public static int solutionTab(String s) {
        int a = 1, b = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            int ways = 0;
            if (s.charAt(i) != '0')
                ways += b;
            if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                ways += a;
            }
            a = b;
            b = ways;
        }

        return b;
    }
}