import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] A;
    static int[] desc;
    static int[][] aesc;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        aesc = new int[2][N];
        desc = new int[N];
        Arrays.fill(aesc[0], 1);
        Arrays.fill(aesc[1], 1);
        Arrays.fill(desc, 1);
        A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) max = bitonic(i, -1, 0);

        for (int j = 0; j < N; j++) {
            max = Math.max(max, desc[j]);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) max = Math.max(max, aesc[i][j]);
        }

        System.out.println(max);

    }

    static int bitonic(int index, int status, int flag) {
        if (status == 0 && desc[index] != 1) return desc[index] + 1;
        else if (status == 1 && aesc[flag][index] != 1) {
            return aesc[flag][index] + 1;
        }

        for (int i = index + 1; i < N; i++) {
            if (status == 0) {
                if (A[index] > A[i]) desc[index] = Math.max(desc[index], bitonic(i, 0, 1));
            } else if (status == 1) {
                if (A[index] < A[i]) aesc[flag][index] = Math.max(aesc[flag][index], bitonic(i, 1, 0));
                else if (A[index] > A[i] && flag == 0)
                    aesc[flag][index] = Math.max(aesc[flag][index], bitonic(i, 0, 1));
            } else if (status == -1) {
                if (A[index] > A[i]) desc[index] = Math.max(desc[index], bitonic(i, 0, 1));
                else if (A[index] < A[i]) aesc[flag][index] = Math.max(aesc[flag][index], bitonic(i, 1, 0));
            }
        }

        if (status == 0) return desc[index] + 1;
        else if (status == 1) return aesc[flag][index] + 1;
        else return -1;
    }
}
