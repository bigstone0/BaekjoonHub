import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer>[] party;
    static Set<Integer>[] sets;
    static boolean[] check = new boolean[51];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = M;
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) party[i] = new ArrayList<>();

        sets = new Set[N + 1];
        for (int i = 0; i < N + 1; i++) sets[i] = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int tCount = Integer.parseInt(st.nextToken());
        if (tCount == 0) {
            System.out.println(result);
            return;
        }
        int first = Integer.parseInt(st.nextToken());
        list.add(first);
        check[first] = true;
        for (int i = 0; i < tCount - 1; i++) {
            sets[first].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= nums[0]; j++) {
                party[i].add(nums[j]);
            }
            for (int j = 0; j < party[i].size(); j++) {
                for (int k = 0; k < party[i].size(); k++) {
                    sets[party[i].get(j)].add(party[i].get(k));
                }
            }
        }

        select(first);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < party[i].size(); j++) {
                if (list.contains(party[i].get(j))) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static void select(int index) {
        Iterator<Integer> iter = sets[index].iterator();
        while (iter.hasNext()) {
            int num = iter.next();
            if (!check[num]) {
                list.add(num);
                check[num] = true;
                select(num);
            }
        }
    }
}
