import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static long L, R, X;
    static long[] A;
    static int flag = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        A = new long[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        if (N == 1) {
            System.out.println(0);
        } else {
            back(0, 0, flag);
            System.out.println(count);
        }
    }

    static void back(int idx, int start, int flag) {
        long result=0;
        long hard=Long.MIN_VALUE;
        long easy=Long.MAX_VALUE;

        if(idx>1){
            for(int i=0;i<N;i++){
                if((flag&(1<<i))!=0) {
                    result+=A[i];
                    easy=Math.min(easy,A[i]);
                    hard=Math.max(hard,A[i]);
                }
            }

            if(result>=L&&result<=R){
                if(hard-easy>=X){
                    count++;
                }
            }
        }

        for(int i=start;i<N;i++){
            if((flag&(1<<i))!=0) continue;;
            back(idx+1,i+1,flag|(1<<i));
        }
    }
}
