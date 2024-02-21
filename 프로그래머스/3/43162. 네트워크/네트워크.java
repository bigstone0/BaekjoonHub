import java.util.*;

class Solution {
    
        static Queue<Integer> q=new LinkedList<>();
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        check=new boolean[n];
        int answer=0;

        for(int i=0;i<n;i++){
            if(!check[i]) {
                q.offer(i);
                check[i]=true;
                bfs(computers,n);
                answer++;
            }
        }

        return answer;
    }
    
        static void bfs(int[][] com,int n){
        while(!q.isEmpty()){
            int num=q.poll();
            for(int i=0;i<n;i++){
                if(com[num][i]==1&&!check[i]){
                    q.offer(i);
                    check[i]=true;
                }
            }
        }
    }
}