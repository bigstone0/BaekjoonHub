import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[1001];
        int min = 1001;
        int max = 0;
        int center = 0;
        int result = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken(" "));
            int H = Integer.parseInt(st.nextToken(" "));
            list[L] = Math.max(H, list[L]);
            min = Math.min(min, L);
            max = Math.max(max, L);
            if (list[center] < H) center = L;
        }

        int start = min;
        if (center != min) {
            for (int i = min; i <= center; i++) {
                if (list[i] >= list[start]) {
                    result += list[start] * (i - start);
                    start = i;
                }
            }
        }

        if (center != max) {
            start = max;
            for (int i = max; i >= center; i--) {
                if (list[i] >= list[start]) {
                    result += list[start] * (start - i);
                    start = i;
                }
            }
        }

        result += list[center];

        System.out.println(result);

    }
}
