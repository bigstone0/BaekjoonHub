import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] list = new int[3];
            list[0] = Integer.parseInt(st.nextToken(" "));
            list[1] = Integer.parseInt(st.nextToken(" "));
            list[2] = Integer.parseInt(st.nextToken(" "));
            if (list[0] == 0 && list[1] == 0 && list[2] == 0) break;
            Arrays.sort(list);
            if (list[0] + list[1] <= list[2]) {
                bw.write("Invalid" + "\n");
                continue;
            }
            if (list[2] == list[1]) {
                if (list[1] == list[0]) bw.write("Equilateral" + "\n");
                else bw.write("Isosceles" + "\n");
            } else {
                if (list[1] == list[0]) bw.write("Isosceles" + "\n");
                else {
                    bw.write("Scalene" + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
