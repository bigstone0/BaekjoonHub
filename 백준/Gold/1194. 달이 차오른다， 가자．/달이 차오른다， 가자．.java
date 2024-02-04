import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static String[][] maze;
    static int[][][] value;
    static Queue<Coor> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;

    static class Coor {
        int x;
        int y;
        int k;

        Coor(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new String[N][M];
        value = new int[64][N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = bf.readLine().split("");
        }

        loopOut:
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j].equals("0")) {
                    q.offer(new Coor(i, j, 0));
                    break loopOut;
                }
            }
        }
        exit();
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void exit() {
        while (!q.isEmpty()) {
            Coor coor = q.poll();
            for (int i = 0; i < 4; i++) {
                if (coor.x + dx[i] >= N || coor.x + dx[i] < 0 || coor.y + dy[i] >= M || coor.y + dy[i] < 0 || value[coor.k][coor.x + dx[i]][coor.y + dy[i]] != 0)
                    continue;
                switch (maze[coor.x + dx[i]][coor.y + dy[i]]) {
                    case ".":
                    case "0":
                        q.offer(new Coor(coor.x + dx[i], coor.y + dy[i], coor.k));
                        value[coor.k][coor.x + dx[i]][coor.y + dy[i]] = value[coor.k][coor.x][coor.y] + 1;
                        break;
                    case "#":
                        break;
                    case "1":
                        value[coor.k][coor.x + dx[i]][coor.y + dy[i]] = value[coor.k][coor.x][coor.y] + 1;
                        min = Math.min(value[coor.k][coor.x + dx[i]][coor.y + dy[i]], min);
                    default:
                        int num = maze[coor.x + dx[i]][coor.y + dy[i]].charAt(0);
                        if (num >= 97 && num <= 102) {
                            num = num - 97;
                            q.offer(new Coor(coor.x + dx[i], coor.y + dy[i], coor.k | (1 << num)));
                            value[coor.k | (1 << num)][coor.x + dx[i]][coor.y + dy[i]] = value[coor.k][coor.x][coor.y] + 1;
                        } else {
                            num = num - 65;
                            if ((coor.k & (1 << num)) != 0) {
                                q.offer(new Coor(coor.x + dx[i], coor.y + dy[i], coor.k));
                                value[coor.k][coor.x + dx[i]][coor.y + dy[i]] = value[coor.k][coor.x][coor.y] + 1;
                            }
                        }
                }
            }
        }
    }
}
