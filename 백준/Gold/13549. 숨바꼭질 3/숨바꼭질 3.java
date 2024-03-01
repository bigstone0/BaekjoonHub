import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int result=Integer.MAX_VALUE;
    static class node{
        int index;
        int value;
        node(int index, int value){
            this.index=index;
            this.value=value;
        }
    }
    static boolean[] vist;
    static Queue<node> q=new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        vist=new boolean[100001];

        q.offer(new node(N,0));
        bfs();

        System.out.println(result);
    }

    static void bfs(){
        while(!q.isEmpty()){
            node n=q.poll();
            vist[n.index]=true;
            if(n.index==K){
                result=Math.min(result,n.value);
            }
            if(n.index*2<=100000&&!vist[n.index*2]&&n.index!=0) q.offer(new node(n.index*2,n.value));
            if(n.index+1<=100000&&!vist[n.index+1]) q.offer(new node(n.index+1,n.value+1));
            if(n.index-1>=0&&!vist[n.index-1]) q.offer(new node(n.index-1,n.value+1));
        }
    }
}
