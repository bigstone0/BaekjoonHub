import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num=new int[M];
        check=new boolean[N];

        for(int i=0;i<N;i++){
            check[i]=true;
            num[0]=i+1;
            dfs(i+1,1);
            check[i]=false;
        }
    }
    static void dfs(int index, int count){
        if(count==M){
            for(int i=0;i<M;i++) System.out.print(num[i]+" ");
            System.out.println();
            return;
        }

        for(int i=index;i<=N;i++){
            if(check[i-1]) continue;
            check[i-1]=true;
            num[count]=i;
            dfs(i,count+1);
            check[i-1]=false;
        }
    }
}
