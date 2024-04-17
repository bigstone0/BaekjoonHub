import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Queue<Integer> q = new LinkedList<>();
    static int[] subject;
    static ArrayList<String>[] list;
    static boolean[] vist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        subject = new int[N + 1];
        list = new ArrayList[N + 1];
        vist = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String A = (st.nextToken(" "));
            int B = Integer.parseInt(st.nextToken(" "));

            list[B].add(A);
        }

        for (int i = 1; i < N + 1; i++) {
            if (list[i].size() == 0) {
                vist[i] = true;
                q.offer(i);
                q.offer(1);
                subject[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int count = q.poll();
            for (int i = 1; i < N + 1; i++) {
                if (vist[i]) continue;
                if (list[i].contains(String.valueOf(x))) list[i].remove(String.valueOf(x));
                if (list[i].size() == 0) {
                    vist[i] = true;
                    q.offer(i);
                    q.offer(count + 1);
                    subject[i] = count + 1;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < N + 1; i++) {
            bw.write(subject[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
