import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static Stack<String> s = new Stack<>();
    static String[] st = new String[200];
    static int stCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer sb = new StringBuffer();
        st = str.split("");
        for (int i = 0; i < st.length; i++) {
            if (st[i].equals("(")) s.push(st[i]);
            else if (st[i].equals(")")) {
                while (!s.isEmpty() && !s.peek().equals("(")) {
                    sb.append(s.pop() + "");
                }
                s.pop();
            } else if (st[i].equals("+") || st[i].equals("-") || st[i].equals("/") || st[i].equals("*")) {
                while (!s.isEmpty() && pre(s.peek()) >= pre(st[i])) {
                    sb.append(s.pop());
                }
                s.push(st[i]);
            } else {
                sb.append(st[i] + "");
            }
        }

        while (!s.isEmpty()) sb.append(s.pop());

        System.out.println(sb);
    }

    static int pre(String op) {
        if (op.equals("*") || op.equals("/")) return 2;
        else if (op.equals("+") || op.equals("-")) return 1;
        else return 0;
    }
}
