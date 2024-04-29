package SM;
//  Question Link: https://www.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1

class _16CountSubsequences{   
    static int mod = 1_000_000_007;
    public int fun(String s)
    {
        // Write your code here
        // int[] counts = solutionRecusion(s, s.length() - 1);
        // return counts[2] % mod;
        
        return solutionDP(s);
    }
    
    public static int[] solution(String s, int index){
        if(index == 0){
            int[] counts = new int[3];
            if(s.charAt(0) == 'a')
                counts[0] = 1;
            return counts;
        }
        
        int[] counts = solution(s, index - 1);
        switch(s.charAt(index)){
            case 'a':
                counts[0] =( (2 * counts[0] )  % mod + 1)  % mod;
                break;
            case 'b':
                counts[1] =( (2 * counts[1])  % mod + counts[0])  % mod;
                break;
            case 'c':
                counts[2] = ((2 * counts[2])  % mod + counts[1])  % mod;
        }
        
        return counts;
    }
    
    
    public static int solutionDP(String s){
        int n = s.length();
        int ea = 0, eb = 0, ec = 0;
        
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'a':
                    ea =( 2 * ea ) % mod + 1;
                    break;
                case 'b':
                    eb = ((2 * eb) % mod + ea) % mod;
                    break;
                case 'c':
                    ec = ( ( 2 * ec) % mod + eb) % mod;
            }
        }
        return ec;
    }
}