import java.io.*;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] tops = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[num];
        Stack<Integer> length = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        result[0] = 0;
        length.push(tops[0]);
        nums.push(0);
        for (int i = 1; i < num; i++) {
            while (true) {
                if (length.isEmpty()) {
                    length.push(tops[i]);
                    nums.push(i);
                    result[i] = 0;
                    break;
                }
                if (length.peek() <= tops[i]) {
                    length.pop();
                    nums.pop();
                } else {
                    result[i] = nums.peek() + 1;
                    length.push(tops[i]);
                    nums.push(i);
                    break;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < num; i++) bw.write(result[i] + " ");

        bw.flush();
        bw.close();

    }
}
