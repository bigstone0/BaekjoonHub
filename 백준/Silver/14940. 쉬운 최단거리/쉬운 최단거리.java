import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] vist;
    static Queue<Integer> q = new LinkedList();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        map = new int[n][m];
        vist = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken(" "));
                if (num == 1) map[i][j] = -1;
                else if (num == 2) {
                    q.offer(i);
                    q.offer(j);
                    vist[i][j] = true;
                    map[i][j] = 0;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        bfs();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= m || map[xx][yy] == 0 || vist[xx][yy]) continue;
                map[xx][yy] = map[x][y] + 1;
                vist[xx][yy] = true;
                q.offer(xx);
                q.offer(yy);
            }
        }
    }
}
