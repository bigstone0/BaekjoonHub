import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] tree=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            tree[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        boolean[] check=new boolean[N+1];
        int[] parent=new int[N+1];

        dfs(tree,check,parent,1);
        for(int i=2;i<parent.length;i++) System.out.println(parent[i]);
    }

    static void dfs(ArrayList<Integer>[] tree, boolean[] check, int[] parent,int node){
        check[node]=true;
        for(int i=0;i<tree[node].size();i++){
            if(!check[tree[node].get(i)]){
                parent[tree[node].get(i)]=node;
                dfs(tree,check,parent,tree[node].get(i));
            }
        }
    }
}
