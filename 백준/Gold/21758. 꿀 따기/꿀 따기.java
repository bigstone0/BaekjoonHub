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

        search();

        System.out.println(max);
    }

    static void search() {
        for (int i = 1; i < N + 1; i++) {
            bee[i] = true;
            for (int j = i + 1; j < N + 1; j++) {
                if (bee[j]) continue;
                bee[j] = true;
                go(i, j);
                bee[j] = false;
            }
            bee[i] = false;
        }
    }

    static void go(int bee1, int bee2) {
        for (int i = 1; i < N + 1; i++) {
            int result = 0;
            if (bee[i]) continue;
            if (i > bee1) {
                result += (map[i] - map[bee1]);
            } else {
                result += (map[bee1 - 1] - map[i - 1]);
            }

            if (i > bee2) {
                result += (map[i] - map[bee2]);
            } else {
                result += (map[bee2 - 1] - map[i - 1]);
            }

            if (bee2 < i && bee2 > bee1) result -= honey[bee2];
            else if (bee1 > i && bee1 < bee2) result -= honey[bee1];
            max = Math.max(max, result);
        }
    }
}



