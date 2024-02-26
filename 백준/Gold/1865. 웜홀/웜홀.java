import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int TC;

    static class node {
        int end;
        int value;

        node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }

    static ArrayList<ArrayList<node>> testCase;
    static int[] result;
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            testCase = new ArrayList<>();
            for(int o=0;o<=N;o++) testCase.add(new ArrayList<>());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                testCase.get(x).add(new node(y,v));
                testCase.get(y).add(new node(x,v));
            }
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                testCase.get(x).add(new node(y,-v));
            }

            String re = "NO";
            result = new int[N + 1];
            Arrays.fill(result, 987654321);
            if (bellman()) re = "YES";

            bw.write(re);
            if (i != TC - 1) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean bellman() {
        result[1] = 0;
        boolean update = false;
        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j<=N; j++) {
                for(node n : testCase.get(j)){
                    if(result[n.end]>result[j]+n.value){
                        result[n.end]=result[j]+n.value;
                        update=true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 1; i <= N; i++) {
                for(node n : testCase.get(i)){
                    if(result[n.end]>result[i]+n.value){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
