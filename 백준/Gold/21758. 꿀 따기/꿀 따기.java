import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] map;
    static boolean[] bee;
    static int[] honey;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bee = new boolean[N + 1];
        map = new int[N + 1];
        honey = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            map[i] = map[i - 1] + Integer.parseInt(st.nextToken(" "));
            honey[i] = map[i] - map[i - 1];
        }

        for (int i = 2; i < N; i++) {
            int sum = 0;
            sum = (map[N] - map[1]) + (map[N] - map[i]) - honey[i];
            max = Math.max(max, sum);
        }

        for (int i = N-1; i > 1; i--) {
            int sum = 0;
            sum = (map[i-1]) + (map[N-1]) - honey[i];
            max = Math.max(max, sum);
        }

        if (N != 3) search();
        else {
            for (int i = 1; i < 4; i++) max = Math.max(max, honey[i] * 2);
        }

        System.out.println(max);
    }

    static void search() {
        for (int i = 2; i < N; i++) {
            int result = 0;
            result += map[i] - map[1];
            result += map[N - 1] - map[i - 1];
            max = Math.max(max, result);
        }
    }
}



