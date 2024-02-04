import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int count=Integer.MIN_VALUE;

    static class Coor{
        int x;
        int y;
        Coor(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            count=0;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int[][] map = new int[h][w];

            if (w == 0 && h == 0) break;

            for (int i = 0; i < h; i++) {
                map[i] = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            bfs(map);
            System.out.println(count);
        }
    }

    static void bfs(int[][] map){
        Queue<Coor> q=new LinkedList<>();

        loopOut:
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]==1){
                    map[i][j]=0;
                    q.offer(new Coor(i,j));
                    count++;
                    break loopOut;
                }
            }
        }

        do{
            while(!q.isEmpty()){
                Coor coor=q.poll();
                for(int i=0;i<8;i++){
                    if(coor.x+dx[i]>=0&&coor.x+dx[i]<map.length&&coor.y+dy[i]>=0&&coor.y+dy[i]<map[0].length){
                        if(map[coor.x+dx[i]][coor.y+dy[i]]==1){
                            q.offer(new Coor(coor.x+dx[i],coor.y+dy[i]));
                            map[coor.x+dx[i]][coor.y+dy[i]]=0;
                        }
                    }
                }
            }

            loopOut:
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[0].length;j++){
                    if(map[i][j]==1){
                        map[i][j]=0;
                        q.offer(new Coor(i,j));
                        count++;
                        break loopOut;
                    }
                }
            }
        }while(!q.isEmpty());
    }
}
