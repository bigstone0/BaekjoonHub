import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N,S;
    static int[] nums;
    static int count=0;
    static boolean[] vist;
    static Set<String> s=new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        nums= Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vist=new boolean[N];

        for(int i=0;i<N;i++){
            dfs(i,nums[i]);
        }

        System.out.println(count);
    }

    static void dfs(int index,int result){
        if(result==S) {
            count++;
        }
        for(int i=index+1;i<N;i++){
            if(!vist[i]){
                vist[i]=true;
                dfs(i,result+nums[i]);
                vist[i]=false;
            }
        }
    }
}
