import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static class con {
        int num;
        boolean robot;

        public con(int num, boolean robot) {
            this.num = num;
            this.robot = robot;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int K = Integer.parseInt(st.nextToken(" "));
        int result = 0;
        LinkedList<con> list = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) list.addLast(new con(Integer.parseInt(st.nextToken(" ")), false));

        loopOut:
        while (true) {
            result++;
            //1
            list.addFirst(list.removeLast());

            //2
            for (int i = N - 1; i >= 0; i--) {
                if (i == N - 1 && list.get(i).robot) list.get(i).robot = false;
                else if (i != N - 1 && list.get(i).robot) {
                    if (!list.get(i + 1).robot && list.get(i + 1).num > 0) {
                        list.get(i).robot = false;
                        list.get(i + 1).robot = true;
                        list.get(i + 1).num--;
                        if (list.get(i + 1).num == 0) K--;
                        if (K == 0) break loopOut;
                        if (i + 1 == N - 1) list.get(i + 1).robot = false;
                    }
                }
            }

            //3
            if (list.get(0).num != 0) {
                list.get(0).robot = true;
                list.get(0).num--;
                if (list.get(0).num == 0) K--;
                if (K == 0) break loopOut;
            }
        }

        System.out.println(result);
    }
}
