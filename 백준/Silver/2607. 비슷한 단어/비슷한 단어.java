import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] str = new String[N][11];
        int result = 0;

        for (int i = 0; i < str.length; i++) {
            Arrays.fill(str[i], "0");
        }
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine().split("");
        }

        for (int i = 1; i < N; i++) {
            int count = 0;
            loopOut:
            if (str[0].length > str[i].length) {
                boolean[] check = new boolean[str[i].length];
                for (int j = 0; j < str[0].length; j++) {
                    boolean flag = false;
                    for (int k = 0; k < str[i].length; k++) {
                        if (str[i][k].equals("0")) break;
                        if (str[0][j].equals(str[i][k]) && !check[k]) {
                            flag = true;
                            check[k] = true;
                            break;
                        }
                    }
                    if (!flag) count++;
                    if (count == 2) break;
                }
            } else {
                boolean[] check = new boolean[str[0].length];
                for (int j = 0; j < str[i].length; j++) {
                    boolean flag = false;
                    for (int k = 0; k < str[0].length; k++) {
                        if (str[0][k].equals("0")) break;
                        if (str[0][k].equals(str[i][j]) && !check[k]) {
                            flag = true;
                            check[k] = true;
                            break;
                        }
                    }
                    if (!flag) count++;
                    if (count == 2) break;
                }
            }
            if (count != 2) result++;
        }

        System.out.println(result);
    }
}
