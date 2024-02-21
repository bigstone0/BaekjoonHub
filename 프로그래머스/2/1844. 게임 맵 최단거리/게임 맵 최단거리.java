import java.util.*;

class Solution {
        static Queue<Integer> q=new LinkedList<>();
    static int[][] count;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    public int solution(int[][] maps) {
        count=new int[maps.length][maps[0].length];
        q.offer(0);
        q.offer(0);
        for(int i=0;i<maps.length;i++){
            Arrays.fill(count[i],-1);
        }
        count[0][0]=0;

        bfs(maps);

        if(count[maps.length-1][maps[0].length-1]==-1) return count[maps.length-1][maps[0].length-1];
        else return count[maps.length-1][maps[0].length-1]+1;
    }
    
        static void bfs(int[][] maps){
        while(!q.isEmpty()){
            int x=q.poll();
            int y=q.poll();

            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];
                if(xx<maps.length&&xx>=0&&yy<maps[0].length&&yy>=0){
                    if(maps[xx][yy]==1&&count[xx][yy]==-1){
                        q.offer(xx);
                        q.offer(yy);
                        count[xx][yy]=count[x][y]+1;
                        if((xx==maps.length-1)&&(yy==maps[0].length-1)){
                            return;
                        }
                    }
                }
            }
        }
    }
}