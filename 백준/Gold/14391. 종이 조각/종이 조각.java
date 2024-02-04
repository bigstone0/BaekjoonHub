import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[][] board;
    static int N, M;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Stream.of(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < Math.pow(2, (N * M) + 1); i++) {
            int[][] t_board = new int[N][M];
            boolean[][] check = new boolean[N][M];
            int result = 0;

            t_board = change(i, t_board);

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!check[j][k]) {
                        if (t_board[j][k] == 1) {
                            int row_end = M;
                            for (int o = k + 1; o < M; o++) {
                                if (check[j][o]){
                                    row_end=o; break;
                                }
                                else{
                                    if(t_board[j][o]==0){
                                        row_end=o;
                                        break;
                                    }
                                }
                            }
                            int pow = 0;
                            for (int o = row_end - 1; o >= k; o--) {
                                result += board[j][o] * Math.pow(10, pow);
                                check[j][o] = true;
                                pow++;
                            }
                        } else {
                            int col_end = N;
                            for (int o = j + 1; o < N; o++) {
                                if (check[o][k]){
                                    col_end=o; break;
                                }
                                else{
                                    if(t_board[o][k]==1){
                                        col_end=o;
                                        break;
                                    }
                                }
                            }
                            int pow = 0;
                            for (int o = col_end - 1; o >= j; o--) {
                                result += board[o][k] * Math.pow(10, pow);
                                check[o][k] = true;
                                pow++;
                            }
                        }
                    }
                }
            }
            MAX = Math.max(MAX, result);
        }

        System.out.println(MAX);
    }

    static int[][] change(int num, int[][] t_board) {
        for (int i = 0; i < N * M; i++) {
            if ((num & (1 << i)) != 0) t_board[i / M][i % M] = 1;
        }

        return t_board;
    }
}
