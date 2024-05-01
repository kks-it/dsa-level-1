package SM;

// question link : https://www.naukri.com/code360/problems/friends-pairing-problem_1214625?leftPanelTabValue=PROBLEM

public class _22FriendsPairing {
    static int mod = 1_000_000_007;
    public static int numberOfWays(int n) {
        // Write your code here.
        long prev = 1, current = 1;

        for(int i = 2; i <= n ; i++){
            long next =( current + prev * ( i - 1) % mod) % mod;
            prev = current;
            current = next;
        }

        return (int) current;
    }
}
