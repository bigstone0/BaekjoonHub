import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int region, search, road;
    static int[] item;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        region = Integer.parseInt(st.nextToken());
        search = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());
        map = new int[region + 1][region + 1];
        for (int i = 1; i < map.length; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        item = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());
            int end1 = Integer.parseInt(st.nextToken());
            int end2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            map[end1][end2] = length;
            map[end2][end1] = length;
        }
        pm();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < region + 1; i++) {
            int result = 0;
            for (int j = 1; j < region + 1; j++) {
                if (map[i][j] != Integer.MAX_VALUE && map[i][j] <= search) result += item[j - 1];
            }
            result += item[i - 1];
            max = Math.max(max, result);
        }

        System.out.println(max);

    }

    static void pm() {
        for (int i = 1; i < region + 1; i++) {// 거치는 곳
            for (int j = 1; j < region + 1; j++) {// 출발
                for (int k = 1; k < region + 1; k++) {// 도착
                    if (map[j][i] == Integer.MAX_VALUE || map[i][k] == Integer.MAX_VALUE || j == k) continue;
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
    }
}
