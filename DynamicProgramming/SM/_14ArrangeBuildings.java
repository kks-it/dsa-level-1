// Question Link : https://www.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
package SM;
class Solution1
{
    public int TotalWays(int N)
    {
        // Code here
        //ewb --> ends with building; ews --> ends with space
        long ewb = 1;
        long ews = 1;
        
        for(int i = 2; i <= N; i++){
            long sum = (ewb + ews) % 1_000_000_007;
            ewb = ews;
            ews = sum;
        }
        
        long resultOneSide =  (ewb + ews) % 1_000_000_007; 
        return (int) ((resultOneSide * resultOneSide) % 1_000_000_007);
    }
}