import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    static int COUNT = 0;
    static int MAX_COUNT = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] board=new int[R][C];
        checked=new boolean[26];

        for (int i = 0; i < R; i++) {
            String[] line=bf.readLine().split("");
            for(int j=0;j<C;j++){
                String alp=line[j];
                board[i][j]=alp.charAt(0)-'A';
            }
        }

        dfs(board, 0, 0);
        System.out.println(MAX_COUNT);
    }

    static void dfs(int[][] board, int x, int y) {
        checked[board[x][y]]=true;
        COUNT++;
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < board.length && y + dy[i] >= 0 && y + dy[i] < board[0].length && !checked[board[x + dx[i]][y + dy[i]]]) {
                dfs(board, x + dx[i], y + dy[i]);
            }
        }
        checked[board[x][y]]=false;
        if (MAX_COUNT < COUNT) MAX_COUNT = COUNT;
        COUNT--;
    }
}
