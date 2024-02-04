import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int T, n;
    static int[][] sti;
    static int[][] dp;
    static int max;
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        s = new int[T];

        for (int i = 0; i < T; i++) {
            max = Integer.MIN_VALUE;
            n = Integer.parseInt(bf.readLine());
            sti = new int[2][n];
            dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                sti[j] = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.fill(dp[j], -1);
            }
            if(n==1) {
                s[i]=Math.max(sti[0][0],sti[1][0]);
                continue;
            }
            stick(0, 0);
            stick(1, 0);
            s[i] = max;
        }
        for (int i = 0; i < s.length; i++) System.out.println(s[i]);
    }

    static int stick(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        if (x == 1) {
            if ((y + 1) < n) dp[x][y] = Math.max(dp[x][y], sti[x][y] + stick(x - 1, y + 1));
            if ((y + 2) < n) dp[x][y] = Math.max(dp[x][y], sti[x][y] + stick(x - 1, y + 2));
        } else {
            if ((y + 1) < n) dp[x][y] = Math.max(dp[x][y], sti[x][y] + stick(x + 1, y + 1));
            if ((y + 2) < n) dp[x][y] = Math.max(dp[x][y], sti[x][y] + stick(x + 1, y + 2));
        }
        max = Math.max(max, dp[x][y]);
        if(dp[x][y]!=-1) return dp[x][y];
        else return sti[x][y];
    }
}
