import java.util.*;

class Solution {
        static Queue<String> q = new LinkedList<>();
    static Queue<Integer> c = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                q.offer(begin);
                c.offer(0);
                return bfs(words, target);
            }
        }

        return 0;
    }
    
        static int bfs(String[] words, String target) {
        while (!q.isEmpty()) {
            String word = q.poll();
            int count = c.poll();
            if (word.equals(target)) return count;
            for (int i = 0; i < words.length; i++) {
                int diff = 0;
                for (int j = 0; j < target.length(); j++) {
                    if (diff > 1) break;
                    if (word.charAt(j) != words[i].charAt(j)) diff++;
                }
                if (diff == 1) {
                    q.offer(words[i]);
                    c.offer(count + 1);
                }
            }
        }
        return 0;
    }
}