import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] sum;
    static int sIndex = -1;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        sum = new int[N];
        S = Integer.parseInt(st.nextToken(" "));
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i == 0) sum[i] = Integer.parseInt(st.nextToken(" "));
            else {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken(" "));
            }
            if (sum[i] >= S && sIndex == -1) sIndex = i;
        }

        if (sIndex==0) {
            if (sum[0] >= S) System.out.println(1);
            else System.out.println(0);
            return;
        }

        if (sIndex == -1) {
            min = 0;
        } else {
            min=sIndex+1;
            for (int i = sIndex; i < N; i++) {
                search(i);
            }
        }

        System.out.println(min);

    }

    static void search(int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (sum[index] - sum[i] >= S) {
                min = Math.min(min, index - i);
                break;
            }
        }
    }
}



