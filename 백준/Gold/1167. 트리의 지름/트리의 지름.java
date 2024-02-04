import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static boolean[] vist;
    static int Amax = Integer.MIN_VALUE;
    static int Bmax = Integer.MIN_VALUE;
    static int node;
    static ArrayList<Node>[] tree;

    public static class Node{
        int e;
        int cost;
        public Node(int e,int cost){
            this.e=e;
            this.cost=cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        tree=new ArrayList[V+1];
        for(int i=1;i<V+1;i++){
            tree[i]=new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int index=Integer.parseInt(st.nextToken(" "));
            while(true){
                int num=Integer.parseInt(st.nextToken(" "));
                if(num==-1) break;
                tree[index].add(new Node(num,Integer.parseInt(st.nextToken(" "))));
            }
        }

        vist = new boolean[V+1];
        vist[1]=true;
        dfs(1, 0);
        vist = new boolean[V+1];
        vist[node]=true;
        dfs(node,0);

        System.out.println(Amax);
    }

    static void dfs(int index, int result) {
        if(result>Amax){
            Amax=result;
            node=index;
        }
        for(int i=0;i<tree[index].size();i++){
            if(!vist[tree[index].get(i).e]){
                vist[tree[index].get(i).e]=true;
                dfs(tree[index].get(i).e,result+tree[index].get(i).cost);
            }
        }
    }
}
