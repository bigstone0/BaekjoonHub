import java.util.*;
import java.io.*;

//silver 1
public class Main {
    static int n;
    static int[][] dp;
    static int[] wine;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        wine = new int[n];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for (int i = 0; i < n; i++) {
            MAX = Math.max(eat(i, 0), MAX);
        }
        System.out.println(MAX);
    }

    static int eat(int start, int num) {
        if (num == 2) {
            if (start == n - 1) return 0;
            return eat(start + 1, 0);
        } else {
            if (start == n - 1) {
                dp[start][num] = wine[start];
                return wine[start];
            }
            if (dp[start][num] != -1) return dp[start][num];

            for(int i=1;i<n-start;i++){
                if(i==1) dp[start][num] = Math.max(eat(start + i, num + 1) + wine[start], dp[start][num]);
                else dp[start][num] = Math.max(eat(start + i, 0) + wine[start], dp[start][num]);
            }
        }
        return dp[start][num];
    }
}
