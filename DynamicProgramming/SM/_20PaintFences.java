package SM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _20PaintFences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int ans =  paintFences(n, k);
        System.out.println("ans: " + ans);
    }

    public static int paintFences(int n, int k){
        int same = 0, different = k;

        for(int i = 2; i <= n; i++){
            int temp = same;
            same = different;
            different = (temp + different) * (k - 1);
        }
        return same + different;
    }
}
