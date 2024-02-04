import java.io.*;
import java.util.*;
import java.util.stream.Stream;

// #15663(silver2)
public class Main {
    static int N, M;
    static int[] nums;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] check;
    static Set<String> s=new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        check = new boolean[N];

        sort();
        dfs(0, 0, new StringBuffer());

        bw.flush();
        bw.close();
    }

    static void sort() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    static void dfs(int index, int count, StringBuffer sb) throws IOException {
        if (count == M) {
            if(s.add(sb.toString())) bw.write(sb + "\n");
            return;
        }

        for (int i = index; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(i, count + 1, new StringBuffer(sb + "" + nums[i] + " "));
                check[i] = false;
            }
        }
    }
}
