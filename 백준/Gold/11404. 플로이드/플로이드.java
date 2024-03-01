import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] distance;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        distance=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
            distance[i][i]=0;
        }
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            distance[start][end]=Math.min(value,distance[start][end]);
        }

        fm();

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(distance[i][j]==Integer.MAX_VALUE) bw.write(0+" ");
                else bw.write(distance[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void fm(){
        for(int i=1;i<n+1;i++){ // 거치는 노드
            for(int j=1;j<n+1;j++){ // 출발노드
                for(int k=1;k<n+1;k++){ // 도착노드
                    if(distance[j][i]==Integer.MAX_VALUE||distance[i][k]==Integer.MAX_VALUE) continue;
                    distance[j][k]=Math.min(distance[j][k],distance[j][i]+distance[i][k]);
                }
            }
        }
    }
}
