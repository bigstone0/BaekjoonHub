import java.io.*;
import java.util.*;

public class Main{
    static class node{
        String center;
        String right;
        String left;
        node(String center, String left, String right){
            this.left=left;
            this.right=right;
            this.center=center;
        }
    }
    static int N;
    static node[] tree;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        tree=new node[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            tree[i]=new node(st.nextToken(),st.nextToken(),st.nextToken());
        }

        first(0);
        bw.write("\n");
        center(0);
        bw.write("\n");
        end(0);

        bw.flush();
        bw.close();

    }

    static void first(int index) throws IOException{
        bw.write(tree[index].center);
        for(int i=0;i<N;i++){
            if(tree[i].center.equals(tree[index].left)){
                first(i);
            }
        }

        for(int i=0;i<N;i++){
            if(tree[i].center.equals(tree[index].right)){
                first(i);
            }
        }
    }

    static void center(int index) throws IOException{
        for(int i=0;i<N;i++){
            if(tree[i].center.equals(tree[index].left)){
                center(i);
            }
        }
        bw.write(tree[index].center);

        for(int i=0;i<N;i++){
            if(tree[i].center.equals(tree[index].right)){
                center(i);
            }
        }
    }

    static void end(int index) throws IOException{
        for(int i=0;i<N;i++){
            if(tree[i].center.equals(tree[index].left)){
                end(i);
            }
        }

        for(int i=0;i<N;i++){
            if(tree[i].center.equals(tree[index].right)){
                end(i);
            }
        }

        bw.write(tree[index].center);
    }
}








