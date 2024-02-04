import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num=new int[M];

        for(int i=0;i<N;i++){
            StringBuffer s=new StringBuffer();
            dfs(i+1,1,s.append(i+1+" "));
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int index,int count,StringBuffer s) throws IOException{
        if(count==M){
            bw.write(s+"\n");
            return;
        }

        for(int i=1;i<=N;i++){
            dfs(i,count+1,new StringBuffer(s+""+i+" "));
        }
    }
}
