import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] money;
    static int max = Integer.MIN_VALUE;
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken(" "));
            max = Math.max(max, money[i]);
        }
        M = Integer.parseInt(br.readLine());


        while (min <= max) {
            int mid = (min + max) / 2;
            int moneySum = 0;
            for (int i = 0; i < N; i++) {
                if (money[i] >= mid) moneySum += mid;
                else moneySum += money[i];
            }

            if (moneySum <= M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(max);
    }
}
