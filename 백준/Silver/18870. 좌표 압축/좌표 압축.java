import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] X;
    static int[] clone;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        X = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> s=new HashSet<>();
        for(int i=0;i<N;i++) s.add(X[i]);

        clone=new int[s.size()];
        Iterator<Integer> iter=s.iterator();
        for(int i=0;i<s.size();i++) clone[i]=iter.next();
        Arrays.sort(clone);

        for(int i=0;i<N;i++){
            BS(0, clone.length-1, X[i]);
        }

        bw.flush();
        bw.close();
    }

    static void BS(int start, int end,int num) throws IOException{
        int mid=(start+end)/2;

        if(clone[mid]==num){
            bw.write(mid+" ");
            return;
        }

        if(clone[mid]>num) BS(start,mid-1,num);
        else if(clone[mid]<num) BS(mid+1,end,num);
    }
}
