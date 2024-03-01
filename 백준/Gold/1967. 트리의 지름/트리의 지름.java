import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class node {
        int index;
        int value;

        node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static int n;
    static ArrayList<node>[] tree;
    static boolean[] vist;
    static int end;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        tree=new ArrayList[n+1];
        vist=new boolean[n+1];
        for(int i=0;i<n+1;i++){
            tree[i]=new ArrayList<node>();
        }
        StringTokenizer st;
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[x].add(new node(y,v));
            tree[y].add(new node(x,v));
        }

        result=Integer.MIN_VALUE;
        dfs(1,0);
        vist=new boolean[n+1];
        result=Integer.MIN_VALUE;
        dfs(end,0);

        System.out.println(result);
    }

    static void dfs(int start,int total){
        boolean flag=false;
        for(int i=0;i<tree[start].size();i++){
            if(!vist[tree[start].get(i).index]){
                vist[start]=true;
                dfs(tree[start].get(i).index,total+tree[start].get(i).value);
                flag=true;
            }
        }
        if(!flag&&total>result) {
            result=total;
            end=start;
        }
    }
}
