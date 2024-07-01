import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, D;

    static class node {
        int reach;
        int value;

        public node(int reach, int value) {
            this.reach = reach;
            this.value = value;
        }
    }

    static ArrayList<node>[] road = new ArrayList[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        D = Integer.parseInt(st.nextToken(" "));
        for (int i = 0; i <= D; i++) road[i] = new ArrayList<>();
        int[] result = new int[10001];
        for (int i = 0; i < result.length; i++) result[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken(" "));
            int end = Integer.parseInt(st.nextToken(" "));
            int num = Integer.parseInt(st.nextToken(" "));
            if (end > D) continue;

            road[start].add(new node(end, num));
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) result[i] = Math.min(result[i], result[i - 1] + 1);
            for (int j = 0; j < road[i].size(); j++) {
                result[road[i].get(j).reach] = Math.min(result[road[i].get(j).reach], road[i].get(j).value + result[i]);
            }
        }

        System.out.println(result[D]);
    }
}
