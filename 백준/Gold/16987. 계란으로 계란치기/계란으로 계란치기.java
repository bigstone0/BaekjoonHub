import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] egg;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        egg = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);

        System.out.println(max);
    }

    static void dfs(int hand,int count) {
        if(count==N-1||hand==N) {
            max=Math.max(max,count);
            return;
        }

        if(egg[hand][0]<=0) {
            dfs(hand+1,count);
            return;
        }

        int c=count;

        for (int i = 0; i < N; i++) {
            if(hand==i) continue;

            if(egg[i][0]<=0) continue;

            egg[hand][0] = egg[hand][0] - egg[i][1];
            egg[i][0] = egg[i][0] - egg[hand][1];
            if(egg[hand][0]<=0){
                count++;
            }

            if(egg[i][0]<=0){
                count++;
            }

            dfs(hand+1,count);

            egg[hand][0] = egg[hand][0] + egg[i][1];
            egg[i][0] = egg[i][0] + egg[hand][1];
            count=c;
        }
    }
}
