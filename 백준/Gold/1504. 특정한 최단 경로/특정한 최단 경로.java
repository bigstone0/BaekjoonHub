import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, E, v1, v2;
    static int[][] list;
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        list=new int[N+1][N+1];
        for(int i=0;i<list.length;i++) Arrays.fill(list[i],Integer.MAX_VALUE);

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[a][b]=c;
            list[b][a]=c;
        }

        st=new StringTokenizer(br.readLine());
        v1=Integer.parseInt(st.nextToken());
        v2=Integer.parseInt(st.nextToken());
        ploid();

        int distanceV1;
        int distanceV2;

        for(int i=1;i<=N;i++) list[i][i]=0;
        if(list[v1][N]==Integer.MAX_VALUE||list[1][v2]==Integer.MAX_VALUE||list[v2][v1]==Integer.MAX_VALUE
        ){
            distanceV1=Integer.MAX_VALUE;
        } else distanceV1=list[1][v2]+list[v2][v1]+list[v1][N];

        if(list[v2][N]==Integer.MAX_VALUE||list[1][v1]==Integer.MAX_VALUE||list[v1][v2]==Integer.MAX_VALUE){
            distanceV2=Integer.MAX_VALUE;
        } else distanceV2=list[1][v1]+list[v1][v2]+list[v2][N];

        result=Math.min(distanceV1,distanceV2);

        if(result==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
    static void ploid(){
        for(int j=1;j<=N;j++){
            for(int i=1;i<=N;i++){
                for(int k=1;k<=N;k++){
                    if(list[i][j]==Integer.MAX_VALUE||list[j][k]==Integer.MAX_VALUE||i==k) continue;
                    list[i][k]=Math.min(list[i][j]+list[j][k],list[i][k]);
                }
            }
        }
    }
}
