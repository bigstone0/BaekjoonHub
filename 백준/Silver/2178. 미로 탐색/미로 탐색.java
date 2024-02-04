import java.util.*;
import java.io.*;
import java.util.stream.Stream;

//silver1

public class Main {
    static class Coor{
        private int x;
        private int y;

        public Coor(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int x=0, y=0;

        Queue<Coor> route=new LinkedList<>();

        int[][] maze=new int[N][M];
        int[][] dist=new int[N][M];
        dist[0][0]=1;

        for(int i=0;i<N;i++)
        {
            maze[i]= Stream.of(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        maze[x][y]=0;
        route.offer(new Coor(x,y));

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!route.isEmpty())
        {
            Coor po=route.poll();
            for(int i=0;i<4;i++)
            {
                if(((po.x+dr[i])>-1)&&((po.x+dr[i])<N)&&((po.y+dc[i])>-1)&&(po.y+dc[i])<M)
                {
                    if(maze[po.x+dr[i]][po.y+dc[i]]==1)
                    {
                        route.offer(new Coor(po.x+dr[i],po.y+dc[i]));
                        maze[po.x+dr[i]][po.y+dc[i]]=0;
                        dist[po.x+dr[i]][po.y+dc[i]]=dist[po.x][po.y]+1;
                    }
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}
