import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        dfs(1,0,new StringBuffer());

        bw.flush();
        bw.close();
    }

    static void dfs(int index, int count, StringBuffer sb) throws IOException{
        if(count==M){
            bw.write(sb+"\n");
            return;
        }

        for(int i=index;i<=N;i++){
            dfs(i,count+1,new StringBuffer(sb+""+i+" "));
        }
    }
}
