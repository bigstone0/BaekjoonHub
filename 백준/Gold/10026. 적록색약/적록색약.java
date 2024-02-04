import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final String[] colorCode = {"R", "G", "B"};

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
        int N = Integer.parseInt(st.nextToken());
        String[][] color = new String[N][N];

        for (int i = 0; i < N; i++) {
            color[i] = bf.readLine().split("");
        }
        colerArea(color);
        for (int i=0; i < color.length; i++) {
            for (int j = 0; j < color.length; j++) {
                if (color[i][j].equals("G")) color[i][j] = "R";
            }
        }
        System.out.print(" ");
        count=0;
        colerArea(color);
    }

    static void colerArea(String[][] color) {
        Queue<Coor> q = new LinkedList<>();
        String[][] cloneColor = new String[color.length][color.length];
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color.length; j++) cloneColor[i][j] = color[i][j];
        }

        for (int i = 0; i < 3; i++) {
            while (true) {
                q.offer(findColor(cloneColor, colorCode[i]));
                if (q.peek().x == -1) {
                    q.poll();
                    break;
                }
                cloneColor[q.peek().x][q.peek().y] = "N";
                while (!q.isEmpty()) {
                    Coor coor = q.poll();
                    for (int j = 0; j < 4; j++) {
                        if (coor.x + dx[j] >= 0 && coor.x + dx[j] < cloneColor.length && coor.y + dy[j] >= 0 && coor.y + dy[j] < cloneColor.length) {
                            if (cloneColor[coor.x + dx[j]][coor.y + dy[j]].equals(colorCode[i])) {
                                q.offer(new Coor(coor.x + dx[j], coor.y + dy[j]));
                                cloneColor[coor.x + dx[j]][coor.y + dy[j]] = "N";
                            }
                        }
                    }
                }
                count++;
            }
        }
        System.out.print(count);
    }

    static Coor findColor(String[][] color, String c) {
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color.length; j++) {
                if (color[i][j].equals(c)) return new Coor(i, j);
            }
        }
        return new Coor(-1, -1);
    }
}
