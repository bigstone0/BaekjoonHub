import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashSet<String> list=new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String str = st.nextToken(",");
                list.remove(str);

            }
            bw.write(list.size() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
