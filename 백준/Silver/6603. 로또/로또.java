import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] S;
    static boolean[] check;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());
            S=new int[k];
            if(k==0) break;
            check=new boolean[k];
            for(int i=0;i<k;i++){
                S[i]=Integer.parseInt(st.nextToken());
            }

            dfs(0,0,new StringBuffer());

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int index,int count,StringBuffer sb) throws IOException{
        if(count==6){
            bw.write(sb.toString()+"\n");
            return;
        }

        for(int i=index;i<k;i++){
            if(!check[i]){
                check[i]=true;
                dfs(i,count+1,new StringBuffer(sb+""+S[i]+" "));
                check[i]=false;
            }
        }
    }
}
