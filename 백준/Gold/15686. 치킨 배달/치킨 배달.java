import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int[][] city;

    static class node {
        int x;
        int y;

        node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<node> chicken = new ArrayList<>();
    static ArrayList<node> home = new ArrayList<>();
    static Stack<node> chickenSelect = new Stack<>();
    static boolean[] vist;
    static int[] distance;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                city[i][j] = num;
                if (num == 1) home.add(new node(i, j));
                else if (num == 2) chicken.add(new node(i, j));
            }
        }
        vist = new boolean[chicken.size()];
        distance = new int[home.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        minSum(0, M);

        System.out.println(result);

    }

    static void minDistance() {
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < chickenSelect.size(); i++) {
            for (int j = 0; j < home.size(); j++) {
                int min = Math.abs(chickenSelect.get(i).x - home.get(j).x) + Math.abs(chickenSelect.get(i).y - home.get(j).y);
                distance[j] = Math.min(distance[j], min);
            }
        }

        int sum = 0;
        for (int i = 0; i < distance.length; i++) sum = sum + distance[i];

        result = Math.min(result, sum);
    }

    static void minSum(int index, int count) {
        if (count == 0) {
            minDistance();
            return;
        }
        for (int i = index; i < chicken.size(); i++) {
            if (!vist[i]) {
                vist[i] = true;
                chickenSelect.push(chicken.get(i));
                minSum(i, count - 1);
                chickenSelect.pop();
                vist[i] = false;
            }
        }
    }
}
