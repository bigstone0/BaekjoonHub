import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, d, k, c, max;
    static int[] sushi;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        d = Integer.parseInt(st.nextToken(" "));
        k = Integer.parseInt(st.nextToken(" "));
        c = Integer.parseInt(st.nextToken(" "));
        sushi = new int[N];
        int[] check = new int[d + 1];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            q.add(sushi[i]);
            if (check[sushi[i]] == 0) {
                check[sushi[i]]++;
                result++;
            } else {
                check[sushi[i]]++;
            }
        }

        max = result;
        if (check[c] == 0) result++;

        for (int i = 0; i < N - 1; i++) {
            int num = q.poll();
            check[num]--;
            if (check[num] == 0) max--;

            q.add(sushi[(i + k) % N]);
            check[sushi[(i + k) % N]]++;
            if (check[sushi[(i + k) % N]] == 1) max++;

            if (check[c] == 0) {
                max++;
                result = Math.max(max, result);
                max--;
            } else result = Math.max(max, result);
        }

        System.out.println(result);
    }
}
