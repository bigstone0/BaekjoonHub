import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;
    static int sharkX, sharkY;
    static int sharkNum = 2;
    static int sharkStack = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        while (true) {
            boolean[][] vist = new boolean[N][N];
            if (!bfs(vist, map)) break;
        }

        System.out.println(time);
    }

    static boolean bfs(boolean[][] vist, int[][] map) {
        Queue<Integer> qX = new LinkedList<>();
        Queue<Integer> qY = new LinkedList<>();
        Queue<Integer> qNum = new LinkedList<>();
        qX.offer(sharkX);
        qY.offer(sharkY);
        qNum.offer(0);
        vist[sharkX][sharkY] = true;
        boolean eat = false;
        int tempX = 40;
        int tempY = 40;
        int tempNum = 500;
        while (!qX.isEmpty()) {
            int x = qX.poll();
            int y = qY.poll();
            int num = qNum.poll();
            if(num>tempNum) break;
            if (map[x][y] < sharkNum && map[x][y] > 0 && num <= tempNum && map[x][y]!=9) {
                eat = true;
                if (x < tempX) {
                    tempX = x;
                    tempY = y;
                    tempNum = num;
                } else if (tempX == x) {
                    if (y < tempY) {
                        tempY = y;
                        tempX = x;
                        tempNum = num;
                    }
                }
            }
            if (!eat) {
                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx == vist.length || yy < 0 || yy == vist.length || map[xx][yy] > sharkNum || vist[xx][yy])
                        continue;
                    qX.offer(xx);
                    qY.offer(yy);
                    qNum.offer(num + 1);
                    vist[xx][yy] = true;
                }
            }
        }
        if (eat) {
            time += (tempNum);
            map[sharkX][sharkY] = 0;
            sharkX = tempX;
            sharkY = tempY;
            map[sharkX][sharkY] = 9;
            sharkStack++;
            if (sharkStack == sharkNum) {
                sharkNum++;
                sharkStack = 0;
            }
        }
        return eat;
    }
}




