import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[10001][3];
        list[0][0] = 1;
        list[1][0] = 1;
        list[1][1] = 1;
        list[2][0] = 1;
        list[2][1] = 1;
        list[2][2] = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 3; j < num; j++) {
                list[j][0] = list[j - 1][0];
                list[j][1] = list[j - 2][0] + list[j - 2][1];
                list[j][2] = list[j - 3][0] + list[j - 3][1] + list[j - 3][2];
            }
            bw.write(list[num - 1][0] + list[num - 1][1] + list[num - 1][2] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
