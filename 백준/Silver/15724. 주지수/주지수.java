import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken(" "));

        int[][] map = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                if (j == 1) map[i][j] = Integer.parseInt(st.nextToken(" "));
                else {
                    map[i][j] = Integer.parseInt(st.nextToken(" ")) + map[i][j - 1];
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < K; i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken(" "));
            int y1 = Integer.parseInt(st.nextToken(" "));
            int x2 = Integer.parseInt(st.nextToken(" "));
            int y2 = Integer.parseInt(st.nextToken(" "));

            for (int j = x1; j <= x2; j++) {
                result += (map[j][y2] - map[j][y1 - 1]);
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}



