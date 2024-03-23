import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int X,Y;
    static int[][] zone;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int cheeseCount=0;
    static boolean[][] vist;
    static int result=0;
    static class node{
        int x;
        int y;
        boolean flag;
        node(int x, int y,boolean flag){
            this.x=x;
            this.y=y;
            this.flag=flag;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        X=Integer.parseInt(st.nextToken());
        Y=Integer.parseInt(st.nextToken());
        zone=new int[X][Y];
        vist=new boolean[X][Y];

        for(int i=0;i<X;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<Y;j++){
                zone[i][j]=Integer.parseInt(st.nextToken());
                if(zone[i][j]==0) zone[i][j]=-1;
                if(zone[i][j]==1) cheeseCount++;
            }
        }
        zone[0][0]=0;
        vist[0][0]=true;
        setZero(0,0);

        while(cheeseCount!=0){
            Queue<node> q=new LinkedList<>();
            for(int i=0;i<X;i++){
                for(int j=0;j<Y;j++){
                    if(zone[i][j]==1){
                        int c=0;
                        boolean flag=false;
                        for(int k=0;k<4;k++){
                            int x=i+dx[k];
                            int y=j+dy[k];
                            if(x<0||x==X||y<0||y==Y) continue;
                            if(zone[x][y]==0) c++;
                            if(zone[x][y]==-1) flag=true;
                        }

                        if(c>=2){
                            q.offer(new node(i,j,flag));
                        }
                    }
                }
            }

            while(!q.isEmpty()){
                node n=q.poll();
                zone[n.x][n.y]=0;
                cheeseCount--;
                vist[n.x][n.y]=true;
                if(n.flag) setZero(n.x,n.y);
            }
            result++;
        }

        System.out.println(result);

    }
    static void setZero(int x, int y){
        Queue<Integer> qX=new LinkedList<>();
        Queue<Integer> qY=new LinkedList<>();
        qX.offer(x);
        qY.offer(y);

        while(!qX.isEmpty()){
            int xx=qX.poll();
            int yy=qY.poll();

            for(int i=0;i<4;i++){
                int nX=xx+dx[i];
                int nY=yy+dy[i];
                if(nX<0||nX==X||nY<0||nY==Y) continue;
                if(zone[nX][nY]==-1){
                    zone[nX][nY]=0;
                    qX.offer(nX);
                    qY.offer(nY);
                    vist[nX][nY]=true;
                }
            }
        }
    }
}
