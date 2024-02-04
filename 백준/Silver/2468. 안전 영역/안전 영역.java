import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    static class Coor {
        int x;
        int y;

        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int rain = -1;
    static int MAX_COUNT = Integer.MIN_VALUE;
    static int count = Integer.MIN_VALUE;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] zone = new int[N][N];
        int[][] cloneZone = new int[N][N];

        for (int i = 0; i < N; i++) {
            zone[i] = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while (count != 0&&rain<=100) {
            rain++;
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (zone[i][j] <= rain) zone[i][j] = 0;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) cloneZone[i][j] = zone[i][j];
            }

            safeZone(cloneZone);
            if (MAX_COUNT < count) MAX_COUNT = count;
        }

        System.out.println(MAX_COUNT);
    }

    static void safeZone(int[][] zone) {
        Queue<Coor> q = new LinkedList<>();
        loopOut:
        for (int i = 0; i < zone.length; i++) {
            for (int j = 0; j < zone.length; j++) {
                if (zone[i][j] != 0) {
                    q.offer(new Coor(i, j));
                    zone[i][j] = 0;
                    count++;
                    break loopOut;
                }
            }
        }
        do {
            while (!q.isEmpty()) {
                Coor coor = q.poll();
                for (int i = 0; i < 4; i++) {
                    if (coor.x + dx[i] >= 0 && coor.x + dx[i] < zone.length && coor.y + dy[i] >= 0 && coor.y + dy[i] < zone.length) {
                        if (zone[coor.x + dx[i]][coor.y + dy[i]] != 0) {
                            q.offer(new Coor(coor.x + dx[i], coor.y + dy[i]));
                            zone[coor.x + dx[i]][coor.y + dy[i]] = 0;
                        }
                    }
                }
            }

            loopOut:
            for (int i = 0; i < zone.length; i++) {
                for (int j = 0; j < zone.length; j++) {
                    if (zone[i][j] != 0) {
                        q.offer(new Coor(i, j));
                        zone[i][j] = 0;
                        count++;
                        break loopOut;
                    }
                }
            }
        } while (!q.isEmpty());
    }

}
