import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][N];
        boolean[] check = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = N - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = N - 1; j >= 0; j--) {
                if (q.size() < N) {
                    q.add(list[i][j]);
                    flag = true;
                } else {
                    if (!check[j] && q.peek() < list[i][j]) {
                        q.poll();
                        q.offer(list[i][j]);
                        flag = true;
                    } else if (!check[j] && q.peek() >= list[i][j]) {
                        check[j] = true;
                    }
                }
            }
            if (!flag) break;
        }

        System.out.println(q.poll());

    }
}
