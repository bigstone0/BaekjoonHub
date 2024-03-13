import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int mod=1000;
    static int N;
    static long B;
    static int[][] hang;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        B=Long.parseLong(st.nextToken());
        hang=new int[N][N];
        dp=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) hang[i][j]=Integer.parseInt(st.nextToken())%mod;
        }

        dp=sum(B);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(dp[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static int[][] sum(long num){
        if(num==1){
            return hang;
        }

        int[][] tmp=sum(num/2);

        tmp=gop(tmp,tmp);

        if(num%2==1){
            tmp=gop(tmp,hang);
        }

        return tmp;
    }

    static int[][] gop(int[][] a, int [][] b){
        int [][] tmp=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    tmp[i][j]=tmp[i][j]+((a[i][k]*b[k][j])%mod);
                }
                tmp[i][j]%=mod;
            }
        }
        return tmp;
    }
}
