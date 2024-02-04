import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        cost=new int[n][n];
        dp=new int[n][n];

        for(int i=0;i<n;i++){
            cost[i]= Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dp[i],-1);
        }

        System.out.println(tri(0,0));
    }
    static int tri(int x,int y){
        if(x==n-1) return cost[x][y];

        if(dp[x][y]!=-1) return dp[x][y];

        for(int i=0;i<2;i++){
            dp[x][y]=Math.max(tri(x+1,y+i)+cost[x][y],dp[x][y]);
        }

        return dp[x][y];
    }
}
