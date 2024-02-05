import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] list;
    static int result;
    static int max = Integer.MIN_VALUE;
    static boolean[] vist;
    static int[] node;

    static class Node {
        int road;
        int time;

        Node(int road, int time) {
            this.road = road;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        X = Integer.parseInt(st.nextToken(" "));
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken(" "))].add(new Node(Integer.parseInt(st.nextToken(" ")), Integer.parseInt(st.nextToken(" "))));
        }

        for (int i = 1; i <= N; i++) {
            if(i==X) continue;
            result=0;
            node=new int[N+1];
            vist=new boolean[N+1];
            Arrays.fill(node,Integer.MAX_VALUE);
//            vist[i]=true;
            node[i]=0;
            diij(i,X);

            node=new int[N+1];
            vist=new boolean[N+1];
            Arrays.fill(node,Integer.MAX_VALUE);
//            vist[X]=true;
            node[X]=0;
            diij(X,i);
            max=Math.max(max,result);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void diij(int index, int home) {
        if(index==home){
            result+=node[home];
            return;
        }

        for(int i=0;i<list[index].size();i++){
            if(vist[list[index].get(i).road]) continue;
            node[list[index].get(i).road]=Math.min(node[list[index].get(i).road],list[index].get(i).time+node[index]);
        }

        vist[index]=true;
        int min=Integer.MAX_VALUE;
        int num=index;

        for(int i=1;i<=N;i++){
            if(vist[i]) continue;
            if(min>node[i]){
                min=node[i];
                num=i;
            }
        }

        diij(num,home);
    }
}
