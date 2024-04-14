import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static long[] sum;
    static int[] modNum;
    static long result=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        sum = new long[N];
        S = Integer.parseInt(st.nextToken(" "));
        modNum=new int[S];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i == 0) sum[i] = Integer.parseInt(st.nextToken(" "));
            else {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken(" "));
            }
            modNum[(int)(sum[i]%S)]++;
        }

        for(int i=0;i<S;i++){
            if(modNum[i]==0||modNum[i]==1) continue;
            else if(modNum[i]==2) result+=1;
            else{
                result+=((long) modNum[i] *(modNum[i]-1))/(2);
            }
        }
        result+=modNum[0];

        System.out.println(result);

    }
}



