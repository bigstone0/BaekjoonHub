import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] seq;
    static int[] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        seq = new int[N];
        dp=new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken(" "));
        }

        for (int i = 0; i <N; i++) {
            if(dp[i]==0) max = Math.max(seqSort(i),max);
        }
        System.out.println(max+1);
    }

    static int seqSort(int start) {
        if(dp[start]!=0) return dp[start];
        for (int i = start; i <N; i++) {
            if (seq[i] > seq[start]) {
                dp[start]=Math.max(seqSort(i)+1,dp[start]);
            }
        }
        return dp[start];
    }
}
