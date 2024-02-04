import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    StringTokenizer st = new StringTokenizer(s);
    int N=Integer.parseInt(st.nextToken());
    int M=Integer.parseInt(st.nextToken());
    int V=Integer.parseInt(st.nextToken());

    boolean[] dfs_vistied=new boolean[N+1];
    boolean[] bfs_vistied=new boolean[N+1];
    ArrayList<Integer>[] list=new ArrayList[N+1];
    for(int i=0;i<=N;i++){
        list[i]=new ArrayList<Integer>();
    }

    for(int i=0;i<M;i++)
    {
        String n=bf.readLine();
        st = new StringTokenizer(n);
        int p_node=Integer.parseInt(st.nextToken());
        int s_node=Integer.parseInt(st.nextToken());
        list[p_node].add(s_node);
        list[s_node].add(p_node);
    }

    for(int i=1;i<=N;i++){
        Collections.sort(list[i]);
    }


    dfs(V,dfs_vistied,list);
    System.out.println();
    bfs(V,list,bfs_vistied);
    }
    static void dfs(int nodeIndex,boolean vist[],ArrayList<Integer>[] list){
        vist[nodeIndex]=true;

        System.out.print(nodeIndex + " ");

        for(int node : list[nodeIndex]){
            if(!vist[node]){
                dfs(node,vist,list);
            }
        }
    }

    static void bfs(int start, ArrayList<Integer>[] list, boolean[] vist){
        Queue<Integer> q=new LinkedList<Integer>();

        q.offer(start);

        vist[start]=true;

        while(!q.isEmpty()){
            int nodeIndex=q.poll();
            System.out.print(nodeIndex+" ");
            for(int i=0;i<list[nodeIndex].size();i++){
                int temp=list[nodeIndex].get(i);
                if(!vist[temp]){
                    vist[temp]=true;
                    q.offer(temp);
                }
            }
        }
    }
}