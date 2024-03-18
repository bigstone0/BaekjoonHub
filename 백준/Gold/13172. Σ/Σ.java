import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int M,N,S;
    static long result=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            S=Integer.parseInt(st.nextToken());

            result = (result+(S*(sum(N,1000000005)%1000000007))%1000000007)%1000000007;
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    static long sum(long num, long module){
        if(module==1) return num;

        else {
            if(module%2==1){
                long pow = (sum(num,(module-1)/2))%1000000007;
                return (((pow*pow)%1000000007)*num)%1000000007;
            }
            else{
                long pow = sum(num,module/2);
                return (pow*pow)%1000000007;
            }
        }
    }
}
