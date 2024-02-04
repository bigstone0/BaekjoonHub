import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int MAX=Integer.MIN_VALUE;
    static int bangMax=Integer.MIN_VALUE;
    static int[][] room;
    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {-1, 0, 1, 0};
    static boolean[][] check;
    static ArrayList<Integer> bang=new ArrayList<>();

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[M][N];
        check = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            room[i] = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int roomNum = -1;
        while (true) {
            boolean flag = false;
            loopOut:
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check[i][j]) {
                        bfs(i, j, roomNum += 1);
                        flag = true;
                        break loopOut;
                    }
                }
            }
            if (!flag) break;
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                maxBfs(i,j);
            }
        }

        System.out.println(bang.size()+"\n"+bangMax+"\n"+MAX);
    }

    static void bfs(int x, int y, int num) {
        Queue<Coor> q = new LinkedList<>();
        q.offer(new Coor(x, y));
        int count=0;

        while (!q.isEmpty()) {
            Coor coor = q.poll();
            check[coor.x][coor.y]=true;
            count++;

            for (int i = 0; i < 4; i++) {
                if ((room[coor.x][coor.y] & (1 << i)) == 0) {
                    if (!check[coor.x + dx[i]][coor.y + dy[i]]) {
                        q.offer(new Coor(coor.x + dx[i], coor.y + dy[i]));
                        check[coor.x+dx[i]][coor.y+dy[i]] = true;
                    }
                }
            }
            room[coor.x][coor.y]=num;
        }

        bangMax=Math.max(bangMax,count);
        bang.add(count);
    }

    static void maxBfs(int x,int y){
        if(y+dy[2]!=room[0].length){
            if(room[x][y]!=room[x+dx[2]][y+dy[2]]){
                MAX=Math.max(MAX,bang.get(room[x][y])+bang.get(room[x+dx[2]][y+dy[2]]));
//                System.out.println(bang.get(room[x][y])+","+bang.get(room[x+dx[2]][y+dy[2]]));
            }
        }
        if(x+dx[3]!=room.length){
            if(room[x][y]!=room[x+dx[3]][y+dy[3]]){
                MAX=Math.max(MAX,bang.get(room[x][y])+bang.get(room[x+dx[3]][y+dy[3]]));
//                System.out.println(bang.get(room[x][y])+","+bang.get(room[x+dx[3]][y+dy[3]]));
            }
        }
    }
}
