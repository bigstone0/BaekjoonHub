import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[] seq;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        seq = new int[n];
        dp=new int[n];

        seq = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp[n-1]=seq[n-1];
        max=seq[n-1];

        for(int i=n-2;i>-1;i--){
            sum(i);
            max=Math.max(max,dp[i]);
        }

        System.out.println(max);
    }

    static void sum(int start) {
        dp[start]=Math.max(seq[start],seq[start]+dp[start+1]);
    }
}
