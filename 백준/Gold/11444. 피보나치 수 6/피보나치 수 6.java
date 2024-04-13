import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {1, 0}};

        if (num == 0) System.out.println(0);
        else {
            long[][] result = sum(A, num);
            System.out.println(result[1][0] % MOD);
        }

    }

    static long[][] sum(long[][] A, long N) {
        if (N == 1) return A;

        long[][] temp = sum(A, N / 2);

        if (N % 2 == 0) {
            return mul(temp, temp);
        } else {
            return mul(mul(temp, temp), A);
        }
    }

    static long[][] mul(long[][] A, long[][] B) {
        long[][] temp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += (A[i][k] * B[k][j]);
                    temp[i][j] %= MOD;
                }
            }
        }

        return temp;
    }
}
