import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//silver1
public class Main {
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int bitCount = 0;

        while (true) {
            if (K < (1 << bitCount)) {
                bitCount--;
                break;
            }
            bitCount++;
        }

        while (N != 0) {
            if (K == 0) break;

            if ((K & (1 << bitCount)) != 0) {
                K = K - (1 << bitCount);
                N--;
            }
            bitCount--;
        }

        if (K == 0) System.out.println(K);
        else System.out.println((1 << (bitCount + 1)) - K);
    }
}
