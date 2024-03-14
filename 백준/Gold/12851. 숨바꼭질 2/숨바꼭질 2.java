import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int subin,sister;
    static boolean[] vist=new boolean[100001];
    static Queue<position> q=new LinkedList<>();
    static int num=0;
    static int min=Integer.MAX_VALUE;
    static class position{
        int index;
        int count;
        position(int index, int count){
            this.index=index;
            this.count=count;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        subin=Integer.parseInt(st.nextToken());
        sister=Integer.parseInt(st.nextToken());

        q.offer(new position(subin, 0));
        vist[subin]=true;
        bfs();

        bw.write(min+"\n"+num);
        bw.flush();
        bw.close();
    }

    static void bfs(){
        while(!q.isEmpty()){
            position posi=q.poll();
            vist[posi.index]=true;
            if(posi.index==sister){
                if(posi.count==min) num++;
                else if(posi.count<min){
                    num++;
                    min=posi.count;
                }
            }

            if(min==Integer.MAX_VALUE){
                if(posi.index+1<=100000&&!vist[posi.index+1]) {
                    q.offer(new position(posi.index+1, posi.count+1));
                }
                if(posi.index!=0&&!vist[posi.index-1]) {
                    q.offer(new position(posi.index-1, posi.count+1));
                }
                if(posi.index!=0&&posi.index*2<=100000&&!vist[posi.index*2]) {
                    q.offer(new position(posi.index*2, posi.count+1));
                }
            }
        }
    }
}
