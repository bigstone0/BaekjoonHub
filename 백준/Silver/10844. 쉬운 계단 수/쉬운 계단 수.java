import java.io.*;
import java.util.*;

// #10844(silver1)
public class Main {
    static long big=1000000000;
    static int N;
    static long[][] dp;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dp = new long[N+1][10];

        for (int i = 1; i < 10; i++) {
            count += stair(i, N);
        }
        System.out.println((long)(count%big));
    }

    static long stair(int start, int num) {
        if (num == 1) {
            dp[num][start]=1;
            return 1;
        }
        if (dp[num][start] != 0) return dp[num][start]%big;
        switch (start) {
            case 0:
                dp[num][start] = stair(1, num-1);
                break;
            case 9:
                dp[num][start] = stair(8, num-1);
                break;
            default:
                dp[num][start] = stair(start + 1, num-1)+stair(start - 1, num-1);
        }
        return dp[num][start]%big;
    }
}
