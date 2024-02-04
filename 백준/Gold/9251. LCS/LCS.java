import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static String[] first;
    static String[] second;
    static int[][] dp;
    static int max;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        first=bf.readLine().split("");
        second=bf.readLine().split("");
        dp=new int[first.length+1][second.length+1];

        for(int i=0;i<first.length;i++){
            for(int j=0;j<second.length;j++){
                check(i,j);
            }
        }

        System.out.println(max);
    }

    static void check(int a, int b){
        if(first[a].equals(second[b])){
            dp[a+1][b+1]=dp[a][b]+1;
        }
        else{
            dp[a+1][b+1]=Math.max(dp[a][b+1],dp[a+1][b]);
        }

        max=Math.max(max,dp[a+1][b+1]);
    }
}
