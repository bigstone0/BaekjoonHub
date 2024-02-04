import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    static int N,M;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        A=new int[N];
        A=Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M=Integer.parseInt(br.readLine());
        B=new int[M];
        B=Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);
        for(int i=0;i<M;i++){
            BS(0,N-1,B[i]);
        }
    }
    static void BS(int start,int end,int num){
        if(start>end) {
            System.out.println(0);
            return;
        }
        int mid=(end+start)/2;
        if(A[mid]==num){
            System.out.println(1);
            return;
        }

        if(A[mid]<num) BS(mid+1,end,num);
        else if (A[mid]>num) BS(start,mid-1,num);
    }
}
