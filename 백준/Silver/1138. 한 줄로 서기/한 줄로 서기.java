import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personNum = 0;
        personNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] person = new int[personNum];
        for (int i = 0; i < personNum; i++) person[i] = Integer.parseInt(st.nextToken(" "));
        int[] line = new int[personNum];
        for (int i = 0; i < personNum; i++) {
            int count = 0;
            for (int j = 0; j < personNum; j++) {
                if (count == person[i] && line[j] == 0) {
                    line[j] = i + 1;
                    break;
                } else if (count != person[i] && line[j] == 0) count++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < personNum; i++) {
            bw.write(line[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
