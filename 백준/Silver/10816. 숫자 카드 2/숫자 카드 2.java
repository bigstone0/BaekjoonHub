import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int[] A;
    static int[] B;
    static HashMap<Integer,Integer> map;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        map=new HashMap<>(N);
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
            if(map.containsKey(A[i])) map.replace(A[i],map.get(A[i])+1);
            else map.put(A[i],1);
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        B = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);
        for(int i=0;i<M;i++){
            BS(0,N-1,B[i]);
        }

        bw.flush();
        bw.close();
    }

    static void BS(int start,int end, int num) throws IOException{
        if(start>end) {
            bw.write(0+" ");
            return;
        }

        int mid=(start+end)/2;
        if(A[mid]==num){
            bw.write(map.get(A[mid])+" ");
            return;
        }

        if(A[mid]<num) BS(mid+1,end,num);
        else if(A[mid]>num) BS(start,mid-1,num);

    }
}
