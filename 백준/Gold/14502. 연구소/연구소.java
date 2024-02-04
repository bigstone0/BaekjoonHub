import java.util.*;
import java.io.*;
import java.util.stream.Stream;

//gold4
public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int MAX_SIZE = Integer.MIN_VALUE;

    static class Coor {
        private int x;
        private int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            lab[i] = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(lab);
        System.out.println(MAX_SIZE);
    }

    static void bfs(int[][] lab) {
        int[][] cloneLab = new int[lab.length][lab[0].length];
        Queue<Coor> q = new LinkedList<>();
        int lifeCount = 0;

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                cloneLab[i][j] = lab[i][j];
                if (lab[i][j] == 2) {
                    q.offer(new Coor(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Coor coor = q.poll();
            for (int i = 0; i < 4; i++) {
                if (coor.x + dx[i] >= 0 && coor.x + dx[i] < cloneLab.length && coor.y + dy[i] >= 0 && coor.y + dy[i] < cloneLab[0].length) {
                    if (cloneLab[coor.x + dx[i]][coor.y + dy[i]] == 0) {
                        cloneLab[coor.x + dx[i]][coor.y + dy[i]] = 2;
                        q.offer(new Coor(coor.x + dx[i], coor.y + dy[i]));
                    }
                }
            }
        }

        for (int i = 0; i < cloneLab.length; i++) {
            for (int j = 0; j < cloneLab[0].length; j++) {
                if (cloneLab[i][j] == 0) lifeCount++;
            }
        }

        if (lifeCount > MAX_SIZE) MAX_SIZE = lifeCount;
    }

    static void dfs(int[][] lab) {
        if (count == 3) {
            bfs(lab);
            return;
        }
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    count++;
                    dfs(lab);
                    lab[i][j] = 0;
                    count--;
                }
            }
        }
    }
}
