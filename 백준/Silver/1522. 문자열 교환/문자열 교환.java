import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static String[] str;
    static int numA = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split("");
        for (int i = 0; i < str.length; i++) if (str[i].equals("a")) numA++;

        for (int i = 0; i < str.length; i++) {
            int result = 0;
            for (int j = 0; j < numA; j++) {
                if (str[(i + j) % str.length].equals("b")) result++;
            }
            min = Math.min(min, result);
        }

        System.out.println(min);
    }
}
