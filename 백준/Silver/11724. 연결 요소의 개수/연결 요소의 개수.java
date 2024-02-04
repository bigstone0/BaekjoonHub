import java.util.*;
import java.io.*;

//silver2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i < list.length; i++) {
            if ((!list[i].isEmpty()&& q.isEmpty())) {
                q.add(i);
            }
            if(list[i].isEmpty()){
                count++;
            }
        }

        while (!q.isEmpty()) {
            while (true) {
                int node = q.poll();
                int size = list[node].size();
                for (int i = 0; i < size; i++) {
                    int list_node = list[node].get(0);
                    q.add(list_node);
                    list[list_node].remove(Integer.valueOf(node));
                    list[node].remove(Integer.valueOf(list_node));
                }
                if (q.isEmpty()) {
                    count++;
                    break;
                }
            }
            for (int i = 0; i < list.length; i++) {
                if (!list[i].isEmpty()) {
                    q.add(i);
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
