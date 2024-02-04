import java.util.*;
import java.io.*;

// #12865(gold5)
public class Main {
    static int N, K;
    static int[] w;
    static int[] v;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w= new int[N+1];
        v=new int[N+1];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for(int j=1;j<=K;j++){
                dp[i][j]=dp[i-1][j];
                if(j-w[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
