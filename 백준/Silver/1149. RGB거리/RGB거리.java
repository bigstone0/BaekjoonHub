import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    static int result=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        dp=new int[N][3];
        cost=new int[N][3];

        for(int i=0;i<N;i++){
            cost[i]= Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0;i<3;i++){
            result=Math.min(result,house(0,i));
        }

        System.out.println(result);

    }

    static int house(int start, int color){
        if(start==N-1){
            return cost[start][color];
        }

        if(dp[start][color]!=0) return dp[start][color];
        else {
            dp[start][color]=Integer.MAX_VALUE;
            for(int i=0;i<3;i++){
                if(color==i) continue;
                dp[start][color] = Math.min(house(start+1,i)+cost[start][color],dp[start][color]);
            }
        }

        return dp[start][color];
    }
}
