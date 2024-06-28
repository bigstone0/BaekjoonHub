import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main{
    static int N,K;
    static int[] a;
    static int maxLength=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken(" "));
        K=Integer.parseInt(st.nextToken(" "));
        a= Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(N==1) System.out.println(1);
        else System.out.println(search()+1);
    }

    static int search(){
        int[] count=new int[100001];
        int start=0;
        count[a[0]]++;
        int end=1;
        int maxLength=Integer.MIN_VALUE;
        while(end!=N){
            count[a[end]]++;
            if(count[a[end]]>K){
                while(true){
                    count[a[start]]--;
                    start++;
                    if(start==end||count[a[end]]<=K) break;
                }
            }
            maxLength=Math.max(maxLength,end-start);
            end++;
        }

        return maxLength;
    }
}
