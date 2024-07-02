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

        int count1 = 0;
        int result1 = N;
        int result2 = N;
        int result = 0;

        for (int i = 0; i < ball.length; i++) {
            if (ball[i].equals("R")) {
                count1++;
            } else {
                result1 -= count1;
                count1 = 0;
                for (int j = i; j < ball.length; j++) {
                    if (ball[j].equals("B")) count1++;
                }
                result1 -= count1;
                break;
            }
        }
        count1 = 0;

        for (int i = ball.length - 1; i >= 0; i--) {
            if (ball[i].equals("R")) {
                count1++;
            } else {
                result2 -= count1;
                count1 = 0;
                for (int j = i; j >= 0; j--) {
                    if (ball[j].equals("B")) count1++;
                }
                result2 -= count1;
                break;
            }
        }

        result = Math.min(result1, result2);
        result1 = N;
        result2 = N;
        count1 = 0;

        for (int i = 0; i < ball.length; i++) {
            if (ball[i].equals("B")) {
                count1++;
            } else {
                result1 -= count1;
                count1 = 0;
                for (int j = i; j < ball.length; j++) {
                    if (ball[j].equals("R")) count1++;
                }
                result1 -= count1;
                break;
            }
        }
        count1 = 0;
        result = Math.min(result, result1);

        for (int i = ball.length - 1; i >= 0; i--) {
            if (ball[i].equals("B")) {
                count1++;
            } else {
                result2 -= count1;
                count1 = 0;
                for (int j = i; j >= 0; j--) {
                    if (ball[j].equals("R")) count1++;
                }
                result2 -= count1;
                break;
            }
        }
        result = Math.min(result, result2);

        System.out.println(result);
    }
}
