import java.util.*;
import java.io.*;
import java.util.stream.Stream;

//gold5
public class Main {
    static class Coor {
        int x;
        int y;

        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int day=0;
        int count=0;

        int[][] field = new int[N][M];
        for (int i = 0; i < N; i++) {
            field[i] = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(field[i][j]==0) count++;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Coor> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 1) q.offer(new Coor(i,j));
            }
        }

        while (!q.isEmpty()) {
            Coor c=q.poll();
            day=day+1;
            int x=c.x;
            int y=c.y;
            for(int i=0;i<4;i++){
                if((x+dr[i]<N)&&(x+dr[i]>-1)&&(y+dc[i]<M)&&(y+dc[i]>-1)) {
                    if(field[x+dr[i]][y+dc[i]]==0){
                        q.offer(new Coor(x+dr[i],y+dc[i]));
                        field[x+dr[i]][y+dc[i]]=field[x][y]+1;
                        count--;
                    }
                }
            }
            if(q.isEmpty()){
                day=field[x][y]-1;
            }
        }
        
        if(count==0) System.out.println(day);
        else System.out.println(-1);
    }


}
