import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int teasu = Integer.parseInt(st.nextToken(" "));
        int P = Integer.parseInt(st.nextToken(" "));

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken(" "));
        int count = 0;
        int grade = 1;

        for (int i = 0; i < N; i++) {
            if (teasu < list[i]) {
                count++;
                grade++;
            } else if (teasu > list[i]) break;
            else count++;
        }
        if (count == P) System.out.println(-1);
        else System.out.println(grade);
    }
}
