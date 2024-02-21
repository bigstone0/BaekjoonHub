import java.util.*;

class Solution {
    
        static Queue<Integer> q=new LinkedList<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visted=new boolean[300][300];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i=0;i<rectangle.length;i++){
            for(int j=0;j<rectangle[0].length;j++) rectangle[i][j]=rectangle[i][j]*2;
        }

        set(rectangle);

        q.offer(characterX*2);
        q.offer(characterY*2);
        q.offer(0);

        return bfs(rectangle,itemX*2,itemY*2);
    }
    
        static void set(int[][] rect){
        for(int i=0;i<rect.length;i++){
            for(int j=rect[i][0];j<=rect[i][2];j++){
                for(int k=rect[i][1];k<=rect[i][3];k++){
                    visted[k][j]=true;
                }
            }
        }

        for(int i=0;i<rect.length;i++){
            for(int j=rect[i][0]+1;j<rect[i][2];j++){
                for(int k=rect[i][1]+1;k<rect[i][3];k++){
                    visted[k][j]=false;
                }
            }
        }
    }
    
        static int bfs(int[][] rect, int itemX, int itemY){
        while(!q.isEmpty()){
            int x=q.poll();
            int y=q.poll();
            int count=q.poll();
            visted[y][x]=false;

            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];

                if(xx<0||yy<0) continue;
                if(xx==itemX&&yy==itemY) return count/2+1;
                if(visted[yy][xx]){
                    q.offer(xx);
                    q.offer(yy);
                    q.offer(count+1);
                }
            }
        }
        return -1;
    }
}