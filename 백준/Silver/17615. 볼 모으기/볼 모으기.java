import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static int N;
    static String[] ball;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ball = br.readLine().split("");

        String left = ball[0];
        String right = "";
        int rightNum = 0;
        for (int i = ball.length - 1; i >= 0; i--) {
            if (!ball[i].equals(left)) {
                right = ball[i];
                rightNum = i;
                break;
            }
        }

        int result1 = 0;
        int result2 = 0;

        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < ball.length; i++) {
            if (ball[i].equals("R")) {
                count1++;
            } else {
                result1 += count1;
                count1 = 0;
            }

            if (ball[i].equals("B")) {
                count2++;
            } else {
                result2 += count2;
                count2 = 0;
            }
        }

        System.out.println(Math.min(result1, result2));
    }
}
