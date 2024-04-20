import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] room;
    static boolean[][] sit;
    static int[][] person;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        room = new int[N][N];
        sit = new boolean[N][N];
        person = new int[N * N][7];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                person[i][j] = Integer.parseInt(st.nextToken(" "));
            }
        }

        room[1][1] = person[0][0];
        sit[1][1] = true;
        person[0][5] = 1;
        person[0][6] = 1;


        for (int i = 1; i < N * N; i++) {
            search(person[i], i);
        }

        int result = 0;
        for (int i = 0; i < N * N; i++) {
            int count = 0;
            for (int k = 0; k < 4; k++) {
                if (person[i][5] + dx[k] < 0 || person[i][5] + dx[k] == N || person[i][6] + dy[k] < 0 || person[i][6] + dy[k] == N) continue;
                for (int l = 1; l < 5; l++) {
                    if (room[person[i][5] + dx[k]][person[i][6] + dy[k]] == person[i][l]) {
                        count++;
                        break;
                    }
                }
            }
            if (count == 1) result += 1;
            else if (count == 2) result += 10;
            else if (count == 3) result += 100;
            else if (count == 4) result += 1000;
        }

        System.out.println(result);
    }

    static void search(int[] array, int index) {
        int x = -1;
        int y = -1;
        int friendNum = -1;
        int empty = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sit[i][j]) continue;
                int tempFriendNum = 0;
                int tempEmpty = 0;
                for (int k = 0; k < 4; k++) {
                    if (i + dx[k] < 0 || i + dx[k] == N || j + dy[k] < 0 || j + dy[k] == N) continue;
                    if (room[i + dx[k]][j + dy[k]] == 0) {
                        tempEmpty++;
                        continue;
                    }
                    for (int l = 1; l < 5; l++) {
                        if (room[i + dx[k]][j + dy[k]] == array[l]) {
                            tempFriendNum++;
                            break;
                        }
                    }
                }
                if (tempFriendNum > friendNum) {
                    x = i;
                    y = j;
                    friendNum = tempFriendNum;
                    empty = tempEmpty;
                } else if (tempFriendNum == friendNum) {
                    if (tempEmpty > empty) {
                        x = i;
                        y = j;
                        friendNum = tempFriendNum;
                        empty = tempEmpty;
                    }
                }
            }
        }
        room[x][y] = array[0];
        sit[x][y] = true;
        person[index][5] = x;
        person[index][6] = y;
    }
}
