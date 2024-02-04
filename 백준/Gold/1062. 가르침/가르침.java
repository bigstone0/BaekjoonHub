import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//gold4

public class Main {
    static ArrayList<String[]> word = new ArrayList<>();

    static int MAX_COUNT;
    static int flag;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                String wordSplit = bf.readLine();
                word.add(wordSplit.substring(4, wordSplit.length() - 4).split(""));
            }
            flag = 0;
            MAX_COUNT = 0;

            flag |= 1 << ('a' - 'a');
            flag |= 1 << ('n' - 'a');
            flag |= 1 << ('t' - 'a');
            flag |= 1 << ('i' - 'a');
            flag |= 1 << ('c' - 'a');
            back(0, 0, flag);
            System.out.println(MAX_COUNT);
        }
    }

    static void back(int idx, int start, int flag) {
        if (idx == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                int f = 0;
                for (int j = 0; j < word.get(i).length; j++) {
                    if(word.get(i)[j].equals("")) break;
                    if ((flag & 1 << (word.get(i)[j].charAt(0) - 'a')) == 0) {
                        f = 1;
                        break;
                    }
                }
                if (f == 0) count++;
            }
            MAX_COUNT = Math.max(MAX_COUNT, count);
            return;
        }
        for (int i = start; i < 26; i++) {
            if ((flag & 1 << i) != 0) continue;
            back(idx + 1, i + 1, flag | 1 << i);
        }
    }
}
