import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N,M,start,end;
    static int[] result;
    static int[][] city;
    static boolean[] vist;
    public static void main(String[] args) throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        StringTokenizer st;
        result=new int[N+1];
        vist=new boolean[N+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        city=new int[N+1][N+1];
        for(int i=0;i<N+1;i++) Arrays.fill(city[i],Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            city[x][y]=Math.min(city[x][y],v);
        }

        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());


        for(int i=1;i<N+1;i++) {
            result[i]=city[start][i];
        }
        vist[start]=true;

        int min=Integer.MAX_VALUE;
        int minIndex=Integer.MAX_VALUE;

        for(int i=1;i<N+1;i++){
            if(!vist[i]){
                if(min>result[i]){
                    min=result[i];
                    minIndex=i;
                }
            }
        }

        djik(minIndex);

        System.out.println(result[end]);
    }

    static void djik(int index){
        for(int i=1;i<N+1;i++){
            if(city[index][i]==Integer.MAX_VALUE||vist[i]) continue;
            result[i]=Math.min(result[i],result[index]+city[index][i]);
        }

        vist[index]=true;

        int min=Integer.MAX_VALUE;
        int minIndex=Integer.MAX_VALUE;

        for(int i=1;i<N+1;i++){
            if(!vist[i]){
                if(min>result[i]){
                    min=result[i];
                    minIndex=i;
                }
            }
        }

        if(min!=Integer.MAX_VALUE) djik(minIndex);
    }
}
