import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int n,m;
    static int[][] map;
    static Queue<person> q=new LinkedList<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int result=Integer.MAX_VALUE;
    static boolean[][][] vist;
    static class person{
        int x;
        int y;
        int count;
        int broken;
        person(int x, int y, int count,int broken){
            this.x=x;
            this.y=y;
            this.count=count;
            this.broken=broken;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        vist=new boolean[2][n][m];

        for(int i=0;i<n;i++){
            map[i]=Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        if(n==1&&m==1) result=1;
        else{
            q.offer(new person(0,0,1,0));
            vist[0][0][0]=true;
            bfs();
        }


        if(result==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    static void bfs(){
        while(!q.isEmpty()){
            person p=q.poll();
            int x=p.x;
            int y=p.y;
            int count=p.count;
            int broken=p.broken;

            for(int i=0;i<4;i++){
                if(x+dx[i]<0||x+dx[i]==n||y+dy[i]<0||y+dy[i]==m) continue;
                if(map[x+dx[i]][y+dy[i]]==0&&!vist[broken][x+dx[i]][y+dy[i]]){
                    if(x+dx[i]==n-1&&y+dy[i]==m-1) {
                        result=Math.min(result,count+1);
                        return;
                    }
                    else{
                        q.offer(new person(x+dx[i],y+dy[i],count+1,broken));
                        vist[broken][x+dx[i]][y+dy[i]]=true;
                    }
                } else if (map[x+dx[i]][y+dy[i]]==1&&!vist[broken][x+dx[i]][y+dy[i]]) {
                    if(broken==0){
                        q.offer(new person(x+dx[i],y+dy[i],count+1,1));
                        vist[broken][x+dx[i]][y+dy[i]]=true;
                    }
                }
            }
        }
    }
}
