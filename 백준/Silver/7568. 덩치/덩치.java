import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] list = new int[T][2];
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken(" "));
            int y = Integer.parseInt(st.nextToken(" "));
            list[i][0] = x;
            list[i][1] = y;
        }

        int count = 0;
        for (int i = 0; i < T; i++) {
            int grade = 1;
            for (int j = 0; j < T; j++) {
                if (i == j) continue;
                if (list[i][0] < list[j][0] && list[i][1] < list[j][1]) grade++;
            }
            result[i] = grade;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < T; i++) bw.write(result[i] + "\n");
        bw.flush();
        bw.close();
    }
}
