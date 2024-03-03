import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main{
    static int N;
    static int[] minDp;
    static int[] maxDp;
    static int[] beforeDp;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        maxDp=new int[3];
        minDp=new int[3];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++){
            int num=Integer.parseInt(st.nextToken());
            maxDp[i]=num;
            minDp[i]=num;
        }

        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int n0=Integer.parseInt(st.nextToken());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int beforeMax0=maxDp[0];
            int beforeMax2=maxDp[2];
            maxDp[0]=Math.max(beforeMax0,maxDp[1])+n0;
            maxDp[2]=Math.max(maxDp[1],beforeMax2)+n2;
            maxDp[1]=Math.max(beforeMax0,Math.max(maxDp[1],beforeMax2))+n1;

            int beforeMin0=minDp[0];
            int beforeMin2=minDp[2];
            minDp[0]=Math.min(beforeMin0,minDp[1])+n0;
            minDp[2]=Math.min(minDp[1],beforeMin2)+n2;
            minDp[1]=Math.min(beforeMin0,Math.min(minDp[1],beforeMin2))+n1;
        }

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            max=Math.max(max,maxDp[i]);
            min=Math.min(min,minDp[i]);
        }

        bw.write(max+" "+min);
        bw.flush();
        bw.close();
    }
}
