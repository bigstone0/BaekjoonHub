import java.io.*;
import java.util.*;

public class Main {
    static class node {
        int index;
        int weight;

        node(int index, int weight) {
            this.weight = weight;
            this.index = index;
        }
    }

    static int V, E, K;
    static ArrayList<node>[] course;
    static boolean[] visted;
    static int[] value;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        course = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            course[i] = new ArrayList<>();
        }
        visted = new boolean[V + 1];
        value = new int[V + 1];
        Arrays.fill(value, Integer.MAX_VALUE);
        value[K]=0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            course[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra(K, 0);

        for(int i=1;i< value.length;i++){
            if(value[i]==Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(value[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void dijkstra(int index, int sum) {
        for (int i = 0; i < course[index].size(); i++) {
            value[course[index].get(i).index] = Math.min(course[index].get(i).weight + sum,value[course[index].get(i).index]);
        }
        node min=new node(0,Integer.MAX_VALUE);
        visted[index]=true;

        for(int i=1;i< value.length;i++){
            if(!visted[i]&&(min.weight>value[i])){
                min.index=i;
                min.weight=value[i];
            }
        }

        if(min.index!=0) dijkstra(min.index, min.weight);
    }
}
