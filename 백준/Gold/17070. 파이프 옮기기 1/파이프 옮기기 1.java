import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] map;
    static int count = 0;
    static boolean[][] vist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        vist = new boolean[n][n];
        for (int i = 0; i < n; i++) map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 1, 1);

        System.out.println(count);
    }

    static void dfs(int x, int y, int direction) {
        if (x == n - 1 && y == n - 1) {
            count++;
            return;
        }

        if (direction == 1) {
            int dx = x + 1;
            int dy = y + 1;
            if (dy < n && map[x][dy] != 1) {
                dfs(x, dy, 1);
            }
            if (dx < n && dy < n && map[x][dy] != 1 && map[dx][y] != 1 && map[dx][dy] != 1) {
                dfs(dx, dy, 3);
            }
        } else if (direction == 2) {
            int dx = x + 1;
            int dy = y + 1;
            if (dx < n && map[dx][y] != 1) {
                dfs(dx, y, 2);
            }
            if (dx < n && dy < n && map[x][dy] != 1 && map[dx][y] != 1 && map[dx][dy] != 1) {
                dfs(dx, dy, 3);
            }
        } else if (direction == 3) {
            int dx = x + 1;
            int dy = y + 1;
            if (dy < n && map[x][dy] != 1) {
                dfs(x, dy, 1);
            }
            if (dx < n && map[dx][y] != 1) {
                dfs(dx, y, 2);
            }
            if (dx < n && dy < n && map[x][dy] != 1 && map[dx][y] != 1 && map[dx][dy] != 1) {
                dfs(dx, dy, 3);
            }
        }
    }
}
