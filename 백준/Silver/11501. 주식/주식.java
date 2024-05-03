import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken(" "));

        for (int i = 0; i < T; i++) {
            long result = 0;
            int[] list = new int[Integer.parseInt(br.readLine())];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < list.length; j++) list[j] = Integer.parseInt(st.nextToken(" "));
            int max = list[list.length - 1];
            for (int j = list.length - 2; j >= 0; j--) {
                if (max < list[j]) {
                    max = list[j];
                } else {
                    result += max - list[j];
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
