//{ Driver Code Starts
// Initial Template for Java

// Question Link: https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
package SM;

import java.io.*;
import java.util.*;

public class _13CountBinariesWithoutConsecutive1s {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        // code here
        
        // long[] counts = solution(n);
        // return (counts[0] + counts[1]) % 1_000_000_007;
        
        return solutionTab(n);
    }
    
    // key = ez, value = nez
    public static long[] solution(int n){
        if(n == 1){
            long[] counts = new long[2];
            counts[0] = 1; counts[1] = 1;
            return counts;
        }
        
        long[] childCounts = solution(n - 1);
        
        long[] counts = new long[2];
        counts[0] = childCounts[1] % 1_000_000_007; counts[1] = (childCounts[0] + childCounts[1]) % 1_000_000_007;
        return counts;
        
    }
    
    public static long solutionTab(int n){
        long zeros = 1, nonZeros = 1;
        
        for(int i = 2; i <= n; i++){
            long sum = (zeros + nonZeros) % 1_000_000_007 ;
            zeros = nonZeros;
            nonZeros = sum;
        }
        return (zeros + nonZeros) % 1_000_000_007;
    }
    
}