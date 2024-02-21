import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int[][] clone = new int[wires.length - 1][2];
            int count = 0;
            for (int j = 0; j < wires.length; j++) {
                if (j != i) {
                    clone[count] = wires[j];
                    count++;
                }
            }
            min = Math.min(min, search(clone, wires[i], n));
        }

        return min;
    }
    
        static int search(int[][] clone, int[] del, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        int num = 0;

        q.offer(del[0]);
        check[del[0]] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            num++;
            for (int i = 0; i < clone.length; i++) {
                if (clone[i][0] == top && !check[clone[i][1]]) {
                    q.offer(clone[i][1]);
                    check[clone[i][1]] = true;
                } else if (clone[i][1] == top && !check[clone[i][0]]) {
                    q.offer(clone[i][0]);
                    check[clone[i][0]] = true;
                }
            }
        }

        check = new boolean[n + 1];
        q.offer(del[1]);
        check[del[1]] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            num--;
            for (int i = 0; i < clone.length; i++) {
                if (clone[i][0] == top && !check[clone[i][1]]) {
                    q.offer(clone[i][1]);
                    check[clone[i][1]] = true;
                } else if (clone[i][1] == top && !check[clone[i][0]]) {
                    q.offer(clone[i][0]);
                    check[clone[i][0]] = true;
                }
            }
        }

//        System.out.println(num);
        if (num < 0) return num * -1;
        else return num;
    }
}