import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static long A,B;
    static class node{
        long index;
        long value;
        String indexString;
        node(long index, long value){
            this.index=index;
            this.value=value;
            this.indexString=String.valueOf(index);
        }
    }

    static boolean flag=false;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A=Long.parseLong(st.nextToken());
        B=Long.parseLong(st.nextToken());

        Queue<node> q=new LinkedList<>();
        q.offer(new node(A,1));

        if(A==B){
            System.out.print(1);
            flag=true;
        } else{
            while(!q.isEmpty()){
                node n=q.poll();
                long num=n.index*2;
                String s=n.indexString.concat("1");

                if(num<=B){
                    if(num==B) {
                        flag=true;
                        System.out.print(n.value+1);
                        break;
                    }
                    else{
                        q.offer(new node(num,n.value+1));
                    }
                }
                if (Long.parseLong(s)<=B) {
                    if(Long.parseLong(s)==B){
                        flag=true;
                        System.out.print(n.value+1);
                        break;
                    }
                    else{
                        q.offer(new node(Long.parseLong(s),n.value+1));
                    }
                }
            }
        }

        if(!flag) System.out.print(-1);
    }
}
